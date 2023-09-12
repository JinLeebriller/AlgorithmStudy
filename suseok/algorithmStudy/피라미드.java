//Q. 직각이등변삼각형을 출력하는 부분을 아래와 같은 형식의 메서드로 작성하세요.
public class collect {
	
	// 왼쪽 아래가 직각인 이등변삼각형을 출력
	/*
		 *
		 **
		 ***
		 ****
	*/
	
	static void triangleLB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 왼쪽 위가 직각인 이등변삼각형을 출력
	/*
		 ****
		 ***
		 **
		 *
	*/
	static void triangleLU(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 오른쪽 위가 직각인 이등변삼각형을 출력
	/*
		 ****
		  ***
		   **
		    *
	*/
	
	static void triangleRU(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} 
	
	// 오른쪽 아래가 직각인 이등변삼각형을 출력
	/*
		    *
		   **
		  ***
		 ****
	*/
	static void triangleRB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n - i + 1; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int n = 4;
		
		System.out.println("왼쪽 아래가 직각인 이등변삼각형:");
		triangleLB(n);
		
		System.out.println("\n왼쪽 위가 직각인 이등변삼각형:");
		triangleLU(n);
		
		System.out.println("\n오른쪽 위가 직각인 이등변삼각형:");
		triangleRU(n);
		
		System.out.println("\n오른쪽 아래가 직각인 이등변삼각형:");
		triangleRB(n);
	}
	
}

