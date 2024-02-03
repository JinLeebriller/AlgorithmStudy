//카톡을 보며 힌트를 얻은 LinkedList로 풀이를 진행해봤음
//https://inpa.tistory.com/entry/JAVA-%E2%98%95-LinkedList-%EA%B5%AC%EC%A1%B0-%EC%82%AC%EC%9A%A9%EB%B2%95-%EC%99%84%EB%B2%BD-%EC%A0%95%EB%B3%B5%ED%95%98%EA%B8%B0/
//https://hstory0208.tistory.com/142
//라고 하던데 한번 참고 해보았습니다
//cache hit일 경우 실행시간은 1이다.
//cache miss일 경우 실행시간은 5이다.

import java.util.LinkedList;
import java.util.List;
 
public class 캐시 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
 
    }
 
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
 
        // 캐시크기가 0일 경우
        if (cacheSize == 0) {
            return cities.length * 5;
        }
 
        List<String> caches = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase(); 
          
            // cache miss 일 경우
            if (!caches.contains(city)) {
                answer += 5;
                if (caches.size() >= cacheSize) {

                    caches.remove(0);
                }
                caches.add(city);
                continue;
            }
 
            // cache hit 일 경
            if (caches.contains(city)) {
                caches.remove(city);
                caches.add(city);
                answer += 1;
            }
        }
        return answer;
    }
}
