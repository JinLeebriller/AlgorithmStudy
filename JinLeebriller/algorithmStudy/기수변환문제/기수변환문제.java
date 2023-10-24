package algorithmStudy;

import java.util.Scanner;

public class 기수변환문제 {
	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		int decimal = 0;
		int num = 0;
		int index = 0;
		char[] cno = new char[32];
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		System.out.println("10진수를 기수 변환합니다.");
		System.out.print("변환하는 음이 아닌 정수:");
		do {
			decimal = stdIn.nextInt();
		}while(decimal < 0);
		
		System.out.print("어떤 진수로 변환할까요?(2~36):");
		do {
			num = stdIn.nextInt();
		}while(num < 2 || num > 36);
		
		System.out.printf("%4d|%8d\n",num,decimal);
		System.out.println("    +---------");
		
		do {
			cno[index++] = dchar.charAt(decimal % num);
			decimal /= num;
			if(decimal == 0) {
				System.out.println("            " + decimal + " ... " + cno[index-1]);
				break;
			}
			System.out.printf("%4d|%8d ...%2s\n",num,decimal,cno[index-1]);
			System.out.println("    +---------");
		}while(true);
		
		for(int i = 0 ; i < index / 2 ; i++) {
			char temp = cno[i];
			cno[i] = cno[index - i - 1];
			cno[index - i - 1] = temp;
		}
		
		System.out.print(num + "진수로 ");
		for(int i = 0 ; i < index ; i++) {
			System.out.print(cno[i]);
		}
		System.out.println("입니다.");
	}
}
