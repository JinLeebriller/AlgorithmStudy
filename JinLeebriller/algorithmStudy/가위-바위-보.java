package algorithmStudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int people = 0;
		String result = "";
		List<Character> friend = new ArrayList<>(); 
		friend.add('A'); friend.add('B'); friend.add('C'); friend.add('D'); friend.add('E');
		Map<Character, Character> list = new HashMap<>(); 
		
		do {
			System.out.print("참여 인원을 선택하세요(2~5명) : ");
			people = sc.nextInt();
		}while(people <= 1 || people > 5);
		
		for(int i = 0 ; i < people ; i++) list.put(friend.get(i), '0');
		
		out:while(true) {
			if(list.size() == 1) {
				System.out.println("총 시행횟수 : " + count);
				list.keySet().forEach(key -> {
				    System.out.println("최종 승자 : " + key);
				});
				break out;
			}
			
			label: while(true) {
				System.out.print("가위(1) 바위(2) 보(3) : ");
				result = sc.next();
				for(int i = 0 ; i < result.length() ; i++) {
					if(result.charAt(i) != '1' && result.charAt(i) != '2' && result.charAt(i) != '3'){
						System.out.println("숫자 1, 2, 3만 입력하세요.");
						continue label;
					}
				}
				if(result.length() != list.size()) {
					System.out.println("인원수에 맞게 입력하세요. (인원수 " + list.size() + "명)");
					continue;
				}
				for(int i = 0 ; i < list.size() ; i++) 
					list.put(friend.get(i), result.charAt(i));
				break;
			}
			
			// 무승부의 경우(0) : 모두 다른 것을 내거나, 같은 것을 냈을 경우 
			if(result.indexOf("1") != -1 && result.indexOf("2") != -1 && result.indexOf("3") != -1) {
				System.out.println(0);
			}else if(result.indexOf("1") == -1 && result.indexOf("2") == -1) {
				System.out.println(0);
			}else if(result.indexOf("1") == -1 && result.indexOf("3") == -1) {
				System.out.println(0);
			}else if(result.indexOf("2") == -1 && result.indexOf("3") == -1) {
				System.out.println(0);
			// 가위가 이긴 경우(1) : 바위가 나오지 않고, 보가 나왔을 경우
			}else if(result.indexOf("1") != -1 && result.indexOf("2") == -1 && result.indexOf("3") != -1) {
				remove(friend, list, '3');
				System.out.println("가위(1) 승");
			// 바위가 이긴 경우(2) : 보가 나오지 않고, 가위가 나왔을 경우
			}else if(result.indexOf("1") != -1 && result.indexOf("2") != -1 && result.indexOf("3") == -1) {
		        remove(friend, list, '1');
				System.out.println("바위(2) 승");
			// 보가 이긴 경우(3) : 가위가 나오지 않고, 바위가 나왔을 경우
			}else if(result.indexOf("1") == -1 && result.indexOf("2") != -1 && result.indexOf("3") != -1) {
				remove(friend, list, '2');
				System.out.println("보(3) 승");
			}
			
			if(list.size() != 1) {
				System.out.print("생존 인원 : ");
				list.keySet().forEach(key -> {
				    System.out.print(key + " ");
				});
				System.out.println();
			}
			
			count++;
		}
	}
	public static void remove(List<Character> list, Map<Character, Character> map, char num) {
		Iterator<Map.Entry<Character, Character>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
            Map.Entry<Character, Character> entry = iterator.next();
            if (entry.getValue() == num) {
            	list.remove(entry.getKey());
                iterator.remove(); 
            }
        }
	}
}
