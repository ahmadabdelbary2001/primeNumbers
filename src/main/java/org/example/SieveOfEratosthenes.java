package org.example;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes implements PrimeCalculatorAlgorithm {

    @Override
    public List<Integer> findPrimes(int start, int end) {
        boolean[] isPrime = new boolean[end + 1];
        for (int i = 2; i <= end; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = Math.max(i * i, ((start + i - 1) / i) * i); j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, start); i <= end && primes.size() < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}

