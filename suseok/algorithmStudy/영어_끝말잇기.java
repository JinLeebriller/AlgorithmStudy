import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0}; // 결과 배열 초기화

        // 이전에 등장한 단어를 저장하기 위한 HashSet
        HashSet<String> usedWords = new HashSet<>();

        char lastChar = words[0].charAt(words[0].length() - 1); // 첫 번째 단어의 마지막 글자
        usedWords.add(words[0]); // 첫 번째 단어를 등장한 단어로 추가

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            
            // 끝말잇기 규칙 검사
            if (lastChar != word.charAt(0) || usedWords.contains(word)) {
                answer[0] = (i % n) + 1; // 탈락한 사람의 번호
                answer[1] = (i / n) + 1; // 탈락한 차례
                break;
            } else {
                lastChar = word.charAt(word.length() - 1);
                usedWords.add(word);
            }
        }

        return answer;
    }
}

