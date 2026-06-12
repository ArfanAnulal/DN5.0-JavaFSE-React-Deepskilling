# Algorithms & Data Structures: Complexity Analysis

This document provides a detailed technical analysis of the design choices, data structures, and algorithmic complexities (Time and Space) for each of the 7 exercises implemented in the `AlgorithmsDataStructures` project.

---

## 1. Inventory Management System
* **Scenario**: Efficiently managing warehouse products (add, update, delete, search).
* **Data Structure**: `java.util.HashMap` (Key: `productId` [String], Value: `Product` [Object]).
* **Rationale**: A hash map provides constant time complexity $O(1)$ on average for lookup, insertion, and deletion by hash key, making it optimal for scale-out search scenarios compared to lists or arrays.

### Complexities:
* **Add**: 
  - *Time Complexity*: $O(1)$ average; $O(n)$ worst-case (due to hash collisions and re-hashing).
  - *Space Complexity*: $O(1)$ auxiliary space.
* **Update**:
  - *Time Complexity*: $O(1)$ average; $O(n)$ worst-case.
  - *Space Complexity*: $O(1)$ auxiliary space.
* **Delete**:
  - *Time Complexity*: $O(1)$ average; $O(n)$ worst-case.
  - *Space Complexity*: $O(1)$ auxiliary space.
* **Search (Get)**:
  - *Time Complexity*: $O(1)$ average; $O(n)$ worst-case.
  - *Space Complexity*: $O(1)$ auxiliary space.
* **Total Space Complexity**: $O(n)$ where $n$ is the number of products stored.

---

## 2. E-commerce Platform Search Function
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

## 3. Sorting Customer Orders
* **Scenario**: Sorting orders by their total price.
* **Algorithms Compared**: Bubble Sort vs Quick Sort.

### Complexities:
* **Bubble Sort**:
  - *Time Complexity*: $O(n^2)$ average and worst-case; $O(n)$ best-case (if array is already sorted and optimized with a swap flag).
  - *Space Complexity*: $O(1)$ auxiliary space (in-place sorting).
* **Quick Sort**:
  - *Time Complexity*: $O(n \log n)$ average-case; $O(n^2)$ worst-case (if pivot is consistently the smallest or largest element).
  - *Space Complexity*: $O(\log n)$ auxiliary space on the call stack due to recursion.
* **Comparison**: Quick Sort is highly preferred due to its $O(n \log n)$ average-case running time. Bubble Sort is inefficient for large datasets due to its quadratic complexity.

---

## 4. Employee Management System
* **Scenario**: Storing and managing employee records using an array.
* **Design**: Standard array with manual size tracking and dynamic resizing (doubling capacity).

### Complexities:
* **Add**:
  - *Time Complexity*: $O(1)$ amortized; $O(n)$ worst-case when array capacity is exceeded and elements are copied to a new array.
  - *Space Complexity*: $O(n)$ to duplicate elements during resize.
* **Search**:
  - *Time Complexity*: $O(n)$ worst and average case (linear scan).
  - *Space Complexity*: $O(1)$ auxiliary space.
* **Traverse**:
  - *Time Complexity*: $O(n)$.
  - *Space Complexity*: $O(1)$.
* **Delete**:
  - *Time Complexity*: $O(n)$ since deletion requires shifting remaining elements to close the gap.
  - *Space Complexity*: $O(1)$.

---

## 5. Task Management System
* **Scenario**: Storing and managing tasks using a Singly Linked List.
* **Design**: Dynamic nodes where each node points to the next.

### Complexities:
* **Add**:
  - *Time Complexity*: $O(n)$ to traverse to the end of the list and append; $O(1)$ if appending at the head (we implemented append at tail: $O(n)$).
  - *Space Complexity*: $O(1)$ auxiliary space.
* **Search**:
  - *Time Complexity*: $O(n)$ average and worst case.
  - *Space Complexity*: $O(1)$.
* **Traverse**:
  - *Time Complexity*: $O(n)$.
  - *Space Complexity*: $O(1)$.
* **Delete**:
  - *Time Complexity*: $O(n)$ to locate the task node and adjust pointers.
  - *Space Complexity*: $O(1)$.

---

## 6. Library Management System
* **Scenario**: Book title search in a library database.
* **Algorithms Compared**: Linear Search vs Binary Search (similar to search platform logic but operates on text comparison).

### Complexities:
* **Linear Search**:
  - *Time Complexity*: $O(n)$ time complexity.
  - *Space Complexity*: $O(1)$ auxiliary space.
* **Binary Search**:
  - *Time Complexity*: $O(\log n)$ time complexity.
  - *Space Complexity*: $O(1)$ auxiliary space.
  - *Prerequisite*: Objects sorted lexicographically using `String.compareToIgnoreCase()`.

---

## 7. Financial Forecasting
* **Scenario**: Predicting compounding value over $t$ growth periods recursively.
* **Equations**: $FV = PV \times (1 + r)^t$.

### Complexities:
* **Standard Recursion**:
  - *Time Complexity*: $O(t)$ where $t$ is the number of periods (linear depth of recursion).
  - *Space Complexity*: $O(t)$ call stack frames.
* **Memoized Recursion**:
  - *Time Complexity*: $O(t)$ on first compute; $O(1)$ on subsequent queries of the same state due to cached values.
  - *Space Complexity*: $O(t)$ for the call stack and $O(t)$ map storage.
