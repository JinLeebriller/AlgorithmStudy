import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 듣보잡 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        List<String> nameforN = new ArrayList<>();
        List<String> nameforM = new ArrayList<>();
        List<String> none = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nameforN.add(scanner.nextLine());
        }
        for (int i = 0; i < M; i++) {
            nameforM.add(scanner.nextLine());
        }

        for (String s : nameforM) {
            if(nameforN.contains(s)){
                none.add(s);
            }
        }
        Collections.sort(none);
      //출력
        System.out.println(none.size());
        for (String s : none) {
            System.out.println(s);
        }
    }
}
