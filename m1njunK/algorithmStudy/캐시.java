import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if(list.remove(city)){
                answer += 1;
                list.add(city);
            } else {
                if(list.size() >= cacheSize){
                    list.remove(0);
                }
                answer += 5;
                list.add(city);
            }
        }
        
        return answer;
    }
}
