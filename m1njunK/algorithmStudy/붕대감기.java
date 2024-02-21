class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];//시전시간
        int x = bandage[1];//초당 회복량
        int y = bandage[2];//추가 회복량
        int hp = health;//현재체력
        int time = attacks[attacks.length-1][0]; //총 시간
        int idx = 0;
        int cnt = 0; //연속 성공 횟수
        
        for(int i = 1; i <= time; i++) {
        	int at = attacks[idx][0]; //공격시간
        	int dmg = attacks[idx][1]; //피해량
            if(i == at){ //공격받은시간
                hp -= dmg; //체력 감소
                cnt = 0; //연속 성공 횟수 초기화
                idx++;
            } else { //공격에 성공한 경우
                cnt++; //연속 성공 횟수 증가
                if(cnt == t){ //연속 성공 횟수가 시전시간과 같을 경우
                    hp += y+x; //추가 회복량 만큼 더 회복
                    cnt = 0; //연속 성공 횟수 초기화
                } else {
                    hp+=x; //현재체력+=초당 회복량   
                }
            }
        	hp = hp > health ? health : hp; //현재 체력이 최대체력보다 커질경우 최대체력으로 설정
            if(hp <= 0) { //사망한경우
        		return -1;
        	}
        }
        return hp;
    }
}
