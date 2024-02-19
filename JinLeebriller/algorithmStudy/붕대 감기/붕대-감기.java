package algorithmStudy;

public class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int bandageCnt, attacksCnt;
        bandageCnt = attacksCnt = 0;

        for(int i = 1 ; i <= attacks[attacks.length - 1][0] ; i++) {
            bandageCnt++;

            // bandage
            if(i != attacks[attacksCnt][0] && bandageCnt == bandage[0]) {
                answer += bandage[1] + bandage[2];
                if(answer > health) {
                    answer = health;
                }
                bandageCnt = 0;
            } else if(i != attacks[attacksCnt][0] && bandageCnt != bandage[0] && answer < health) {
                answer += bandage[1];
                if(answer > health) {
                    answer = health;
                }
            }

            // attack
            if(i == attacks[attacksCnt][0]) {
                answer -= attacks[attacksCnt][1];
                attacksCnt++;
                bandageCnt = 0;
            }

            // die
            if(answer <= 0) {
                return -1;
            }
        }

        return answer;
    }
}