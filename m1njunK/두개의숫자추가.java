public class 두개의숫자추가 {
	int[] addTwoNumbers(int[] l1, int[] l2) {
		String str1 = "";
		String str2 = "";
		StringBuilder sb = new StringBuilder();

		for(int x : l1) {
			str1 += x;
		}
		
		for(int y : l2) {
			str2 += y;
		}
		
		sb.append(Integer.parseInt(str1)+Integer.parseInt(str2));
		sb = sb.reverse();
		String[] arr = sb.toString().split("");
		
		int[] result = new int[arr.length];
		
		int cnt = 0;
		for(String z : arr) {
			result[cnt] = Integer.parseInt(z);
			cnt++;
		}
		
		return result;
	}
}
