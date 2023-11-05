package algorithmStudy;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        int map[][] = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int currentRow = a, currentColumn = b, nextRow = 0, nextColumn = 0;
        int turnCount = 0, result = 1;
        boolean[][] visited = new boolean[n][m];
        int[] row = {-1, 0, 1, 0};
        int[] column = {0, 1, 0, -1};

        visited[currentRow][currentColumn] = true;

        while(true) {
            // 왼쪽으로 회전
            if(d == 0) d = 3;
            else d--;
            turnCount++;

            // 다음 위치 연산(앞으로)
            nextRow = currentRow + row[d];
            nextColumn = currentColumn + column[d];

            // 다음 위치가 육지이고 방문한 적이 없다면
            if(map[nextRow][nextColumn] == 0 && visited[nextRow][nextColumn] == false) {
                // 이동
                currentRow = nextRow;
                currentColumn = nextColumn;

                // 현재 위치 방문 처리
                visited[currentRow][currentColumn] = true;
                result++;
                turnCount = 0;
            }

            // 네 방향 모두 방문한 경우
            if(turnCount == 4) {
                // 다음 위치 연산(뒤로)
                nextRow = currentRow - row[d];
                nextColumn = currentColumn - column[d];

                // 바다일 경우
                if(map[nextRow][nextColumn] == 1) break;
                    // 육지일 경우
                else {
                    // 이동
                    currentRow = nextRow;
                    currentColumn = nextColumn;

                    visited[currentRow][currentColumn] = true;
                    turnCount = 0;
                }
            }
        }
        System.out.println(result);
        sc.close();
    }
}
