// 문제 이해가 안가서 좀 찾아보니까
// DFS로 풀수도 있는데
// int values에서 배열 쓴 이유가
// 각 자리수의 경우의 수가 다섯 번째 자리에는 하나의 수가 들어오고
// 그 다음 네번째 자리에는 a,e,o,u,i 5개에다가 하나를 더해 총 여섯개가 들어오는 형식으로
// 계산하다 보니까 1, 5+1, 6*5+1, 31*5+1, 156*5+1
// 이런식으로 올라가다보니 문제를 이렇게 풀수도 있더라구요

class Solution {
    public int solution(String word) {
        
        int answer = 0;
        
        // 사전을 구성할 때, 각 자리의 알파벳이 가지는 가치를 고려하여 계산
        // A: 0, E: 1, I: 2, O: 3, U: 4
        
        int[] values = {781, 156, 31, 6, 1};
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            // 현재 자리의 알파벳이 가지는 가치를 더함
            answer += "AEIOU".indexOf(c) * values[i] + 1;
        }
        return answer;
    }
}

