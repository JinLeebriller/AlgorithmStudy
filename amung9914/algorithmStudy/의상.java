import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
          /**
         *
         * 노란모자, 초록모자 [모자]
         * 파란색 선글라스 [안경]
         *
         * 경우의 수 5
         *
         * 한 분류의 경우의 수 = 2P1 + 1(이 분류를 안입을 경우의 수)
         * 총 경우의수 -1(다안입는거)
         *
         * 두 사건이 동시에 일어날때는 경우의 수를 곱한다
         *
         */
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1],new ArrayList<>());
        }
        for (int i = 0; i < clothes.length; i++) {
            ArrayList<String> list = map.get(clothes[i][1]);
            list.add(clothes[i][0]);
            map.put(clothes[i][1],list);
        }

        int count = 0;
        if(map.keySet().size()!=1){
            int sum = 1;
            for (ArrayList<String> value : map.values()) {
                int num = value.size();
                sum *= num+1;
            }
            count = sum;
            count--;
        }else{
            count = clothes.length;
        }

        return count;
    }
}
