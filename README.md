# Finding prime numbers using the Sieve of Eratosthenes and Sieve of Atkin algorithms with Multithreading

## Description
- The project makes use of multithreaded support for two prime number algorithms, namely **Sieve of Eratosthenes** and the **Sieve of Atkin**. The results are really significant performance improvements due to spreading the calculations across several threads and can handle larger ranges of numbers.
- The two algorithms were tested on the ranges (100, 1000, 10000, 100000, 1000000, 10000000, 100000000) and each range was tested on multiple threads (1, 2, 4, 8, 16, 32, 64).

## Sieve of Eratosthenes Algorithm
This algorithm was tested, and the results are provided in the accompanying screenshot.

### Observations
- As the range of the values increase, time to execute reduces drastically on using multi-threading.
- It gave the best performance between 2 threads and 4 threads; the latter, in fact, has proved to be the most efficient and has aligned with the number of virtual threads featured on a test machine: Intel Core i7, 2nd generation, 2 cores, 4 threads.

## Sieve of Atkin Algorithm
This algorithm was tested, and the results are provided in the accompanying screenshot.

### Observations
- The Sieve of Atkin performed better than the Segmented Sieve when ranges were of lesser magnitude.
- Just like the Sieve of Eratosthenes, performance peaked between 2 threads and 4 threads in a similar manner in which it did in the previous algorithm.

## Conclusion
In conclusion, Sieve of Eratosthenes handles larger data much better.
