# Java OOP Project

A simple project to practice Object-Oriented Programming concepts in Java.

## What's covered

- Classes and Objects
- Constructors
- Encapsulation (getters/setters)
- Inheritance (extends)
- Polymorphism (method overriding)
- Abstract classes
- Interfaces

## Project structure

```
oop/
├── animals/
│   ├── Animal.java     (parent class)
│   ├── Dog.java        
│   ├── Cat.java        
│   └── Fish.java       (also implements Swimmer)
├── shapes/
│   ├── Shape.java      (abstract)
│   ├── Circle.java
│   └── Rectangle.java
├── bank/
│   └── BankAccount.java
├── interfaces/
│   └── Swimmer.java
└── Main.java
```

## How to run

```bash
javac Main.java animals/*.java shapes/*.java bank/*.java interfaces/*.java
java Main
```

## Notes

- Fish implements the Swimmer interface to show how interfaces work
- BankAccount shows encapsulation with private fields and validation
- All animals inherit from Animal class

## TODO

- [ ] Add more animals (Bird, Rabbit?)
- [ ] Add unit tests
- [ ] Maybe add a GUI later
