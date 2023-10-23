package algorithmStudy;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cost;

        do {
            System.out.print("타로가 지불해야 할 돈은? : ");
            cost = Integer.parseInt(sc.nextLine());
        } while(cost < 1 || cost > 1000);

        int change = 1000 - cost, count = 0;

        for(int coin : new int[]{500, 100, 50, 10, 5, 1}) {
            count += change / coin;
            change %= coin;
        }

        System.out.println("최소 잔돈의 개수는 : " + count);
    }
}