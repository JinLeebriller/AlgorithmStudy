package algorithmStudy;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        Long[] min = new Long[testCase];
        String[] max = new String[testCase];

        long[] dp = new long[101];
        int[] addNum = {1, 7, 4, 2, 0, 8};
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;

        for(int i = 9 ; i < dp.length ; i++) {
            for(int j = 2 ; j <= 7 ; j++) {
                long comparison = dp[i - j] * 10 + addNum[j - 2];
                dp[i] = Math.min(comparison, dp[i]);
            }
        }

        for(int i = 0 ; i < testCase ; i++) {
            int count = Integer.parseInt(br.readLine());

            min[i] = dp[count];

            if(count > 3) {
                if (count % 2 == 0) {
                    max[i] = "";
                    for (int j = 0; j < count / 2; j++) {
                        max[i] += "1";
                    }
                } else {
                    max[i] = "7";
                    for (int j = 0; j < (count - 3) / 2; j++) {
                        max[i] += "1";
                    }
                }
            } else {
                if(count == 2) {
                    max[i] = "1";
                } else {
                    max[i] = "7";
                }
            }

            bw.write(min[i] + " " + max[i] + "\n");
            bw.flush();
        }
    }
}