import java.util.Scanner;

public class Algorithm_10_2_1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = 0;

        while(n < 1 || n > 10000){
            System.out.print("1~10000 사이의 자연수를 입력해주세요 : ");
            n = scan.nextInt();
        }

        int titleNumber = 666;
        int count = 1;

        while(true){
            if(String.valueOf(++titleNumber).contains("666")){
                if(++count == n) break;
            }
        }
        System.out.print("n번째 영화 제목 : 세상의 종말 " + titleNumber);
    }
}
