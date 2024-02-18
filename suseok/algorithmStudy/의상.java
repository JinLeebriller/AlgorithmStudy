// map을 사용하여 카운트 하는 방식으로 사용했으며
// getOrDefault(Object key, V DefaultValue)
// 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
// 를 사용해서 정답을 도출해냄

import java.util.HashMap; 

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();       
        
        // 코니는 하루에 최소 한 개의 의상은 입습니다.
        int answer = 1;

        // 옷을 종류별로 나누었음
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); 
        }
        
        for(String key : map.keySet()) {+
            answer *= (map.get(key) + 1);   // 입지 않았을때도 있으니까 +1로 함
        }
        
        answer -= 1; // 안입었으면 -1을 반환
        
        return answer;
    }
}
