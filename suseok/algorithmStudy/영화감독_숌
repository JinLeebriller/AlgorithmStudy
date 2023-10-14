
package suseok;

import java.util.Scanner;

public class film_director {
	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        System.out.println("입력할 세상의 종말의 시리즈 n은? : ");
        int n = sc.nextInt();
        sc.close();
        
        if (n <= 0 || n > 10000) {
            System.out.println("그런 시리즈는 존재하지 않습니다");
            return;
        }

        int series = 666;
        int count = 0;

        while (true) {
            if (String.valueOf(series).contains("666")) {
                count++;
            }
            if (count == n) {
                break;
            }
            series++;
        }

        System.out.println("세상의 종말 " + series);
    }
}
