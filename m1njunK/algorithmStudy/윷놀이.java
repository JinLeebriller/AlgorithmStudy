import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class 윷놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> map = new LinkedHashMap<>();
		map.put("도", 0);
		map.put("개", 0);
		map.put("걸", 0);
		map.put("윷", 0);
		map.put("모", 0);
		
		for(int i=0; i<10; i++) {
			String x = sc.nextLine();
			x = x.replaceAll(" ", "").replaceAll("0", "");
			int cnt = x.length();
			switch (cnt) {
				case 1:
					map.put("도", map.get("도")+1);
					break;
				case 2:
					map.put("개", map.get("개")+1);
					break;
				case 3:
					map.put("걸", map.get("걸")+1);
					break;
				case 4:
					map.put("윷", map.get("윷")+1);
					break;
				default:
					map.put("모", map.get("모")+1);
					break;
			}
		}
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		int sum = 0;
		int cnt = 1;
		while(it.hasNext()) {
			String val = it.next().toString();
			int x = Integer.parseInt(val.substring(2));
			sum += cnt*x;
			System.out.println(val + "회");
			cnt++;
		}
		System.out.println(sum+"칸 전진!");
	}
}
