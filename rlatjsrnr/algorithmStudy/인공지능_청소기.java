import java.util.Scanner;

public class AIVacuum {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("테스트 횟수 : ");
        int t = scan.nextInt();
        scan.nextLine();
        String[] result = new String[t];
        System.out.println("도착 위치 x좌표, y좌표, 도착 시간을 공백을 기준으로 테스트 횟수 만큼 입력 해 주세요");
        for(int i = 0; i < t; i++){
            String input = scan.nextLine();
            String[] xyn = input.split(" ");
            result[i] = sol(Integer.parseInt(xyn[0]),
                               Integer.parseInt(xyn[1]),
                               Integer.parseInt(xyn[2])
                       );

        }
        for(String s : result) System.out.println(s);
    }

    static String sol(int x, int y, int n){
        x = Math.abs(x);
        y = Math.abs(y);

        if(n >= x+y && (x+y)%2 == n%2) return "Yes";
        return "No";
    }
}
