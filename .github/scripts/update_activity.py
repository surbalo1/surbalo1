"""Writes the latest public GitHub activity into README.md between the ACTIVITY markers."""
import json
import os
import re
import urllib.request

USER = os.environ.get("GH_USER", "surbalo1")
TOKEN = os.environ.get("GITHUB_TOKEN", "")
MAX_ITEMS = 6


def fetch_events():
    req = urllib.request.Request(
        f"https://api.github.com/users/{USER}/events/public?per_page=50",
        headers={"Accept": "application/vnd.github+json", **({"Authorization": f"Bearer {TOKEN}"} if TOKEN else {})},
    )
    with urllib.request.urlopen(req, timeout=30) as resp:
        return json.load(resp)


def repo_link(event):
    name = event["repo"]["name"]
    return f"[{name}](https://github.com/{name})"


def describe(event):
    kind, payload = event["type"], event.get("payload", {})
    repo = repo_link(event)
    if kind == "PushEvent":
        n = payload.get("size") or len(payload.get("commits", [])) or 1
        return f"🔨 Pushed {n} commit{'s' if n != 1 else ''} to {repo}"
    if kind == "PullRequestEvent":
        pr = payload.get("pull_request", {})
        action = "Merged" if payload.get("action") == "closed" and pr.get("merged") else payload.get("action", "").capitalize()
        if action not in {"Opened", "Merged"}:
            return None
        num = pr.get("number") or payload.get("number")
        return f"🔀 {action} PR [#{num}](https://github.com/{event['repo']['name']}/pull/{num}) in {repo}"
    if kind == "CreateEvent" and payload.get("ref_type") == "repository":
        return f"✨ Created {repo}"
    if kind == "WatchEvent":
        return f"⭐ Starred {repo}"
    if kind == "ReleaseEvent":
        return f"🚀 Released {payload.get('release', {}).get('tag_name', '')} in {repo}"
    if kind == "IssuesEvent" and payload.get("action") in {"opened", "closed"}:
        issue = payload.get("issue", {})
        num = issue.get("number")
        return f"📝 {payload['action'].capitalize()} issue [#{num}](https://github.com/{event['repo']['name']}/issues/{num}) in {repo}"
    return None


def main():
    lines, seen = [], set()
    for event in fetch_events():
        text = describe(event)
        if text and text not in seen:
            seen.add(text)
            lines.append(f"{len(lines) + 1}. {text}")
        if len(lines) == MAX_ITEMS:
            break
    body = "\n".join(lines) if lines else "_No public activity yet._"

    with open("README.md", encoding="utf-8") as f:
        readme = f.read()
    new = re.sub(
        r"(<!--START_SECTION:activity-->\n).*?(\n<!--END_SECTION:activity-->)",
        lambda m: m.group(1) + body + m.group(2),
        readme,
        flags=re.S,
    )
    if new != readme:
        with open("README.md", "w", encoding="utf-8") as f:
            f.write(new)
        print("README updated")
    else:
        print("No changes")


if __name__ == "__main__":
    main()
