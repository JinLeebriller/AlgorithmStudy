import java.util.Scanner;

public class Test1027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("물건의 가격을 입력하세요");
        int price = 1000-scanner.nextInt();
        System.out.println(balance(price));
    }
    public static int balance(int price){
        int count = 0;
        int[] arr = {500,100,50,10,5,1};
        count += price/arr[0];
        for(int i = 0; i<arr.length-1; i++){
            count += (price%arr[i])/arr[i+1];
        }
        return count;
    }
}
