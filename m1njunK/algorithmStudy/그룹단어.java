import java.util.Scanner;

public class 그룹단어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = n;
		String arr[] = new String[n];
		for(int i=0; i<n; i++) {
			String s = sc.next();
			arr[i] = s;
		}
		for(int i=0; i<n; i++) {
			boolean check[] = new boolean[26];
			for(int j=0; j<arr[i].length(); j++) {
				int idx = arr[i].charAt(j)-'a';
				if(j > 0 && check[idx] && arr[i].charAt(j-1) != arr[i].charAt(j)) {
					answer--;
					break;
				}
				check[idx] = true;
			}
		}
		System.out.println(answer);
	}	
}