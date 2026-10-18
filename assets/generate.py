"""Generates the animated SVGs used in README.md (light and dark versions).

Run: python3 assets/generate.py
"""
from pathlib import Path
from xml.sax.saxutils import escape

OUT = Path(__file__).parent
FONT = "-apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif"

THEMES = {
    "dark": dict(bg="#0d1117", box="#161b22", stroke="#30363d", text="#e6edf3", muted="#8b949e", wire="#30363d"),
    "light": dict(bg="#ffffff", box="#f6f8fa", stroke="#d0d7de", text="#1f2328", muted="#656d76", wire="#d0d7de"),
}

FLOW = [
    ("Sensor", "PCB & test"),
    ("Firmware", "C, MicroPython"),
    ("Connectivity", "MQTT, LoRa, BLE"),
    ("Cloud", "Microsoft Azure"),
    ("AI", "LLMs, RAG, agents"),
]

JOURNEY = [
    ("2022", "Chihuahua", "Electronics technician"),
    ("2023", "Chihuahua", "Sales & QA"),
    ("2024", "Chihuahua", "B.Sc. + solutions eng."),
    ("2025", "Germany", "Electrical intern"),
    ("2025", "Austin, TX", "Fulbright, Big Data & AI"),
    ("2025", "Chihuahua", "Systems integration"),
    ("2026", "Mexico City", "Microsoft CSA"),
]


def flow_svg(t):
    w, h = 960, 200
    bw, bh, gap = 150, 92, 36
    x0, y0 = (w - (5 * bw + 4 * gap)) / 2, 54
    parts = [
        f'<svg xmlns="http://www.w3.org/2000/svg" width="{w}" height="{h}" viewBox="0 0 {w} {h}" font-family="{FONT}">',
        "<defs>"
        '<linearGradient id="ai" x1="0" y1="0" x2="1" y2="1"><stop offset="0" stop-color="#0078D4"/><stop offset="1" stop-color="#A855F7"/></linearGradient>'
        '<filter id="glow" x="-50%" y="-50%" width="200%" height="200%"><feGaussianBlur stdDeviation="10"/></filter>'
        "</defs>",
        f'<rect width="{w}" height="{h}" rx="16" fill="{t["bg"]}"/>',
        f'<text x="{w/2}" y="32" text-anchor="middle" font-size="14" font-weight="600" fill="{t["muted"]}">From the board to the cloud</text>',
    ]
    for i in range(4):
        x1 = x0 + (i + 1) * bw + i * gap
        x2 = x1 + gap
        y = y0 + bh / 2
        parts.append(f'<line x1="{x1}" y1="{y}" x2="{x2}" y2="{y}" stroke="{t["wire"]}" stroke-width="2"/>')
        for k in range(2):
            parts.append(
                f'<circle r="3.5" fill="#00D9FF" cy="{y}">'
                f'<animate attributeName="cx" values="{x1};{x2}" dur="1.6s" begin="{i * 0.4 + k * 0.8:.1f}s" repeatCount="indefinite"/>'
                f'<animate attributeName="opacity" values="0;1;1;0" keyTimes="0;0.2;0.8;1" dur="1.6s" begin="{i * 0.4 + k * 0.8:.1f}s" repeatCount="indefinite"/>'
                "</circle>"
            )
    for i, (name, detail) in enumerate(FLOW):
        x = x0 + i * (bw + gap)
        cx = x + bw / 2
        last = i == len(FLOW) - 1
        if last:
            parts.append(
                f'<rect x="{x}" y="{y0}" width="{bw}" height="{bh}" rx="14" fill="url(#ai)" filter="url(#glow)">'
                '<animate attributeName="opacity" values="0.35;0.8;0.35" dur="2.4s" repeatCount="indefinite"/></rect>'
            )
            parts.append(f'<rect x="{x}" y="{y0}" width="{bw}" height="{bh}" rx="14" fill="url(#ai)"/>')
            fg, sub = "#ffffff", "#e9ddff"
        else:
            parts.append(f'<rect x="{x}" y="{y0}" width="{bw}" height="{bh}" rx="14" fill="{t["box"]}" stroke="{t["stroke"]}"/>')
            fg, sub = t["text"], t["muted"]
        parts.append(f'<text x="{x + 14}" y="{y0 + 24}" font-size="11" font-weight="600" fill="{sub}">0{i + 1}</text>')
        parts.append(f'<text x="{cx}" y="{y0 + 54}" text-anchor="middle" font-size="18" font-weight="700" fill="{fg}">{escape(name)}</text>')
        parts.append(f'<text x="{cx}" y="{y0 + 74}" text-anchor="middle" font-size="12" fill="{sub}">{escape(detail)}</text>')
    parts.append(
        f'<text x="{w/2}" y="{h - 18}" text-anchor="middle" font-size="13" fill="{t["muted"]}">'
        "I&#8217;ve worked on every box in this diagram.</text>"
    )
    parts.append("</svg>")
    return "".join(parts)


