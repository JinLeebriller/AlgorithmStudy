package algorithmStudy;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        Set<String> neverHeard = new HashSet<>();
        Set<String> neverSeen = new HashSet<>();
        List<String> anonymousLoser = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) neverHeard.add(sc.nextLine());
        for(int i = 0 ; i < M ; i++) neverSeen.add(sc.nextLine());

        for(String notSeen : neverSeen) if(neverHeard.contains(notSeen)) anonymousLoser.add(notSeen);

        Collections.sort(anonymousLoser);
        System.out.println(anonymousLoser.size());
        for(String anonymous : anonymousLoser) System.out.println(anonymous);
        sc.close();
    }
}