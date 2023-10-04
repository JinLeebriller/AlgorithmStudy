import java.util.Scanner;

public class Algorithm_10_1_2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("기사의 위치(ex : a1) : ");
            String input = scan.next();
            char x = input.charAt(0);
            char y = input.charAt(1);
            if(x < 'a' || x > 'h' || y <'1' || y > '8'){
                System.out.println("a~h , 1~8 범위의 값을 하나씩 입력해주세요 (ex : a1)" );
                continue;
            }
            int result = sol(x,y);
            System.out.println("경우의 수 : " + result);
        }
    }

    public static int sol(char x, char y){
        int count = 0;

        if(x >= 'c' && x <= 'f'){
            if(y >= '3' && y<= '6'){
                count = 8;
            }else if(y == '2' || y == '7'){
                count = 6;
            }else{
                count = 4;
            }
        }else if(x == 'b' || x == 'g'){
            if(y >= '3' && y<= '6') {
                count = 6;
            }else if(y == '2' || y == '7'){
                count = 4;
            }else{
                count = 3;
            }
        }else{
            if(y == '1' || y == '8'){
                count = 2;
            }
        }

        return count;
    }
}
