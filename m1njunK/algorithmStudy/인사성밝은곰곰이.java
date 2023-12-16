package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 인사성밝은곰곰이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Map<String,String>> mapList = new ArrayList<>();
		Map<String,String> map = null;
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(s.equals("ENTER")) {
				if(i != 0) {
					mapList.add(map);
				}
				map = new HashMap<>();
			}else {
				map.put(s, "");
			}
			if(i == n-1) {
				mapList.add(map);
			}
		}
		int answer = 0;
		for(int i=0; i<mapList.size(); i++) {
			answer += mapList.get(i).size();
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}
