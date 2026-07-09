# Browser Back History Simulation

## Overview
This mini-project simulates browser history navigation (back and forward) using two stacks.

## Simulation Flow
1. **Visit Page**: Pushes the current page onto the `backStack` and clears the `forwardStack`.
2. **Go Back**: Pops the previous page from the `backStack`, pushes the current page onto the `forwardStack`, and updates the current page to the popped page.
3. **Go Forward**: Pops the page from the `forwardStack`, pushes the current page onto the `backStack`, and updates the current page to the popped page.

## Class Used
* **`ArrayDeque`**: Serves as the stack backing implementation.

---

**Back to Stacks Home:** [Stacks Index](../../README.md)
