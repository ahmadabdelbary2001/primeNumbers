package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeCalculatorThreads {

    private final int numThreads;
    private final int start;
    private final int end;
    private final PrimeCalculatorAlgorithm algorithm;
    private final List<PrimeCalculatorThread> threadList;

    public PrimeCalculatorThreads(int numThreads, int start, int end, PrimeCalculatorAlgorithm algorithm) {
        this.numThreads = numThreads;
        this.start = start;
        this.end = end;
        this.algorithm = algorithm;
        this.threadList = new ArrayList<>();
    }

    public List<Integer> findPrimes() {
        int chunkSize = (end - start + 1) / numThreads;
        int remainder = (end - start + 1) % numThreads;

        int currentStart = start;
        for (int i = 0; i < numThreads; i++) {
            int currentEnd = currentStart + chunkSize - 1;

            if (i < remainder) {
                currentEnd++;
            }

            PrimeCalculatorThread thread = new PrimeCalculatorThread(currentStart, currentEnd, algorithm);
            threadList.add(thread);
            thread.start();

            currentStart = currentEnd + 1;
        }

        for (PrimeCalculatorThread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        List<Integer> allPrimes = new ArrayList<>();
        for (PrimeCalculatorThread thread : threadList) {
            allPrimes.addAll(thread.getPrimes());
        }

        return allPrimes;
    }
}
