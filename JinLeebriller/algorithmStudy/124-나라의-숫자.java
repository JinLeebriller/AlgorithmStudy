package algorithmStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
public String solution(int n) {
	String answer = "";
	List<String> mod = new ArrayList<>();
	
	while(n != 0) {
		if(n % 3 == 1) mod.add("1");
		if(n % 3 == 2) mod.add("2");
		if(n % 3 == 0) {
			mod.add("4");
			n -= 1;
		}
		n /= 3;
	}
	
	Collections.reverse(mod);
	
	for(String s : mod) answer += s;
	
	return answer;
}

