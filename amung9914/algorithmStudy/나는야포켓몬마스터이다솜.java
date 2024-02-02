import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Dasom {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); // 문제 개수

        String[] book = new String[N+1];
        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            book[i] = br.readLine();
            hashMap.put(book[i],i);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if(input.charAt(0) >= 48 && input.charAt(0) <= 57){
                int idx = Integer.parseInt(input);
                System.out.println(book[idx]);
            } else {
                System.out.println(hashMap.get(input));
            }

        }
    }
}
