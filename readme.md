# 🧠 Turing Machine Implementation in Java

A complete implementation of a deterministic Turing Machine in Java, following object-oriented principles.

## 📋 Features
- ✅ Pure Java implementation
- ✅ Object-oriented design with clear separation of concerns
- ✅ Deterministic Turing Machine
- ✅ Infinite tape (dynamically expands as needed)
- ✅ Clean transition table using Java Records
- ✅ Two complete example programs

## 🏗️ Project Structure
``` text
turing-machine-java/
├── src/
│   └── turingmaschine/              # Package containing all source code
│       ├── Move.java                # Enum: LEFT/RIGHT movement directions
│       ├── Tape.java                # Class: Infinite tape with read/write head
│       ├── Table.java               # Class: Transition table with Map<Trigger, Action>
│       ├── Trigger.java             # Record: (state, read-symbol) transition trigger
│       ├── Action.java              # Record: (write, move, next-state) transition action
│       └── TM.java                  # Main controller: Orchestrates tape, table, state
├── bin/                             # Compiled class files (gitignored)
├── .gitignore                       # Excludes .class files and IDE configurations
├── README.md                        # This documentation file
├── run.bat                          # Windows batch script for easy execution
                         
```
## 🚀 Quick Start
Simply click on run.bat

## 📚 Core Components
1. Tape Class
Purpose: Implements the infinite tape with dynamic expansion

Key Methods: read(), write(char c), move(Move direction)

Features: Automatically adds blank cells when head moves beyond tape bounds

2. Table Class
Purpose: Stores transition rules as Map<Trigger, Action>

Key Methods: addTransition(), findAction()

Features: Uses Java Records for immutable Trigger/Action objects

3. TM Class
Purpose: Main controller that coordinates execution

Key Methods: step() (single step), run() (continuous execution)

Features: Step counter, HALT state detection, execution logging

## 🧪 Implemented Examples
Example
Decrements a binary number by 1.

Input: #11000# (binary 24)

Output: #10111# (binary 23)

States: S, R, L, W, HALT

Transitions: 12 rules implementing binary subtraction algorithm

## 🎮 Interactive Usage
``` java
// Create a custom Turing Machine
TM tm = new TM('#', 0, "101#", "S");

// Add your own transition rules
tm.table.addTransition("S", '1', '0', Move.RIGHT, "A");
tm.table.addTransition("A", '0', '1', Move.RIGHT, "HALT");

// Execute step by step
tm.step();  // Execute one step
tm.step();  // Execute another step

// Or run complete program
tm.run();   // Run until HALT state
```
## Sample Output
``` text
=== Example: Binary Decrement ===
Transition Table:
fromState | read | write | move | toState
----------|------|-------|------|--------
S         | #    | #     | LEFT   | S
S         | 1    | 0     | RIGHT  | R
...

First 3 steps:
Step 0: # 1 1 0 0 {0} # -- S
Step 1: # 1 1 0 {0} 1 # -- L
Step 2: # 1 1 {0} 1 1 # -- L

Full execution:
Starting TM execution...
Initial: # 1 1 0 0 0 {#} -- S
Step 0: # 1 1 0 0 {0} # -- S
...
Step 9: # 1 0 1 1 1 {#} -- HALT
Execution completed.
```
## 📖 Academic Context
This project was developed as part of Programmieren 2 Assignment at THM (Technische Hochschule Mittelhessen). It demonstrates:

1.Object-oriented programming principles

2.Theoretical computer science concepts

3.Software engineering best practices

4.Academic assignment completion standards

