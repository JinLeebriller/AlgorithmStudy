import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 괄호추가 {

	static List<Integer> 숫자 = new ArrayList<>();
	static List<String> 연산자 = new ArrayList<>();
	// 답이 음수일수도 있기 때문에
	static int 답 = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner 스캐너 = new Scanner(System.in);
		int 길이 = 스캐너.nextInt();
		String 식 = 스캐너.next();
		for(int i=0; i<길이; i++) {
			if((식.charAt(i)+"").matches("[0-9]")) {
				숫자.add(식.charAt(i)-'0');
			}else 연산자.add(식.charAt(i)+"");
		}
		재귀(숫자.get(0),0);
		System.out.println(답);
	}
	public static int 계산하기(int 숫자1, int 숫자2, String 연산자) {
			switch(연산자){
				case "+" :
					return 숫자1 + 숫자2;
				case "-" :
					return 숫자1 - 숫자2;
			}
			return 숫자1 * 숫자2;
	}
	
	public static int 재귀(int 수, int 순서) {
        if (순서 >= 연산자.size()) {
        	답 = Math.max(답,수);
            return 답;
        }
        
        // 괄호없이 쭉 계산
        int 경우의수1 = 계산하기(수,숫자.get(순서+1),연산자.get(순서));
        재귀(경우의수1,순서+1);

        // 괄호 치면서 계산
        if (연산자.size()>순서+1) {
            int 경우의수2 = 계산하기(숫자.get(순서 + 1), 숫자.get(순서+2),연산자.get(순서+1));
            재귀(계산하기(수, 경우의수2, 연산자.get(순서)), 순서+2);
        }
        return 0;
	}
}
