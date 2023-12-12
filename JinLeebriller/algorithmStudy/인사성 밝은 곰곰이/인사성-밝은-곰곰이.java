package algorithmStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<String> inputList = new ArrayList<>();
        int count = 0;

        for(int i = 0 ; i < N ; i++) {
            String input = br.readLine();

            if(i == 0 && !input.equals("ENTER")) {
                System.out.println("첫 번째 주어지는 문자열은 무조건 ENTER이어야 합니다.");
                i--;
                continue;
            }

            if(!input.equals("ENTER") && !inputList.contains(input)) count++;
            if(i != 0 && input.equals("ENTER")) for(int j = inputList.size() - 1 ; j >= 0 ; j--) inputList.remove(j);

            inputList.add(input);
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
