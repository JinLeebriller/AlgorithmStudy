import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 보물 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String[] aStr = scanner.nextLine().split(" ");
        String[] bStr = scanner.nextLine().split(" ");

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (String s : aStr) {
            listA.add(Integer.parseInt(s));
        }


        for (String s : bStr) {
            listB.add(Integer.parseInt(s));
            temp.add(Integer.parseInt(s));
        }

        Collections.sort(listA); //A 재배열

        int sum = 0;
        for (int i = 0; i < N; i++) {
            Integer min = Collections.min(listA);
            Integer max = Collections.max(temp);
            sum +=min*max;
            listA.remove(min);
            temp.remove(max);

        }
        System.out.println(sum);
    }
}
