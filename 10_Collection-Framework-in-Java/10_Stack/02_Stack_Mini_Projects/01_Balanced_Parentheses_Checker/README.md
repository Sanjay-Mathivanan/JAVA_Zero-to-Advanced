# Balanced Parentheses Checker

## Overview
This mini-project demonstrates how a LIFO stack is used to verify that bracket character pairs (`()`, `[]`, `{}`) are correctly balanced.

## Simulation Flow
1. The system scans the string expression character-by-character.
2. When it encounters an opening bracket, it pushes it onto the stack.
3. When it encounters a closing bracket, it pops the top element from the stack and checks if they match.
4. If they mismatch or the stack is empty, the expression is unbalanced.
5. If the stack is empty at the end of the scan, the expression is balanced.

## Class Used
* **`ArrayDeque`**: Serves as the Stack backing implementation.

---

**Back to Stacks Home:** [Stacks Index](../../README.md)
