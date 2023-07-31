package core;

import java.math.BigInteger;

public class Euclid {
    public static void main(String[] args) {
        System.out.println(
                GCD(
                        BigInteger.valueOf(12),
                        BigInteger.valueOf(5)
                )
        );
    }
    /**
     * @A > 0
     * @B > 0
     * */
    public static BigInteger GCD(BigInteger A, BigInteger B){
        BigInteger a = A, b = B;

        while (!b.equals(BigInteger.ZERO)) {
            // a mod b = r and then a=b, b=r
            // 120 mod 7 = 1 - GCD
            // 7 mod 1 = 0
            BigInteger r = a.mod(b);
            a = b;
            b = r;
        }

        return a;
    }

    /**
     * e*e^-1 = 1 mod m
     * */
    public static BigInteger modInverse(BigInteger E, BigInteger M){
        return null;
    }

}
