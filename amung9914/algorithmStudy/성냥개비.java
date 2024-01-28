import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Matchstick {

    // 0 1 2 3 4 5 ~ 9
    // 숫자는 0으로 시작할 수 없다
    static long[] minDp;
    
        // 2개 - 1
        // 3개 - 7
        // 4개 - 4, 11,
        // 5개 - 2, 71 5-2
        // 6개 - 6,0, 111 6-2-2-2

    public static void print(int idx){
        StringBuilder sb = new StringBuilder();

        if(idx%2==1){
            sb.append("7");
        }else{
            sb.append("1");
        }
        for (int i = 1; i < idx/2; i++) {
            sb.append("1");
        }

        System.out.println(minDp[idx]+" "+sb.toString());

    }

    public static void main(String[] args) throws IOException {
        minDp = new long[101];

        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        minDp[8] = 10;
        //minDp[9] = minDp[2]*10 + minDp[7]; // 18
        //minDp[10] = minDp[5]*10 + minDp[5]; //22
        String[] add = {"1","7","4","2","0","8"};

        for (int i = 9; i < minDp.length; i++) {
            String line = ""+minDp[i-2]+add[2-2];
            minDp[i] = Long.parseLong(line);
            for (int j = 3; j < 8; j++) {
                // minDp[]
                line = ""+minDp[i-j]+add[j-2];
                minDp[i] = Math.min(Long.parseLong(line),minDp[i]);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            list.add(temp);
        }


        for (int i = 0; i < number; i++) {
            print(list.get(i));
        }


    }
}
