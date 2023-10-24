package algorithmStudy;

import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 666;
		int count = 1;
		int N;
		
		do {
			System.out.print("N값 입력 : ");
			N = sc.nextInt();
		} while(N <= 0 || N > 10000);
 
		while(count != N) {
			num++;
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}
		System.out.println("N번째 영화의 제목에 들어간 수 : " + num);
	}
}
