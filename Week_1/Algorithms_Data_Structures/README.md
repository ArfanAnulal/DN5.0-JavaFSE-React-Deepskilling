# Algorithms and Data Structures

This project implements standard data structures and algorithmic operations in Java, structured as a single Maven project. It focuses on optimization, complexity analysis, and correct implementation of fundamental structures (arrays, linked lists, hash maps) and algorithms (searching, sorting, compounding recursion).

---

## Implemented Exercises

* **Exercise 1: Inventory Management System**: Uses a HashMap to achieve O(1) average time complexity for adding, updating, retrieving, and deleting warehouse products.
* **Exercise 2: E-commerce Platform Search Function**: Linear search vs Binary search. Shows the performance gain of binary search ($O(\log n)$) on sorted data compared to linear scans ($O(n)$).
* **Exercise 3: Sorting Customer Orders**: Implements Bubble Sort ($O(n^2)$) and Quick Sort ($O(n \log n)$) to compare sorting algorithm efficiencies.
* **Exercise 4: Employee Management System**: Implements an array-based employee database with manual size tracking and capacity expansion logic, showing how memory contiguous arrays perform shifts during deletions.
* **Exercise 5: Task Management System**: Implements a custom Singly Linked List from scratch to manage tasks, illustrating dynamic memory node pointers.
* **Exercise 6: Library Management System**: Implements book searches using linear search and binary search, relying on string comparison.
* **Exercise 7: Financial Forecasting**: Implements recursive compounding and optimizes the recursive stack calls via a memoized mapping technique to prevent redundant computations.

---

## Detailed Learnings

### 1. Choice of Data Structures
* **Arrays vs. Linked Lists**: We learned that arrays provide constant-time indexing $O(1)$ but require contiguous memory blocks and have fixed sizes. Resizing them requires copying elements ($O(n)$), and deletions require shifting elements to maintain index continuity. Singly linked lists provide dynamic allocation where insertions and deletions do not require element shifting, but searching requires linear traversal $O(n)$ as random access is not supported.
* **HashMap**: Offers highly optimized $O(1)$ operations on average by converting lookup keys into array indices via hash functions. We must account for worst-case $O(n)$ operations when excessive hash collisions occur.

### 2. Search and Sort Algorithms
* **Linear vs. Binary Search**: Linear search is simple and works on unsorted collections, but scales poorly. Binary search operates by repeatedly halving the search space, scaling logarithmic-wise ($O(\log n)$), but requires the collection to be pre-sorted.
* **Bubble Sort vs. Quick Sort**: Bubble sort is a quadratic algorithm ($O(n^2)$) that compares adjacent pairs and is only useful for educational purposes or nearly sorted small arrays. Quick sort is a divide-and-conquer algorithm ($O(n \log n)$ average) that partitions arrays around a pivot, making it highly efficient.

### 3. Recursion and Optimization
* **Compounding Stack**: Recursive algorithms simplify complex mathematical chains (like compound interest forecasting). However, every recursive call pushes a frame onto the call stack. For deep recursion, this can lead to StackOverflowError. We resolved this by exploring memoization—caching calculated states in a map to eliminate recalculations of duplicate steps.

---

## Complexity Analysis Reference

For a complete breakdown of time and space complexities in Big O notation for every operation, refer to the [complexity_analysis.md](file:///c:/Users/bened/Downloads/Misson_Cognizant/Week_1/Algorithms_Data_Structures/complexity_analysis.md) file.

---

## How to Execute

Compile and execute the validation unit tests:
```bash
mvn clean test
```

### Verified Execution Output

```text
[INFO] Running com.algorithms.employee.EmployeeTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.algorithms.forecasting.FinancialForecastingTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.algorithms.inventory.InventoryTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.algorithms.library.LibraryTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.algorithms.search.SearchTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.algorithms.sorting.SortingTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.algorithms.task.TaskTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
```
