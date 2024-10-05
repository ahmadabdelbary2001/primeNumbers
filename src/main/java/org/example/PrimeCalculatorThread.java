package org.example;

import java.util.List;

public class PrimeCalculatorThread extends Thread {
    private final int start;
    private final int end;
    private final PrimeCalculatorAlgorithm algorithm;
    private List<Integer> primes;

    public PrimeCalculatorThread(int start, int end, PrimeCalculatorAlgorithm algorithm) {
        this.start = start;
        this.end = end;
        this.algorithm = algorithm;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    @Override
    public void run() {
        // System.out.println(Thread.currentThread().getName());
        primes = algorithm.findPrimes(start, end);
    }
}