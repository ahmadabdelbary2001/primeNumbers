package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    // ANSI color codes for terminal formatting
    private static final String red = "\u001B[31m";
    private static final String green = "\033[32m";
    private static final String blue = "\033[34m";
    private static final String bold = "\033[1m";
    private static final String reset = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeCalculatorAlgorithm[] algorithms = {
                new SieveOfEratosthenes(),
                new SieveOfAtkin()
        };

        // Get the range (start and end)
        int low = getRangeStart(scanner);
        int high = getRangeEnd(scanner, low);

        // Select an algorithm
        PrimeCalculatorAlgorithm algorithm = chooseAlgorithm(scanner, algorithms);

        // Get the number of threads
        int numThreads = getNumThreads(scanner);

        // Execute the prime calculation using threads
        PrimeCalculatorThreads threads = new PrimeCalculatorThreads(numThreads, low, high, algorithm);
        long start = System.currentTimeMillis();
        List<Integer> primes = threads.findPrimes();
        long end = System.currentTimeMillis();

        System.out.println(bold + green + "Time taken for " + numThreads + " threads: " + (end - start) + " milliseconds\n" + reset);

        // Ask if the user wants to view the primes
        viewPrimes(scanner, primes);
    }

    // Function to get the beginning range
    private static int getRangeStart(Scanner scanner) {
        boolean validInput = false;
        int low = 0;

        System.out.println("Determine the range in which you want to find the prime numbers:");
        while (!validInput) {
            try {
                System.out.print(blue + "From: " + reset);
                low = scanner.nextInt();

                if (low > 0) {
                    validInput = true;
                } else {
                    System.out.println(red + "Please enter a positive number." + reset);
                }
            } catch (InputMismatchException e) {
                System.out.println(red + "Error: Invalid input. Please enter a valid natural number." + reset);
                scanner.nextLine();
            }
        }
        return low;
    }

    // Function to get the end of the range
    private static int getRangeEnd(Scanner scanner, int low) {
        boolean validInput = false;
        int high = 0;

        while (!validInput) {
            try {
                System.out.print(blue + "To: " + reset);
                high = scanner.nextInt();

                if (high > low) {
                    validInput = true;
                } else {
                    System.out.println(red + "End of range must be greater than the beginning." + reset);
                }
            } catch (InputMismatchException e) {
                System.out.println(red + "Error: Invalid input. Please enter a valid natural number." + reset);
                scanner.nextLine();
            }
        }
        return high;
    }

    // Function to choose an algorithm
    private static PrimeCalculatorAlgorithm chooseAlgorithm(Scanner scanner, PrimeCalculatorAlgorithm[] algorithms) {
        boolean validInput = false;
        PrimeCalculatorAlgorithm algorithm = null;

        while (!validInput) {
            try {
                System.out.println("\nChoose one of these algorithms:");
                System.out.println("1- Sieve Of Eratosthenes");
                System.out.println("2- Sieve Of Atkin");
                System.out.print(blue + "The chosen algorithm is: " + reset);

                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= 2) {
                    algorithm = algorithms[choice - 1];
                    validInput = true;
                } else {
                    System.out.println(red + "Invalid choice! Please choose between 1 and 2." + reset);
                }
            } catch (InputMismatchException e) {
                System.out.println(red + "Error: Invalid input. Please enter a valid number." + reset);
                scanner.nextLine();
            }
        }
        return algorithm;
    }

    // Function to get the number of threads
    private static int getNumThreads(Scanner scanner) {
        boolean validInput = false;
        int numThreads = 0;

        while (!validInput) {
            try {
                System.out.print(blue + "\nEnter the number of threads: " + reset);
                numThreads = scanner.nextInt();

                if (numThreads > 0) {
                    validInput = true;
                } else {
                    System.out.println(red + "Please enter a positive number greater than 0." + reset);
                }
            } catch (InputMismatchException e) {
                System.out.println(red + "Error: Invalid input. Please enter a valid natural number." + reset);
                scanner.nextLine();
            }
        }
        return numThreads;
    }

    // Function to ask the user if he/she want to view the primes
    private static void viewPrimes(Scanner scanner, List<Integer> primes) {
        boolean validInput = false;
        scanner.nextLine();  // clear buffer

        while (!validInput) {
            try {
                System.out.println("Would you like to view the prime numbers?");
                System.out.print(blue + "Please enter 'y' for Yes or 'n' for No: " + reset);

                String choice = scanner.nextLine().trim();

                if (choice.equalsIgnoreCase("y")) {
                    System.out.println("Here are the prime numbers: " + bold + green + primes + reset);
                    validInput = true;
                } else if (choice.equalsIgnoreCase("n")) {
                    validInput = true;
                } else {
                    System.out.println(red + "Invalid choice! Please enter 'y' for Yes or 'n' for No." + reset);
                }
            } catch (InputMismatchException e) {
                System.out.println(red + "Error: Invalid input. Please enter 'y' or 'n'." + reset);
                scanner.nextLine();
            }
        }
    }
}
