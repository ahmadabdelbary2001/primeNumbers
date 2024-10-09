# Finding prime numbers using the Sieve of Eratosthenes and Sieve of Atkin algorithms with Multithreading

## Description
- The project makes use of multithreaded support for two prime number algorithms, namely **Sieve of Eratosthenes** and the **Sieve of Atkin**. The results are really significant performance improvements due to spreading the calculations across several threads and can handle larger ranges of numbers.
- The two algorithms were tested on the ranges (100, 1000, 10000, 100000, 1000000, 10000000, 100000000) and each range was tested on multiple threads (1, 2, 4, 8, 16, 32, 64).

## Segmented Sieve Algorithm
The said algorithm was tested, and the results can be seen in the screenshot attached.

### Observations
- As the range of the values increase, time to execute reduces drastically on using multi-threading.
- It gave the best performance by switching between 2 threads and 4 threads; the latter, in fact, has proved to be the most efficient and has aligned with the number of virtual threads featured on a test machine: Intel Core i7, 2nd generation, 2 cores, 4 threads.
- 
## Sieve of Atkin Algorithm
Similarly, this algorithm has been tested, and results of the test are presented in the screenshot shown below.

### Observations
The Sieve of Atkin performed better than the Segmented Sieve when ranges were of lesser magnitude.
Just like the Segmented Sieve, performance peaked between 2 threads and 4 threads in a similar manner in which it did in the previous algorithm.
3. Summary and Conclusion
Segmented Sieve is much more efficient for larger ranges and also exhibits better efficiency in memory utilization. The Sieve of Atkin would work for smaller ranges; it suffers from problems when larger datasets are tackled, particularly from the memory utilization perspective. In short, Segmented Sieve handles larger data much better; it's far more performance- and memory-efficient.
