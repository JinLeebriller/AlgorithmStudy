package algorithmStudy;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0, distance = 0;
        int[] counts = new int[5];
        String[] outcomes = {"모", "도", "개", "걸", "윷"};

        while(count < 10) {
            String[] results = sc.nextLine().split(" ");
            int countOne = 0;

            for(String result : results) if(result.equals("1")) countOne++;

            System.out.println(outcomes[countOne]);

            if(countOne == 0) distance += 5;
            else distance += countOne;
            counts[countOne]++;
            count++;
        }

        for(int i = 0 ; i < counts.length ; i++) System.out.printf("%s %d회, ", outcomes[i], counts[i]);
        System.out.printf("총 %d칸 전진하였습니다.", distance);
    }
}
