https://velog.io/@corone_hi/%EB%B0%A9%ED%96%A5-%EC%A2%8C%ED%91%9C-dx-dy-%EA%B8%B0%EC%A4%80

dx dy를 위해 참고한 사이트

package suseok;

import java.util.Scanner;

public class KnightMove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("나이트의 위치(ex : a1) : ");
            String input = scanner.next();

            if (input.length() != 2) {
                System.out.println("올바른 형식(ex: a1)으로 입력해주세요.");
                continue;
            }

            char x = input.charAt(0);
            char y = input.charAt(1);

            if (x < 'a' || x > 'h' || y < '1' || y > '8') {
                System.out.println("a~h, 1~8 범위의 값을 하나씩 입력해주세요 (ex : a1)");
                continue;
            }

            int result = KnightMoves(x, y);
            System.out.println("나이트가 이동할 수 있는 경우의 수: " + result);
        }
    }

    public static int KnightMoves(char x, char y) {
        int count = 0;

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < 8; i++) {
            int nx = x - 'a' + 1 + dx[i];
            int ny = y - '0' + dy[i];

            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                count++;
            }
        }

        return count;
    }
}
