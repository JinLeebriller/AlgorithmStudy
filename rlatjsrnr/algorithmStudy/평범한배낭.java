import java.util.Arrays;
import java.util.Scanner;

public class 평범한배낭 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nk = scan.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] weight = new int[n+1];
        int[] value = new int[n+1];

        // 물건 무게 가치 배열 생성
        for(int i = 1; i <= n; i++){
            String[] wv = scan.nextLine().split(" ");
            weight[i] = Integer.parseInt(wv[0]);
            value[i] = Integer.parseInt(wv[1]);
        }

        // dp 테이블을 위한 2차원 배열 생성
        int[][] dp = new int[n + 1][k + 1];

        // n개의 물건
        for(int i = 1; i <= n; i++){
            // 1~k 까지의 무게
            for(int j = 1; j <= k; j++){
                // 현재 무게가 더 커 가방에 못 들어 간다면
                if(weight[i] > j){
                    // 최적해
                    dp[i][j] = dp[i -1][j];
                // 들어갈 수 있다면
                }else{
                    // 최적해와 i-1번째까지 최대가치 와 현재 가치를 더 한 값 중 큰 값 선택
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
                }
            }
        }
        // n, k의 값이 최대값이 됨
        System.out.println(dp[n][k]);
    }
}
