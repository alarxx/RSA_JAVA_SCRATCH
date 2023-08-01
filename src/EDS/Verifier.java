package EDS;

import core.RSA;

import java.util.Scanner;

public class Verifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n: ");
        int n = scanner.nextInt();
        System.out.println("Введите e: ");
        int e = scanner.nextInt();

        RSA rsa = new RSA(n, e, 0);

        while (true) {
            System.out.print("Проверить: ");

            // Чтение введенной строки
            String input = scanner.nextLine();

            System.out.println(input);

            // Проверка на выход из цикла по условию (например, "exit")
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if(input.isEmpty()){
                continue;
            }

            System.out.println("verify: " + rsa.verify(input));
        }
    }
}