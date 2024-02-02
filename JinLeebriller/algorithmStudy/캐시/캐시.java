package algorithmStudy;

import java.util.LinkedList;

public class Solution {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for(int i = 0 ; i < cities.length ; i++) {
            cities[i] = cities[i].toLowerCase();
            if(cache.size() == cacheSize + 1) {
                cache.removeLast();
            }
            if(cache.contains(cities[i])) {
                cache.remove(cities[i]);
                cache.addFirst(cities[i]);
                answer += 1;
            }
            if(!cache.contains(cities[i])) {
                cache.addFirst(cities[i]);
                answer += 5;
            }
        }

        return answer;
    }
}