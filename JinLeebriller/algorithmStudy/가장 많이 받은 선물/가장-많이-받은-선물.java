package algorithmStudy;

import java.util.*;

public class Solution {
    public int solution(String[] friends, String[] gifts) {
        Arrays.sort(gifts);

        // 주고받은 선물
        Map<String, Integer> thisMonth = new HashMap<>();
        String[] temp = {""};
        int count = 1;

        for(int i = 0 ; i < gifts.length ; i++) {
            String[] tokenizer = gifts[i].split(" ");
            if(temp[0].equals(tokenizer[0] + " " + tokenizer[1])) {
                thisMonth.put(tokenizer[0] + " " + tokenizer[1], count++);
            } else {
                temp[0] = tokenizer[0] + " " + tokenizer[1];
                count = 1;
                thisMonth.put(temp[0], count++);
            }
        }
        System.out.println(thisMonth);

        // 선물 지수
        Map<String, Integer> point = new HashMap<>();

        for(int i = 0 ; i < friends.length ; i++) {
            point.put(friends[i], 0);
        }

        for(String key : thisMonth.keySet()) {
            String[] temp2 = key.split(" ");
            point.put(temp2[0], point.get(temp2[0]) + thisMonth.get(temp2[0] + " " + temp2[1]));
            point.put(temp2[1], point.get(temp2[1]) - thisMonth.get(temp2[0] + " " + temp2[1]));
        }

        System.out.println(point);

        // 받을 선물
        Map<String, Integer> nextMonth = new HashMap<>();

        for(int i = 0 ; i < friends.length ; i++) {
            nextMonth.put(friends[i], 0);
        }

        for(int i = 0 ; i < friends.length ; i++) {
            for(int j = 0 ; j < friends.length ; j++) {
                if(i == j) {
                    continue;
                }
                if(thisMonth.getOrDefault(friends[i] + " " + friends[j], 0) > thisMonth.getOrDefault(friends[j] + " " + friends[i], 0)) {
                    nextMonth.put(friends[i], nextMonth.get(friends[i]) + 1);
                } else if(thisMonth.getOrDefault(friends[i] + " " + friends[j], 0) == thisMonth.getOrDefault(friends[j] + " " + friends[i], 0)) {
                    if(point.get(friends[i]) > point.get(friends[j])) {
                        nextMonth.put(friends[i], nextMonth.get(friends[i]) + 1);
                    }
                }
            }
        }

        // 가장 많은 선물을 받는 친구가 받을 선물의 수
        int answer = 0;
        for(int i = 0 ; i < nextMonth.size() ; i++) {
            if(answer < nextMonth.get(friends[i])) {
                answer = nextMonth.get(friends[i]);
            }
        }

        return answer;
    }
}