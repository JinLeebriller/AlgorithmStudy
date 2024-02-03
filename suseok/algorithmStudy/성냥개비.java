// 숫자를 제시하면 해당하는 숫자에 해당하는 성냥개비를 사용해 표현 할 수 있는 가장 낮은 수와 가장 높은 수를 표시하면 됨
// 문제가 어려워서 찾아보니 
// Dynamic Programming - 동적 계획법, 알고리즘 설계 기법
// DP를 위한 참고 사이트 
// https://loosie.tistory.com/150
// 라고 하는데 흠..

    /* 필요한 성냥개비 갯수
		 * 
		 * 2개 = 1
		 * 
		 * 3개 = 7
		 * 
		 * 4개 = 4
		 * 
		 * 5개 = 2,3,5
		 * 
		 * 6개 = 0,6,9
		 * 
		 * 7개 = 8
		 * 
		 */

// 제시한 숫자를 나눴을 최솟값은 1,7,4,2,0,8로 볼수 있음
// 이 다음에 어떻게 하지

import java.io.*;
import java.util.*;
 
public class Main {
    static long [] dp;
    static int [] arr= {1,7,4,2,0,8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        dp = new long[101];
 
        Arrays.fill(dp,Long.MAX_VALUE);
 
        dp[2]=1;
        dp[3]=7;
        dp[4]=4;
        dp[5]=2;
        dp[6]=6;
        dp[7]=8;
        dp[8]=10;
 
        StringBuilder sb;
 
 
        for(int i=9; i<=100; i++){
            for(int j=2; j<=7; j++){
                String temp = String.valueOf(dp[i-j])+String.valueOf(arr[j-2]);
                dp[i] = Math.min(Long.parseLong(temp),dp[i]);
            }
        }
 
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
 
            sb.append(dp[n]).append(" ");
            if(n%2==0){
                sb.append(convertMax(n/2));
            }
            else{
                sb.append("7").append(convertMax((n-3)/2));
            }
 
            System.out.println(sb.toString());
        }
    }
 
    private static String convertMax(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("1");
        }
        return sb.toString();
    }
}
