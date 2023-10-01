import java.util.Scanner;

public class Knight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("현재 나이트의 좌표: ");
        String state = scanner.next();
        int x = 0;
        int y = 0;
        String xStr = "abcdefgh";
        String yStr = "12345678";

        //현재 좌표 담기
        for(char n : state.toCharArray()){
            for(int i = 0; i<8;i++){
                if(n == (xStr.charAt(i))){
                    x = i + 1;
                    System.out.println("x좌표는"+x);
                }else if(n == (yStr.charAt(i))){
                    y = i + 1;
                    System.out.println("y좌표는"+y);
                }
            }
        } // end for
        int result1 = calc(x,y);
        int result2 = calc(y,x);
        int result = result1 + result2;
        System.out.println("경우의 수는 "+result);
    }

    //x좌표 y좌표 경우의 수 구하기
    static int calc(int x, int y){
        int count = 0;
        if(x > 2){
            if(x + 2 <= 8){
                if(y + 1 <= 8 && y>1){
                  count +=4;
                }else{
                    count += 3;
                }
            }else{
                if(y + 1 <= 8 && y>1){
                    count += 2;
                }else{
                    count += 1;
                }
            }
        }else{
            if(y + 1 <= 8 && y>1){
                count +=2;
            }else{
                count += 1;
            }
        }

        return count;
    }
}
