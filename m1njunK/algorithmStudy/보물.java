package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 보물 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for(int i=0; i<2; i++) {
			for(int j=0; j<n; j++) {
				if(i == 0) {
					a.add(sc.nextInt());
				}else {
					b.add(sc.nextInt());
				}
			}
		}
		int answer = 0;
		for(int i=0; i<n; i++) {
			int min = Collections.min(a);
			int max = Collections.max(b);
			answer += min*max;
			a.remove(Integer.valueOf(min));
			b.remove(Integer.valueOf(max));
		}
		System.out.println(answer);
	}
}
