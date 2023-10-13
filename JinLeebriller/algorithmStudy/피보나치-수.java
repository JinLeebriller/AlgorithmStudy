package algorithmStudy;

class Solution {
    public static int solution(int n) {
    	int answer = 0;
    	int prevPrevNum = 0;
    	int prevNum = 1;
    	
    	for(int i = 2 ; i <= n ; i++) {
    		answer = (prevPrevNum + prevNum) % 1234567;
    		prevPrevNum = prevNum;
    		prevNum = answer;
    	}
    	
        return answer;
    }
}
