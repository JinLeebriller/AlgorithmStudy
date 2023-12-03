package algorithmStudy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int j = N - 1;
        int result = 0;

        int[] A = new int[N];
        int[] B = new int[N];

        for(int i = 0 ; i < N ; i++) A[i] = sc.nextInt();
        for(int i = 0 ; i < N ; i++) B[i] = sc.nextInt();

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0 ; i < N ; i++, j--) {
            result += A[i] * B[j];
        }

        System.out.println(result);
    }
}