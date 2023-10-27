import java.util.*;
class Solution {
    
    ArrayList<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1,2,3);
        int[][] answer = new int[list.size()][2];        
        for(int i=0; i<list.size(); i++){                        
            answer[i] = list.get(i);            
        }       
        
        return answer;
    }
    
    // 1 -> 3
    public void hanoi(int n, int first, int second, int third){
        if(n == 1) {
            list.add(new int[]{first, third});
            return;            
        }        
        // n-1 : 1 -> 2 
        hanoi(n-1, first, third, second);
        // n : 1 -> 3
        list.add(new int[]{first, third});
        // n-1 : 2 -> 3
        hanoi(n-1, second, first, third);
        
    }
}
