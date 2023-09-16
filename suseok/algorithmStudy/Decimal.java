package suseok;

/*
문제1.

아래 예시처럼 기수 변환 과정을
자세히 나타내는 프로그램을
작성하세요. (아래 예시의 59, 2라는 값은 Scanner로 입력 받은 값입니다.)

Console창)

10진수를 기수 변환합니다.
변환하는 음이 아닌 정수 : 59
어떤 진수로 변환할까요? (2~36): 2

2 |        59
  +————-
2 |        29    •••1
  +————-
(•••생략•••)
2 |           1    •••1
  +————-
               0    •••1
2진수로 111011입니다.

*/

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
