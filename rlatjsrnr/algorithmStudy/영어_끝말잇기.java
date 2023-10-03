import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        int[] player = new int[n];
        Set<String> wordList = new HashSet<>();
        
        for(int i=0; i<words.length; i++){

            int playerNum = (i%n)+1;
            player[playerNum-1]++;
            
            
            if(words[i].charAt(0) == words[i-1].charAt(words[i-1].length()-1)){
                // 끝 말을 이엇지만 중복    
                if(wordList.contains(words[i])){
                    answer[0] = playerNum;
                    answer[1] = player[playerNum-1];
                    break;
                }
            }else{
                // 끝맛잇기 실패
                answer[0] = playerNum;
                answer[1] = player[playerNum-1];
                break;
            }
            // 끝말잇기를 성공하면 저장
            wordList.add(words[i]);
        }
        return answer;
    }
}
