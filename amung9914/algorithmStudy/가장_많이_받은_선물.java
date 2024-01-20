import java.util.ArrayList;
import java.util.List;

public class kakao1 {

    static public int solution(String[] friends, String[] gifts) {

        //준사람 받은 사람
        int[][] record = new int[friends.length][friends.length];
        int[] point = new int[friends.length]; // 준 선물의 수 - 받은 선물의 수

        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            int fromIndex = calcArr(friends, temp[0]);// 준 사람;
            point[fromIndex]++;
            int toIndex = calcArr(friends, temp[1]);// 받은 사람;
            point[toIndex]--;
            record[fromIndex][toIndex] ++;
        }


        for (int i : point) {
            System.out.println("i = " + i);
        }


        int[] count = new int[friends.length];
        // 선물 안주고받은사람 찾기
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record[i].length; j++) {
                if(record[i][j]>record[j][i]){
                    count[i]++;
                }
                if((record[i][j]==0 && record[j][i]==0)||(record[i][j]==record[j][i])&&i!=j){
                    if(point[i]>point[j])
                        count[i]++;
                }
            }
        }

        int max = count[0];
        for (int i : count) {
            if(max<i){
                max = i;
            }
        }
        return max; // 가장 많은 선물을 받는 친구가 받을 선물의 수
    }

    static public int calcArr(String[] friends, String s){
        for (int i = 0; i < friends.length; i++) {
            if(s.equals(friends[i]))
                return i;
        }
            return -1;
    }

    public static void main(String[] args) {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution(friends,gifts));
    }

}
