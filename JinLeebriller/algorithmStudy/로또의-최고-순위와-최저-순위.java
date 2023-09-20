package algorithm3;

import java.util.Arrays;

public class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] rank = {6, 6, 5, 4, 3, 2, 1};
		int count = 0;
		int countZero = 0;
		
		for(int i = 0 ; i < 6 ; i++) {
			if(lottos[i] == 0) countZero++;
			for(int j = 0 ; j < 6 ; j++) if(win_nums[i] == lottos[j]) count++;
		}
		
        int[] answer = {rank[count + countZero], rank[count]};
        return answer;
    }
}

