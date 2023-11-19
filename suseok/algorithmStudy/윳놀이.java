package suseok;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class YutGame {

    public static int[] rollYut() {
        return new Random().ints(4, 0, 2).toArray();
    }

    public static String YutState(int[] yut) {
        int move = (int) Arrays.stream(yut).filter(i -> i == 1).count();

        switch (move) {
            case 0:
                return "모";
            case 1:
                return "도";
            case 2:
                return "개";
            case 3:
                return "걸";
            default:
                return "윷";
        }
    }

    public static void main(String[] args) {
        int[][] result = new int[10][5];
        Map<String, Integer> stateCounts = new HashMap<>();
        Map<String, Integer> forwardCounts = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            int[] yut = rollYut();
            String yutState = YutState(yut);

            stateCounts.put(yutState, stateCounts.getOrDefault(yutState, 0) + 1);

            int moCnt = Arrays.stream(yut).sum();
            if (yutState.equals("모") && moCnt < 4) {
            	moCnt = 4;
            }

            forwardCounts.put(yutState, forwardCounts.getOrDefault(yutState, 0) + moCnt);
            cnt += moCnt;

            result[i] = yut;
        }

        System.out.println("10회 굴려서 나온 결과:");
        stateCounts.forEach((key, value) ->
                System.out.println(key + " " + value + "회 전진: " + forwardCounts.getOrDefault(key, 0) + "칸"));
        System.out.println("총 전진 횟수: " + cnt + "칸");
    }
}
