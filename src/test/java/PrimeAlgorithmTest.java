import junit.framework.TestCase;
import org.example.*;

import java.util.List;

public class PrimeAlgorithmTest extends TestCase {
    // ANSI color codes for terminal formatting
    private static final String green = "\033[32m";
    private static final String blue = "\033[34m";
    private static final String reset = "\u001B[0m";

    private void runTest(int low, int high, int expectedPrimes, PrimeCalculatorAlgorithm algorithm) {
        System.out.println(blue + "For range from " + low + " to " + high + ":" + reset);

        for (int numThreads : new int[]{1, 2, 4, 8}) {
            PrimeCalculatorThreads calculatorThreads = new PrimeCalculatorThreads(numThreads, low, high, algorithm);
            long start = System.currentTimeMillis();
            List<Integer> primes = calculatorThreads.findPrimes();
            long end = System.currentTimeMillis();
            System.out.println("Time taken for " + numThreads + " threads: "
                    + green + (end - start) + " milliseconds" + reset);
            assertEquals(expectedPrimes, primes.size());
        }
    }

    public void testPrimeCalculationInRange100() {
        runTest(1, 100, 25, new SieveOfAtkin());
    }

    public void testPrimeCalculationInRange1000() {
        runTest(1, 1000, 168, new SieveOfAtkin());
    }

    public void testPrimeCalculationInRange10000() {
        runTest(1, 10000, 1229, new SieveOfAtkin());
    }

    public void testPrimeCalculationInRange100000() {
        runTest(1, 100000, 9592, new SieveOfAtkin());
    }

    public void testPrimeCalculationInRange1000000() {
        runTest(1, 1000000, 78498, new SieveOfAtkin());
    }

    public void testPrimeCalculationInRange10000000() {
        runTest(1, 10000000, 664579, new SieveOfAtkin());
    }

    public void testPrimeCalculationInRange100000000() {
        runTest(1, 100000000, 5761455, new SieveOfAtkin());
    }

    public void testPrimeCalculationInRange1000000000() {
        runTest(1, 1000000000, 50847534, new SieveOfAtkin());
    }
}
