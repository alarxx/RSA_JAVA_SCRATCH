package core;

public class Main {
    public static void main(String[] args) {
        RSA rsa = RSA.generateKeys();

//        core.RSA rsa = new core.RSA(1711, 3, 1083);
//        rsa.printParams();

        String original = "Hello123";
        System.out.println("original: " + original);

        String encoded = rsa.encode(original);
        System.out.println("encoded: " + encoded);

        String decoded = rsa.decode(encoded);
        System.out.println("decoded: " + decoded);


        String signed = rsa.sign("I am Alar");
        System.out.println("signed: " + signed);
        System.out.println("verify: " + rsa.verify(signed));
    }
}