def journey_svg(t):
    w, h = 960, 250
    n = len(JOURNEY)
    pad = 70
    step = (w - 2 * pad) / (n - 1)
    ly = 128
    cycle = 10.0
    reveal = 6.0  # seconds to draw the full line
    parts = [
        f'<svg xmlns="http://www.w3.org/2000/svg" width="{w}" height="{h}" viewBox="0 0 {w} {h}" font-family="{FONT}">',
        f'<defs><linearGradient id="line" gradientUnits="userSpaceOnUse" x1="{pad}" y1="0" x2="{w - pad}" y2="0"><stop offset="0" stop-color="#F97316"/>'
        '<stop offset="0.5" stop-color="#0078D4"/><stop offset="1" stop-color="#A855F7"/></linearGradient></defs>',
        f'<rect width="{w}" height="{h}" rx="16" fill="{t["bg"]}"/>',
        f'<line x1="{pad}" y1="{ly}" x2="{w - pad}" y2="{ly}" stroke="{t["wire"]}" stroke-width="2"/>',
    ]
    length = w - 2 * pad
    a = reveal / cycle
    parts.append(
        f'<line x1="{pad}" y1="{ly}" x2="{w - pad}" y2="{ly}" stroke="url(#line)" stroke-width="4" stroke-linecap="round" '
        f'stroke-dasharray="{length}" stroke-dashoffset="{length}">'
        f'<animate attributeName="stroke-dashoffset" values="{length};0;0;{length}" keyTimes="0;{a:.3f};0.92;1" dur="{cycle}s" repeatCount="indefinite"/>'
        "</line>"
    )
    for i, (year, place, role) in enumerate(JOURNEY):
        x = pad + i * step
        t_on = (i / (n - 1)) * a
        k = f"0;{t_on:.3f};{min(t_on + 0.03, 0.9):.3f};0.92;1"
        last = i == n - 1
        up = i % 2 == 0
        ty = ly - 58 if up else ly + 40
        color = "#A855F7" if last else t["text"]
        parts.append(f'<g opacity="0"><animate attributeName="opacity" values="0;0;1;1;0" keyTimes="{k}" dur="{cycle}s" repeatCount="indefinite"/>')
        r = 9 if last else 6
        parts.append(f'<circle cx="{x}" cy="{ly}" r="{r}" fill="{t["bg"]}" stroke="url(#line)" stroke-width="3"/>')
        if last:
            parts.append(
                f'<circle cx="{x}" cy="{ly}" r="9" fill="none" stroke="#A855F7" stroke-width="2">'
                '<animate attributeName="r" values="9;20" dur="1.6s" repeatCount="indefinite"/>'
                '<animate attributeName="opacity" values="0.8;0" dur="1.6s" repeatCount="indefinite"/></circle>'
            )
        parts.append(f'<line x1="{x}" y1="{ly + (-10 if up else 10)}" x2="{x}" y2="{ly + (-24 if up else 24)}" stroke="{t["wire"]}" stroke-width="1.5"/>')
        parts.append(f'<text x="{x}" y="{ty}" text-anchor="middle" font-size="16" font-weight="700" fill="{color}">{year}</text>')
        parts.append(f'<text x="{x}" y="{ty + 17}" text-anchor="middle" font-size="12" font-weight="600" fill="{t["text"]}">{escape(role)}</text>')
        parts.append(f'<text x="{x}" y="{ty + 32}" text-anchor="middle" font-size="11" fill="{t["muted"]}">{escape(place)}</text>')
        parts.append("</g>")
    parts.append("</svg>")
    return "".join(parts)


if __name__ == "__main__":
    for name, t in THEMES.items():
        (OUT / f"flow-{name}.svg").write_text(flow_svg(t))
        (OUT / f"journey-{name}.svg").write_text(journey_svg(t))
    print("ok")
