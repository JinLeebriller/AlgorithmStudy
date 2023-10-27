/*
너무 어려워서 책을 참고했습니다...
*/

import java.util.*;
class Solution {
    
    static int[][] answer;
    static int count=0;
    
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2,n)-1][2];
        move(n,1,3);
        return answer; 
    }
    public static void move(int num, int x, int y){ // 개수,원래위치,목표위치
        if(num>1) //중간으로 옮기기
            move(num-1,x,6-x-y);

        answer[count++] = new int[]{x,y};

        if(num>1)   // 목표위치로 옮기기
            move(num-1,6-x-y,y);
    }
}
