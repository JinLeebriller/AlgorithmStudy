// 문제를 다시 정리하는거지만
// 선물을 받는 friends랑 받는 선물인 gifts를 입력받아 표 형식으로 저장을 해 결과값을 return하는 코드


package suseok;

import java.util.HashMap;

public class Many_Gift {

    public static int solution(String[] friends, String[] gifts) {
    	
        int answer = 0;
        
        int friendsLength = friends.length;
        
        HashMap<String, Integer> dic = new HashMap<>();
        
        int[] giftCheck = new int[friendsLength];
        
        int[][] giftResult = new int[friendsLength][friendsLength];

        for (int i = 0; i < friendsLength; i++) {
            dic.put(friends[i], i);
        }

        for (String gift : gifts) {
            String[] giftName = gift.split(" ");
            giftCheck[dic.get(giftName[0])]++;
            giftCheck[dic.get(giftName[1])]--;
            giftResult[dic.get(giftName[0])][dic.get(giftName[1])]++;
        }

        for (int i = 0; i < friendsLength; i++) {
            int num = 0;
            for (int j = 0; j < friendsLength; j++) {
                if (i == j) {
                    continue;
                }

                if (giftResult[i][j] > giftResult[j][i] ||
                        (giftResult[i][j] == giftResult[j][i] && giftCheck[i] > giftCheck[j])) {
                    num++;
                }
            }

            if (answer < num) {
                answer = num;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
    	
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        
        int result = solution(friends, gifts);
        
        System.out.println("다음 달에 가장 많이 받을 선물의 수: " + result);
    }
}

  


