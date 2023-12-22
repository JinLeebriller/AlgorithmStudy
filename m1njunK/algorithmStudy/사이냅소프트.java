package algorithm;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class 사이냅소프트 {

	public static void main(String[] args) {
		String s = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,권종표,최승혁,이유덕,박민호,이재영,이성연,박영서,박민호,권종표,전경헌,송정환,김재성,이유덕,전경헌,권종표,이재영";
		String[] arr = s.split(",");
		int kimCnt = 0;
		int leeCnt = 0;
		Map<String,Integer> map = new TreeMap<>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			if(arr[i].startsWith("김")) kimCnt++; 
			if(arr[i].startsWith("이")) leeCnt++;
		}
		System.out.println("1.김씨와 이씨는 각각 몇 명 인가요?");
		System.out.println("김씨 : "+kimCnt+"명");
		System.out.println("이씨 : "+leeCnt+"명");
		
		System.out.println("\n2.\"이재영\"이란 이름이 몇 번 반복되나요?");
		System.out.println(map.get("이재영")+"번");
		
		System.out.println("\n3.중복을 제거한 이름을 출력하세요.");
		System.out.println(map.keySet());
		
		System.out.println("\n4.중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.");
		System.out.println(map.keySet());
	
		System.out.println("\n5.중복된 이름을 전부 출력하세요");
		
		int sum = 0;
		for(Entry<String,Integer> e : map.entrySet()) {
			int cnt = e.getValue(); 
			if(cnt > 1) {
				System.out.print(e.getKey()+"\t");
				sum++;
			}
		}
		System.out.println("\n\n6.그리고 그 갯수는 총 몇개인가요?");
		System.out.println(sum+"개");
	}

}
