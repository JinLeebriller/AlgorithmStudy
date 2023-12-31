package algorithmStudy;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int[][] XYN = new int[T][3];

        for(int i = 0 ; i < T ; i++) {
            String[] input =  sc.nextLine().split(" ");
            XYN[i] = new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])};
        }

        for(int i = 0 ; i < T ; i++) System.out.println((XYN[i][2] >= Math.abs(XYN[i][0]) + Math.abs(XYN[i][1]) && Math.abs(XYN[i][0] + XYN[i][1]) % 2 == Math.abs(XYN[i][2]) % 2) ? "YES" : "NO");
    }
}

