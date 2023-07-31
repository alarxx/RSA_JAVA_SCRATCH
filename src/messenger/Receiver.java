package messenger;

import core.RSA;

import java.util.Scanner;

public class Receiver {
    public static void main(String[] args) {
        RSA rsa = RSA.generateKeys();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите шифр: ");

            // Чтение введенной строки
            String input = scanner.nextLine();

            // Проверка на выход из цикла по условию (например, "exit")
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String message = rsa.decode(input);
            System.out.println("message: " + message);
        }

    }
}