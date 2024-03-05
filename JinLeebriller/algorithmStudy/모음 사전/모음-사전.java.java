package algorithmStudy;

import java.util.*;

public class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] aeiou = {"A", "E", "I", "O", "U"};
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0 ; i < aeiou.length ; i++) {
            dfs(list, aeiou[i], aeiou);
        }

        for(int i = 0 ; i < list.size() ; i++) {
            if(list.get(i).equals(word)) {
                answer = i + 1;
            }
        }

        return answer;
    }

    void dfs(ArrayList<String> list, String str, String[] aeiou) {
        if(str.length() > 5) return;

        if(!list.contains(str)) list.add(str);

        for(int i = 0 ; i < 5 ; i++) {
            dfs(list, str + aeiou[i], aeiou);
        }
    }
}
