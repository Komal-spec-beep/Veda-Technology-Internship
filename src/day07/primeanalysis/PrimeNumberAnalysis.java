package day07.primeanalysis;

import java.util.Scanner;

public class PrimeNumberAnalysis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prime Checker
        System.out.print("Enter a number to check: ");
        int number = sc.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        // Prime Number Generator
        System.out.print("\nEnter starting number: ");
        int start = sc.nextInt();

        System.out.print("Enter ending number: ");
        int end = sc.nextInt();

        System.out.println("\nPrime numbers between " + start + " and " + end + ":");

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        // Range-based Prime Analysis
        int primeCount = 0;

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }

        System.out.println("\n\nTotal prime numbers in the range: " + primeCount);

        sc.close();
    }

    // Method to check whether a number is prime
    public static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}