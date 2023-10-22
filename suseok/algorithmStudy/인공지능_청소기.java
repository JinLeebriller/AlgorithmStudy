package suseok;

import java.util.Scanner;

public class RobotCleaner {

    public static void main(String[] args) {
    	
    	System.out.print("테스트를 시행할 횟수를 정하세요 : ");
        Scanner scanner = new Scanner(System.in);
        
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
        	
        	System.out.print("공백을 포함해 x,y,n 을 입력하세요 : (ex:1 2 3) ");
        	
        	// 공백을 구분하기 위해
            String[] move = scanner.nextLine().split(" ");
            
            int x = Integer.parseInt(move[0]);
            int y = Integer.parseInt(move[1]);
            int n = Integer.parseInt(move[2]);
            
            //abs() 함수는 인자값에 대한 절대값을 반환하는 함수 입니다. 인자값의 타입으로는 int, float, long, double 등 primitive data type 입력이 가능합니다. 
            //Math 클래스의 함수중 하나로 static 함수 입니다. 

            int sum = Math.abs(x) + Math.abs(y);
            
            // 정답 기본값을 NO로 입력
            String answer = "NO";
            
            // 총 이동거리가 n보다 작거나 같고 n의 차이가 짝수라면 YES를 출력한다.
            if (sum <= n && (sum - n) % 2 == 0) {
                answer = "YES";
            }

            System.out.println(answer);
        }
        scanner.close();
    }
}


