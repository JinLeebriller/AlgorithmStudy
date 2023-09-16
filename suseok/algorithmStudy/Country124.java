package suseok;

import java.util.Scanner;

public class Country124 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력하세요 (0 입력하면 종료): ");
            int n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            String result = solution(n);
            System.out.println(n + "을 124 나라에서 사용하는 숫자로 변환하면 " + result + "입니다.");
        }

        scanner.close();
    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int remainder = n % 3;
            if (remainder == 0) {
                remainder = 4;
                n = (n / 3) - 1;
            } else {
                n = n / 3;
            }
            answer.insert(0, remainder);
        }

        return answer.toString();
    }
}

