# Printer Queue System Simulation

## Overview
This mini-project models a computer printer queue spooler processing documents sequentially in FIFO order.

## Simulation Flow
1. Users send document print jobs to the printer queue.
2. The print jobs are spooled in FIFO sequence.
3. The printer pulls jobs from the head of the queue, simulating a print processing delay before pulling the next document.

## Class Used
* **`ArrayDeque`**: Serves as the FIFO printer queue backing.

---

**Back to Queues Home:** [Queues Index](../../README.md)
