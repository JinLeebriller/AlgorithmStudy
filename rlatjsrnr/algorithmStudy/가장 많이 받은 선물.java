import java.util.HashMap;

public class 가장많이받은선물 {
    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        // 사람 별로 맵 생성
        HashMap<String, HashMap<String, Integer>> given_gift = new HashMap<>();
        HashMap<String, Integer> gift_index = new HashMap<>();
        HashMap<String, Integer> gift_to_receive_count = new HashMap<>();

        for(String name : friends){
            given_gift.put(name, new HashMap<>());
            for(String friend : friends){
                if(friend.equals(name)) continue;
                given_gift.get(name).put(friend, 0);
            }
            gift_index.put(name, 0);
            gift_to_receive_count.put(name, 0);
        }
        
        // 선물을 주고 받은 리스트 작성
        for(String names : gifts){
            String[] name = names.split(" ");
            HashMap<String, Integer> given_gift_map = given_gift.get(name[0]);
            given_gift_map.put(name[1], given_gift_map.getOrDefault(name[1], 0) + 1);

            // 선물 지수
            gift_index.put(name[0], gift_index.getOrDefault(name[0], 0) + 1);
            gift_index.put(name[1], gift_index.getOrDefault(name[1], 0) - 1);
        }

        // 선물을 주고 받았을 때 받을 선물 계산
        for(String name : friends){
            for(String friend : friends){
                if(name.equals(friend)) continue;
                int given_count = given_gift.get(name).get(friend);
                int receive_count = given_gift.get(friend).get(name);

                if(given_count > receive_count){
                    gift_to_receive_count.put(name, gift_to_receive_count.getOrDefault(name, 0) + 1);
                }else if(given_count == receive_count && given_count != 0){
                    if(gift_index.get(name) > gift_index.get(friend)){
                        gift_to_receive_count.put(name, gift_to_receive_count.getOrDefault(name, 0) + 1);
                    }
                }
                // 선물을 주고 받지 않았을 경우
                if(given_count == 0 && receive_count == 0){
                    if(gift_index.get(name) > gift_index.get(friend)){
                        gift_to_receive_count.put(name, gift_to_receive_count.getOrDefault(name, 0) + 1);
                    }
                }
            }
        }

        // 선물을 가장 많이 받을 사람의 선물 개수
        int answer = 0;
        for (Integer value : gift_to_receive_count.values()) {
            answer = Math.max(value, answer);
        }
        System.out.println(answer);
    }
}
