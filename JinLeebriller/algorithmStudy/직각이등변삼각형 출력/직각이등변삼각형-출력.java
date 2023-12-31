public class Solution {
	// 왼쪽 아래가 직각인 이등변삼각형을 출력
	static void triangleLB(int n) {
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 왼쪽 위가 직각인 이등변삼각형을 출력
	static void triangleLU(int n) {
		for(int i = n ; i >= 1 ; i--) {
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 오른쪽 위가 직각인 이등변삼각형을 출력
	static void triangleRU(int n) {
		for(int i = 1 ; i <= n ; i++) {
			for(int y = 1 ; y < i ; y++) {
				System.out.print(" ");
			}
			
			for(int j = n ; j >= i ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// 오른쪽 아래가 직각인 이등변삼각형을 출력
	static void triangleRB(int n) {
		for(int i = 1 ; i <= n ; i++) {
			for(int y = n ; y > i ; y--) {
				System.out.print(" ");
			}
			
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
