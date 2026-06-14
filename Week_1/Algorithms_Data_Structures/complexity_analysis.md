# Algorithms & Data Structures: Complexity Analysis

This document provides a detailed technical analysis of the design choices and algorithmic complexities for the 2 exercises in the `AlgorithmsDataStructures` project.

---

## 1. E-commerce Platform Search Function
* **Scenario**: Searching products by ID.
* **Algorithms Compared**: Linear Search vs Binary Search.

### Complexities:
* **Linear Search**:
  - *Time Complexity*: $O(n)$ worst and average case, $O(1)$ best case (target at index 0). Loops sequentially.
  - *Space Complexity*: $O(1)$ auxiliary space.
* **Binary Search**:
  - *Time Complexity*: $O(\log n)$ worst and average case, $O(1)$ best case (target at middle).
  - *Space Complexity*: $O(1)$ auxiliary space.
  - *Prerequisite*: Array must be sorted ($O(n \log n)$ time overhead for sorting).
* **Recommendation**: If search operations are highly frequent and modifications are rare, sort the array once and use **Binary Search**. If updates are frequent and search is infrequent, linear search on an unsorted array may avoid the sorting overhead.

---

## 2. Financial Forecasting
* **Scenario**: Predicting compounding value over $t$ growth periods recursively.
* **Equations**: $FV = PV \times (1 + r)^t$.

### Complexities:
* **Standard Recursion**:
  - *Time Complexity*: $O(t)$ where $t$ is the number of periods (linear depth of recursion).
  - *Space Complexity*: $O(t)$ call stack frames.
* **Memoized Recursion**:
  - *Time Complexity*: $O(t)$ on first compute; $O(1)$ on subsequent queries of the same state due to cached values.
  - *Space Complexity*: $O(t)$ for the call stack and $O(t)$ map storage.
