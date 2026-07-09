# Queues in Java Collections Framework

This directory covers `Queue` and `Deque` implementations in Java, designed for holding elements prior to processing in sequential or prioritized order.

## Lessons Map

### 1. [Queue Interface](01_Queue_Interface/01_Queue.md) (FIFO Buffering)
* [Queue Interface Guide](01_Queue_Interface/01_Queue.md): FIFO, hierarchy, and basic offer/poll methods.
* [Queue Internal Workings](01_Queue_Interface/02_Internal_Working.md): LinkedList nodes vs ArrayDeque arrays.
* [Queue Interview Questions](01_Queue_Interface/03_Interview_Questions.md): Standard tech Q&As.

### 2. [PriorityQueue](02_PriorityQueue/01_PriorityQueue.md) (Heap Sorting)
* [PriorityQueue Guide](02_PriorityQueue/01_PriorityQueue.md): Natural sorting, custom comparators, and priority tasks.
* [PriorityQueue Internal Workings](02_PriorityQueue/02_Internal_Working.md): Binary min-heaps, parent/child index math, and sift-up/down operations.
* [PriorityQueue Interview Questions](02_PriorityQueue/03_Interview_Questions.md): Q&As on heap resizing and iteration limits.

### 3. [ArrayDeque](03_ArrayDeque/01_ArrayDeque.md) (Double-Ended Circular Buffer)
* [ArrayDeque Guide](03_ArrayDeque/01_ArrayDeque.md): Double-ended queue methods, stack implementations, and efficiency.
* [ArrayDeque Internal Workings](03_ArrayDeque/02_Internal_Working.md): Circular pointer math (`(head - 1) & mask`) and table resizing.
* [ArrayDeque Interview Questions](03_ArrayDeque/03_Interview_Questions.md): Stack alternatives and speed details.

---

## 4. [Queue Mini Projects](04_Queue_Mini_Projects/)
* [01_Ticket_Booking_System](04_Queue_Mini_Projects/01_Ticket_Booking_System/README.md): FIFO customer booking.
* [02_Printer_Queue_System](04_Queue_Mini_Projects/02_Printer_Queue_System/README.md): Document printing delay simulation.
* [03_Hospital_Patient_Queue](04_Queue_Mini_Projects/03_Hospital_Patient_Queue/README.md): ER patient priority triage.

---

**Back to Collection Framework Home:** [JCF Index](../README.md)
