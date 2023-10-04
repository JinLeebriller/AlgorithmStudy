package algorithmStudy;

import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = "abcdefgh";
		String y = "12345678";
		int count = 0;
		int a,b;
		
		System.out.print("현재 나이트가 위치한 곳의 좌표 : ");
		String knight = sc.next();
		
		int knightX = x.indexOf(knight.charAt(0));
		int knightY = y.indexOf(knight.charAt(1));
		
		for(int i = 0 ; i < 2 ; i++) { 
			a = i == 0 ? knightX : knightY; 
			b = i == 0 ? knightY : knightX;
			if((a - 2 >= 0 && a + 2 <= 7) && (b - 1 >= 0 || b + 1 <= 7)) count++;
			if((a - 2 >= 0 && a + 2 <= 7) && (b - 1 >= 0 && b + 1 <= 7)) count++;
			if(b - 1 >= 0 || b + 1 <= 7) count++;
			if(b - 1 >= 0 && b + 1 <= 7) count++;
		}
		System.out.println("나이트가 이동할 수 있는 경우의 수 : " + count);
	}
}
