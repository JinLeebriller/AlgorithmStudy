import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer,String> map1 = new HashMap<>();
		HashMap<String,Integer> map2 = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String name = br.readLine();
			map1.put(i+1, name);
			map2.put(name, i+1);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < m; i++) {
			String sv = br.readLine();
			if(isNaN(sv)) {
				bw.append(map2.get(sv)+"\n");
			} else {
				bw.append(map1.get(Integer.parseInt(sv))+"\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	private static boolean isNaN(String s) {
		try {
			int n = Integer.parseInt(s);
		} catch (NumberFormatException e){
			return true;
		}
		return false;
	}
}
