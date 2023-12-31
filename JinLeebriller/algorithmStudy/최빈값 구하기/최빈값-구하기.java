package algorithmStudy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] array) {
        int answer = 1;
        int bestNum = 0;
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(array);

        for(int i = 0 ; i < array.length ; i++) {
            if(temp != array[i]) answer = 1;
            temp = array[i];
            map.put(array[i], answer++);
        }

        temp = 0;

        for(int num : map.keySet()) {
            temp = map.get(num);
            if(temp > bestNum) {
                bestNum = temp;
                answer = num;
            } else if (temp == bestNum) {
                answer = -1;
            }
            temp = 0;
        }

        return answer;
    }
}