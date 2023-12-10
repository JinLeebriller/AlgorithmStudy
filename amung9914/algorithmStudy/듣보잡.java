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

        List<String> nameList = new ArrayList<>();
        List<String> same = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nameList.add(scanner.nextLine());
        }
        for (int i = 0; i < M; i++) {
            String name = scanner.nextLine();
            if(nameList.contains(name)){
                same.add(name);
            }
        }

        Collections.sort(same);
        System.out.println(same.size());
        for (String s : same) {
            System.out.println(s);
        }
    }
}
