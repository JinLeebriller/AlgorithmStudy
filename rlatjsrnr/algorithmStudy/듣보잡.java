import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NeverHeardNeverSeen {
    public static void main(String[] ags) {

        Scanner scan = new Scanner(System.in);
        String[] nhns = scan.nextLine().split(" ");

        int neverHeard = Integer.parseInt(nhns[0]);
        int neverSeen = Integer.parseInt(nhns[1]);

        List<String> neverHeardList = new ArrayList<>();
        List<String> result = new ArrayList<>();

        //  듣도 못한 사람 입력
        for(int i = 0; i < neverHeard; i++)
            neverHeardList.add(scan.next());

        // 보도 못한 사람 입력 하면서 중복 되면 결과에 추가
        for(int i = 0; i < neverSeen; i++) {
            String str = scan.next();
            if (neverHeardList.contains(str)) {
                result.add(str);
            }
        }

        // 정렬
        Collections.sort(result);
        System.out.println(result.size());
        for (String s : result) System.out.println(s);
    }
}
