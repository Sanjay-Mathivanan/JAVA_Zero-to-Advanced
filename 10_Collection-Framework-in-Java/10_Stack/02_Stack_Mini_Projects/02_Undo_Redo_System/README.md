# Undo-Redo System Simulation

## Overview
This mini-project demonstrates how two stacks are used to implement an undo/redo system in a text editor or similar application.

## Simulation Flow
1. **Write Action**: Pushes the current document state onto the `undoStack` and clears the `redoStack`.
2. **Undo Action**: Pops the previous state from the `undoStack`, pushes the current state onto the `redoStack`, and updates the current document text to the popped state.
3. **Redo Action**: Pops the state from the `redoStack`, pushes the current state onto the `undoStack`, and updates the current document text to the popped state.

## Class Used
* **`ArrayDeque`**: Serves as the stack backing implementation.

---

**Back to Stacks Home:** [Stacks Index](../../README.md)
