package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 듣보잡 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nm[] = sc.nextLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		Map<String,Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			map.put(sc.next(),1);
		}
		
		List<String> answer = new ArrayList<>();
		for(int j=0; j<m; j++) {
			String chk = sc.next();
			if(map.containsKey(chk)) {
				answer.add(chk);
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(String s : answer) {
			System.out.println(s);
		}
	}

}
