//HashMap을 사용해서 
//번호와 포켓몬 이름을 이어서 사용하는 방법을 사용
//그래서 입력받은 숫자와 문자열을 각각 사용할수 있게 만듬
//마지막 isNum 메서드는 입력받은게 숫자인지 문자열인지 구분할수 있게 만드는 메서드임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 포켓몬 마스터 {
  
    public static void main(String[] args) throws IOException {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        String[] inputs = br.readLine().split(" ");
      
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        HashMap<Integer, String> map_int = new HashMap<>();
        HashMap<String, Integer> map_str = new HashMap<>();
      
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map_int.put(i, name);
            map_str.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
      
        for (int i = 1; i <= m; i++) {
            String tmp = br.readLine();
            if(isNum(tmp)){
                sb.append(map_int.get(Integer.parseInt(tmp))+"\n");
            }else{
                sb.append(map_str.get(tmp)+"\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isNum(String str) {
      
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
