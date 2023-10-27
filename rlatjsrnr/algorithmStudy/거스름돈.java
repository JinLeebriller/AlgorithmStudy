import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("지불 금액 : ");
        int money = 1000 - scan.nextInt();

        System.out.println("잔돈의 개수 : " + coin(money));
    }

    public static int coin(int money){
        int result=0;
        result += (money / 500);
        money %= 500;

        if(money == 0) return result;

        result += (money / 100);
        money %= 100;

        if(money == 0) return result;

        result += (money / 50);
        money %= 50;

        if(money == 0) return result;

        result += (money / 10);
        money %= 10;

        if(money == 0) return result;

        result += (money / 5);
        money %= 5;

        if(money == 0) return result;

        result += (money);

        return result;
    }
}
