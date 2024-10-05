package org.example;

import java.util.ArrayList;
import java.util.List;

public class SieveOfAtkin implements PrimeCalculatorAlgorithm {

    @Override
    public List<Integer> findPrimes(int start, int end) {
        if (end < 2) {
            return new ArrayList<>();
        }

        boolean[] isPrime = new boolean[end + 1];

        if (end > 2 && start <= 2) isPrime[2] = true;
        if (end > 3 && start <= 3) isPrime[3] = true;

        for (int x = 1; x * x <= end; x++) {
            for (int y = 1; y * y <= end; y++) {
                int n = (4 * x * x) + (y * y);
                if (n <= end && (n % 12 == 1 || n % 12 == 5)) {
                    isPrime[n] = !isPrime[n];
                }

                n = (3 * x * x) + (y * y);
                if (n <= end && n % 12 == 7) {
                    isPrime[n] = !isPrime[n];
                }

                n = (3 * x * x) - (y * y);
                if (x > y && n <= end && n % 12 == 11) {
                    isPrime[n] = !isPrime[n];
                }
            }
        }

        for (int i = 5; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i * i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, start); i <= end; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
