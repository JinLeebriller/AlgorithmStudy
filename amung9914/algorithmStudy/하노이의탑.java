/*
너무 어려워서 책을 참고했습니다...
*/

import java.util.*;
class Solution {
    static List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = new int[(int)Math.pow(2,n)-1][2];
        move(n,1,3);
        for(int i=0; i<list.size();i++){
            answer[i]= list.get(i);
        }
        return answer;   
    }
    public static void move(int num, int x, int y){ // 옮길원반개수,원래위치,목표위치
        if(num>1) // n-1까지 1라인을 중간으로 옮기기
            move(num-1,x,6-x-y);
       
        list.add(new int[]{x,y}); // n을 목표 위치로 옮기기
       
        if(num>1)   // 중간위치에 있는 것들을 목표위치로 옮기기
            move(num-1,6-x-y,y);
    }
}
