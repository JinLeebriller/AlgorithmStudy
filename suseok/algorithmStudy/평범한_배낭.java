
https://adjh54.tistory.com/201

동적 계획법을 이해하기 위해 참고한 사이트,, 너무 어려워요

package suseok;

import java.util.Scanner;

public class Bag {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // 물건의 수
        int K = scanner.nextInt();  // 배낭의 무게 제한

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];

        // 물건의 무게와 가치를 배열에 저장
        for (int i = 1; i <= N; i++) {
            W[i] = scanner.nextInt();
            V[i] = scanner.nextInt();
        }

        // dp 배열 초기화
        int[][] dp = new int[N + 1][K + 1];

        // Bottom-up 방식으로 동적 계획법 수행
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                // 현재 물건을 배낭에 넣을 수 있는 경우
                if (W[i] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], V[i] + dp[i - 1][w - W[i]]);
                } else {
                    // 현재 물건을 배낭에 넣을 수 없는 경우
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[N][K]);  // 배낭에 넣을 수 있는 물건들의 가치합의 최댓값 출력
    }
}

