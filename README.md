# Finding prime numbers using the Sieve of Eratosthenes and Sieve of Atkin algorithms with Multithreading

## Description
- The project makes use of multithreaded support for two prime number algorithms, namely **Sieve of Eratosthenes** and the **Sieve of Atkin**. The results are really significant performance improvements due to spreading the calculations across several threads and can handle larger ranges of numbers.
- The two algorithms were tested on the ranges (100, 1000, 10000, 100000, 1000000, 10000000, 100000000) and each range was tested on multiple threads (1, 2, 4, 8, 16, 32, 64).

## 1. Segmented Sieve Algorithm

When testing this algorithm, the following results appeared:

Range: [1, 100]

| Number of threads  | 1           | 2           | 4           | 8           | 16           | 32           | 64           |
|--------------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|
| Time (ms)          | 2           | 119.15     | 1           | 1           | 1           | 1           | 1           |

Range: [1, 1,000]

| Number of threads  | 1           | 2           | 4           | 8           | 16           | 32           | 64           |
|--------------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|
| Time (ms)          | 2           | 119.15     | 1           | 1           | 1           | 1           | 1           |

Range: [1, 10,000]

| Number of threads  | 1           | 2           | 4           | 8           | 16           | 32           | 64           |
|--------------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|
| Time (ms)          | 2           | 119.15     | 1           | 1           | 1           | 1           | 1           |

Range: [1, 100,000]

| Number of threads  | 1           | 2           | 4           | 8           | 16           | 32           | 64           |
|--------------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|
| Time (ms)          | 2           | 119.15     | 1           | 1           | 1           | 1           | 1           |

Range: [1, 1,000,000]

| Number of threads  | 1           | 2           | 4           | 8           | 16           | 32           | 64           |
|--------------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|
| Time (ms)          | 2           | 119.15     | 1           | 1           | 1           | 1           | 1           |

Range: [1, 10,000,000]

| Number of threads  | 1           | 2           | 4           | 8           | 16           | 32           | 64           |
|--------------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|
| Time (ms)          | 2           | 119.15     | 1           | 1           | 1           | 1           | 1           |

Range: [1, 100,000,000]

| Number of threads  | 1           | 2           | 4           | 8           | 16           | 32           | 64           |
|--------------------|-------------|-------------|-------------|-------------|--------------|--------------|--------------|
| Time (ms)          | 2           | 119.15     | 1           | 1           | 1           | 1           | 1           |


### Observations:
- As the range increases, multithreading significantly reduces execution time.
- On average, using **4 threads** was found to be the most optimal for performance, aligning with the number of virtual threads on the machine used for testing (Intel Core i3, 4th Gen, 2 cores, 4 threads).
  
### CPU and Memory Usage:
- For large ranges (100,000,000 and above), we observed increased CPU usage and memory allocation.
- During execution, memory consumption reached approximately 1.4 GB for the largest range tested.

#### CPU & Memory Statistics:
- **Range [2, 100,000,000]:**
  - **2 Threads:**  
    ![CPU Usage - 2 Threads](./images/segmented/100/2.PNG)
  - **4 Threads:**  
    ![CPU Usage - 2 Threads](./images/segmented/100/4.PNG)
  - **8 Threads:**  
    ![CPU Usage - 2 Threads](./images/segmented/100/8.PNG)
  
- **Range [2, 1,000,000,000]:**
  - **2 Threads:**  
    ![CPU Usage - 2 Threads](./images/segmented/billion/2.PNG)
  - **4 Threads:**  
    ![CPU Usage - 2 Threads](./images/segmented/billion/4.PNG)
  - **8 Threads:**  
    ![CPU Usage - 2 Threads](./images/segmented/billion/8.PNG)

## 2. Sieve of Atkin Algorithm

When testing this algorithm, the following results appeared:

| Range          | Threads | Time (ms)  | Primes Count |
|----------------|---------|------------|--------------|
| [2, 1,000,000]   | 1       | 96.58      | 78,498       |
|                | 2       | 144.11     | -            |
|                | 4       | 121.83     | -            |
|                | 8       | 125.07     | -            |
| [2, 10,000,000]  | 1       | 562.11     | 664,579      |
|                | 2       | 373.85     | -            |
|                | 4       | 409.56     | -            |
|                | 8       | 490.47     | -            |
| [2, 100,000,000] | 1       | 3,744.61   | 5,761,455    |
|                | 2       | 3,324.49   | -            |
|                | 4       | 3,182.80   | -            |
|                | 8       | 3,400.70   | -            |

### Observations:
- The Sieve of Atkin performs better on smaller ranges compared to the Segmented Sieve.
- Similar to the first algorithm, **4 threads** proved optimal for performance, again reflecting the available CPU threads on the test machine.
  
#### Performance Limitations:
- Testing on the 1,000,000,000 range resulted in a **Java Out of Memory** exception, indicating that this algorithm is more memory-intensive than the Segmented Sieve.

#### CPU & Memory Statistics:
- **Range [2, 100,000,000]:**
  - **2 Threads:**  
    ![CPU Usage - 2 Threads](./images/Atkin/2.PNG)
  - **4 Threads:**  
    ![CPU Usage - 2 Threads](./images/Atkin/4.PNG)
  - **8 Threads:**  
    ![CPU Usage - 2 Threads](./images/Atkin/8.PNG)

## 3. Summary & Conclusion

- **Segmented Sieve** performs better for larger ranges and is more memory-efficient.
- **Sieve of Atkin** excels in smaller ranges but struggles with larger ranges, especially in terms of memory usage.
- The tests and statistics are dependent on the hardware capabilities of the test machine. For the test environment (Intel Core i3, 4th Gen), **4 threads** provided optimal performance.
  
In conclusion, the **Segmented Sieve** is more suitable for larger datasets and is generally more efficient in terms of both performance and memory usage.

--- 

**Note:** The performance of both algorithms may vary based on system specifications and CPU load during testing.
