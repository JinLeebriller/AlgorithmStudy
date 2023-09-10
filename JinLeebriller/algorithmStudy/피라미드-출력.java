

// Q. n단의 피라미드를 출력하는 메서드를 작성하세요.
/*
 	    *
 	   ***
 	  *****
 	 *******
*/
public class 피라미드_출력 {
	
	static void spira(int n) {
		for(int i = 1 ; i <= n ; i++) {
			for(int j = n ; j > i ; j--) {
				System.out.print(" ");
			}
			
			for(int y = 1 ; y <= (i - 1) * 2 + 1 ; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		spira(5);
	}
	
}
