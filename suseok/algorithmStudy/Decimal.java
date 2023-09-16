package suseok;

import java.util.Scanner;

public class Decimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("입력하실 정수 (0 입력하면 종료): ");
            int enterInt = scanner.nextInt();

            if (enterInt == 0) {
                break;
            }

            int base;
            while (true) {
                System.out.print("변환할 진수 (2, 4, 8, 16, 32 중 하나 입력): ");
                base = scanner.nextInt();

                if (base == 2 || base == 4 ||base == 8 || base == 16 || base == 32) {
                    break;
                } else {
                    System.out.println("2, 4, 8, 16, 32 중 하나를 입력하세요.");
                }
            }

            String result = convertDecimal(enterInt, base);
            System.out.println(base + "진수로 " + result + "입니다.");
        }

        scanner.close();
    }

    public static String convertDecimal(int enterInt, int base) {
        StringBuilder result = new StringBuilder();
        
        while (enterInt > 0) {
            int remainder = enterInt % base;
            result.insert(0, remainder);
            enterInt = enterInt / base;
        }
        
        return result.toString();
    }
}
