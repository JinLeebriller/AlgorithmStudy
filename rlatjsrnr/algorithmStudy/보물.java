import java.util.*;

public class Treasure {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        String[] arrA = scan.nextLine().split(" ");
        String[] arrB = scan.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
             a.add(Integer.parseInt(arrA[i]));
             b.add(Integer.parseInt(arrB[i]));
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            Integer min = Collections.min(a);
            Integer max = Collections.max(b);
            answer += (min * max);
            a.remove(min);
            b.remove(max);
        }
        System.out.println(answer);
    }
}
