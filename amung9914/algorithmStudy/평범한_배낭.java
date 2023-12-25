import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack {

    static int[][] dp;
    static int[] weightarr;
    static int[] valuearr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCount = scanner.nextInt();
        int maxWeight = scanner.nextInt();
        weightarr = new int[totalCount+1];
        valuearr = new int[totalCount+1];
        dp = new int[totalCount+1][maxWeight+1];

        for (int i = 0; i < totalCount; i++) {
            weightarr[i] = scanner.nextInt();
            valuearr[i] = scanner.nextInt();
        }

        for(int i=1; i<=totalCount; i++){
            for(int j = 1; j<= maxWeight; j++){
                if(weightarr[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weightarr[i]]+valuearr[i]);
                }
            }
        }
        System.out.println(dp[totalCount][maxWeight]);

    }


}
