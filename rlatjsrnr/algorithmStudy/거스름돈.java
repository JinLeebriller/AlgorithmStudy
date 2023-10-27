import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("지불 금액 : ");
        int money = 1000 - scan.nextInt();

        System.out.println("잔돈의 개수 : " + coin(money));
    }

    public static int coin(int money){
        int[] coins = {500, 100, 50, 10, 5, 1};
        int result=0;
        for(int i : coins){
            result += (money / i);
            money %= i;
            if(money == 0) break;
        }
        return result;
    }
}
