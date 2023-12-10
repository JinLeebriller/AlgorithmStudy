package suseok;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// ArrayList의 retainAll(Collection)는 List에서 인자로 전달받은 Collection 객체가 갖고 있는 요소들을 제외한 나머지를 삭제합니다.
// 그리고 hashset도 사용 가능한 retainAll
// 참고한 사이트 https://codechacha.com/ko/java-collections-arraylist-retainall/

public class 듣보잡 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("듣도 못한 사람의 수: ");
        int N = scanner.nextInt();

        System.out.print("보도 못한 사람의 수: ");
        int M = scanner.nextInt();

        Set<String> dontHeard = new HashSet<>();
        Set<String> dontSee = new HashSet<>();

        for (int i = 0; i < N; i++) {
            System.out.print("듣도 못한 사람의 이름: ");
            dontHeard.add(scanner.next());
        }

        for (int i = 0; i < M; i++) {
            System.out.print("보도 못한 사람의 이름: ");
            dontSee.add(scanner.next());
        }

        Set<String> dontHeardAndSee = new TreeSet<>(dontHeard);
        dontHeardAndSee.retainAll(dontSee);

        System.out.println(dontHeardAndSee.size());
        for (String result : dontHeardAndSee) {
            System.out.println(result);
        }
    }
}


