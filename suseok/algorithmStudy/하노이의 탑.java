//참고한 사이트 입니다.
//https://st-lab.tistory.com/96


import java.util.Scanner;

class Solution {
    public int[][] solution(int n) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int[][] moves = hanoi(n, 1, 2, 3, sb);
        sc.close();
        
        System.out.println(sb.toString()); // 결과 출력
        
        return moves;
    }
    
    // 하노이 탑을 해결하는 재귀 함수
    private int[][] hanoi(int n, int start, int mid, int to, StringBuilder sb) {
        if (n == 1) {
            sb.append(start).append(' ').append(to).append('\n');
            return new int[][]{{start, to}};
        } else {
            int[][] move1 = hanoi(n - 1, start, to, mid, sb);
            sb.append(start).append(' ').append(to).append('\n');
            int[][] move2 = hanoi(n - 1, mid, start, to, sb);
            int[][] result = new int[move1.length + move2.length + 1][2];
            int index = 0;
            
            for (int i = 0; i < move1.length; i++) {
                result[index++] = move1[i];
            }
            
            result[index++] = new int[]{start, to};
            
            for (int i = 0; i < move2.length; i++) {
                result[index++] = move2[i];
            }
            
            return result;
        }
    }
}
