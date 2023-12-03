import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoundQueue {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int result = 0;

        Scanner scanner = new Scanner(System.in);
        // 입력 첫 째 줄
        String[] input = scanner.nextLine().split(" ");

        for(int i = 1; i<=Integer.parseInt(input[0]); i++){
            list.add(String.valueOf(i));
        }
        // 입력 둘 째 줄
        String[] input2 = scanner.nextLine().split(" ");

        int position = 0;
        for(int i = 0; i<Integer.parseInt(input[1]); i++){

            // 뽑을 수의 위치
            int target = list.indexOf(input2[i]);

            // 뽑을 수의 위치가 현재 위치면
            if(target == position) {
                list.remove(target);
                continue;
            }

            // 최솟값을 찾기 위한 case 두 가지
            int case1 = Math.abs(target - position);
            int case2 = target > position ? Math.abs(list.size() - target + position) : Math.abs(list.size() - position + target);

            // 둘 중 작은 case
            result = case1 <= case2 ? result + case1 : result + case2;
            
            list.remove(input2[i]);
            position = target;
        }
        System.out.println("result : " + result);
    }
}
