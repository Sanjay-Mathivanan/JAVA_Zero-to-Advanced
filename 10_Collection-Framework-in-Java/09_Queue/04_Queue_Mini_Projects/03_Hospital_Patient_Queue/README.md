# Hospital Patient Queue Simulation

## Overview
This mini-project demonstrates priority-based queue processing in a hospital emergency room (ER) scenario.

## Simulation Flow
1. Patients arrive at the emergency room with varying symptoms.
2. The triage nurse assigns a severity score (1 = Critical, 2 = Serious, 3 = Minor).
3. The patients are entered into a `PriorityQueue`.
4. Doctors treat patients with the highest severity (lowest numerical score) first, regardless of when they arrived.

## Class Used
* **`PriorityQueue`**: Serves as the priority-based triage queue.

---

**Back to Queues Home:** [Queues Index](../../README.md)
