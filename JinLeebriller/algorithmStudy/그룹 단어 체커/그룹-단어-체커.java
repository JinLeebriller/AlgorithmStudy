package algorithmStudy;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        String[] words = new String[N];

        for(int i = 0 ; i < N ; i++) words[i] = sc.next();

        for(int i = 0 ; i < words.length ; i++) {
            boolean[] visited = new boolean[26];
            boolean isGroupWord = true;
            for(int j = 0 ; j < words[i].length(); j++) {
                char currentChar = words[i].charAt(j);
                if(visited[currentChar - 'a'] && currentChar != words[i].charAt(j - 1)) {
                    isGroupWord = false;
                    break;
                }
                visited[currentChar - 'a'] = true;
            }
            if(isGroupWord) answer++;
        }
        sc.close();
        System.out.println(answer);
    }
}
