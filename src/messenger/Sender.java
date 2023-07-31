package messenger;

import core.RSA;

import java.util.Scanner;

public class Sender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n: ");
        int n = scanner.nextInt();
        System.out.println("Введите e: ");
        int e = scanner.nextInt();

        RSA rsa = new RSA(n, e, 0);

        while (true) {
            System.out.print("Введите текст: ");

            // Чтение введенной строки
            String input = scanner.nextLine();

            // Проверка на выход из цикла по условию (например, "exit")
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if(input.isEmpty()){
                continue;
            }

            String cipher = rsa.encode(input);
            System.out.println("cipher: " + cipher);
        }
    }
}