import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gomgom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        // list에 없으면 count에 1추가
        // ENTER를 만나면 list 초기화
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            if(name.equals("ENTER")){
                list.clear();
            }else if(!list.contains(name)){
                list.add(name);
                count++;
            }
        } // end for
        System.out.println(count);
    }
}
