package core;

import java.math.BigInteger;

public class Prime {
    public static boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // prime=6k+-1
        // prime factorization
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
    public static BigInteger generatePrime(int min, int max){
        int number;
        do{
            number = min + (int) (Math.random() * (max - min));
        }
        while(!isPrime(number)); // Делай пока не простое
        return new BigInteger(Integer.valueOf(number).toString());
    }
}