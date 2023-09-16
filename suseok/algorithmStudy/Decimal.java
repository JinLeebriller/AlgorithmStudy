package suseok;

import java.util.Scanner;

public class Decimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력하실 정수: ");
        int enterInt = scanner.nextInt();

        int base;
        while (true) {
            System.out.print("변환할 진수 (2, 8, 16, 32 중 하나 입력): ");
            base = scanner.nextInt();

            if (base == 2 || base == 8 || base == 16 || base == 32) {
                break;
            } else {
                System.out.println("2, 8, 16, 32 중 하나를 입력하세요.");
            }
        }
        
        String result = convertDecimal(enterInt, base);
        System.out.println(base + "진수로 " + result + "입니다.");
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

