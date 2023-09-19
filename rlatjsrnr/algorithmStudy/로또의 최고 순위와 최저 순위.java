class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
      int[] rate = {6,6,5,4,3,2,1};
        int answer[] = new int[2];
        int cnt = 0;
        int cntZero = 0;
        for(int i : lottos){
            if(i == 0){
                cntZero++;
                continue;
            }
            for(int j : win_nums){
                if(j == i){
                    cnt++;
                }
            }
        }

        answer[0] = rate[cnt+cntZero];
        answer[1] = rate[cnt];
        return answer;
    }
}
