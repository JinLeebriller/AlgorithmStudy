class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int banding = 0; // 붕대를 계속 감아요
        int maxHealth = health; // 현재 체력, 초기값은 최대 체력
        int time = 0; // 현재 시간
        int result = 0; // 최종 결과
        
        for (int[] attack : attacks) {  
            while (true) {
                time++;
                if (time == attack[0]) {
                    maxHealth -= attack[1];
                    banding = 0;

                    if (maxHealth <= 0) {
                        return -1; // 체력이 0 이하인 경우 즉시 -1 반환
                    }
                    break;
                } else {
                    if (maxHealth != health) {
                        banding++;
                        maxHealth += bandage[1];
                        if (banding == bandage[0]) {
                            maxHealth += bandage[2];
                            banding = 0;
                        }
                        if (maxHealth > health) maxHealth = health;
                    }
                }
            }
            if (time == attacks[attacks.length - 1][0]) {
                return maxHealth; // 마지막 공격 이후 체력 반환
            }

        }
        
        return result;
    }
}
