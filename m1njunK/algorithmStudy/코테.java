package algorithm;

public class 코테 {
	public static void main(String[] args) {
		int arr[] = {9,8,4,5,1,9,8,4,6,1,4,4,8,7,5,4,1,6,8,9,5,7,2,1,6,5,4,2,1};
		boolean chk = false;
		String answer = "";
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 6) {chk = true;}
			if(chk) {answer += arr[i]+"";}
			if(arr[i] == 7) {chk = false; answer += "\t";}
		}
		System.out.println(answer);
	}
}
