ublic class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int life = health;
        int idx = 0;
        int count = 0;
        for (int i = 1; i <= attacks[attacks.length-1][0]; i++) {
            if(i==attacks[idx][0]){
                count = 0;
                life -= attacks[idx][1];
                idx++;

                if(life<=0){
                    return -1;
                }

            }else{
                int band = bandage[1];
                if(life<health){
                    ++count;
                    life += band;
                    if(life>=health){
                        life = health;
                    }
                }
                if(count == bandage[0] && life<health){
                    life += bandage[2];
                    if(life>=health){
                        life = health;
                    }
                    count = 0;
                }
            }
        }
        return life;
    }
}
