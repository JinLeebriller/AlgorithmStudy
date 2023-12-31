// Q. 직각이등변삼각형을 출력하는 부분을 아래와 같은 형식의 메서드로 작성하세요.
public class Solution {

	
	public static void main(String[] args) {
		triangleRB(4);
	}
	
	// 왼쪽 아래가 직각인 이등변삼각형을 출력
	/*
		 *
		 **
		 ***
		 ****
	*/
	static void triangleLB(int n){
		for(int i = 0; i<n; i++) {
			for(int j=0; j<=i; j++) {
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
	static void triangleLU(int n){
		for(int i = n; i>0; i--) {
			for(int j=i; j>0; j--) {
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
	static void triangleRU(int n){
		for(int i = 0; i<n; i++) {
			for(int j=0; j<=n; j++) {
				if(j>i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
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
	static void triangleRB(int n){
		for(int i = n; i>0; i--) {
			for(int j=0; j<=n; j++) {
				if(i<j+1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();	
		}
	} 
}

