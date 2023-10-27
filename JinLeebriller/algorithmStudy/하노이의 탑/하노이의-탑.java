package algorithmStudy;

public class Solution {
    public static int[][] answer;
    public static int index = 0;

    public static void process(int n, int from, int via, int to){
        if(n == 0) return;
        process(n-1, from, to, via);
        answer[index][0] = from;
        answer[index++][1] = to;
        process(n-1, via, from, to);
    }

    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2, n) - 1][2];
        process(n, 1, 2, 3);
        return answer;
    }
}
