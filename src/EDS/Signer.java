package EDS;

import core.RSA;

import java.util.Scanner;

public class Signer {
    public static void main(String[] args) {
        RSA rsa = RSA.generateKeys();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Что нужно подписать: ");

            // Чтение введенной строки
            String input = scanner.nextLine();

            // Проверка на выход из цикла по условию (например, "exit")
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String signed = rsa.sign(input);

            System.out.println("signed: " + signed);
        }

    }
}