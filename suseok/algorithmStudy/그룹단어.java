//입력받는 자연수 n의 조건이랑
//소문자만 입력받게 만듬

package suseok;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GroupWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 단어의 개수 입력
        int n;
        do {
            System.out.println("입력할 단어의 개수를 입력해주세요 (1 이상 100 이하):");
            n = scanner.nextInt();
        } while (n < 1 || n > 100);

        System.out.println("단어를 입력해주세요 (소문자로만 입력):");
        scanner.nextLine();

        // 단어를 배열에 저장
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("단어 " + (i + 1) + ":");
            words[i] = LowerWord(scanner);
        }

        //결과 그룹단어의 갯수 출력
        int result = countGroupWords(words);
        System.out.println("그룹 단어의 개수: " + result);
    }

    public static String LowerWord(Scanner scanner) {
        String word;
        do {
            word = scanner.nextLine();
            if (!word.matches("[a-z]+")) {
                System.out.println("소문자로만 이루어진 단어를 입력해주세요.");
            }
        } while (!word.matches("[a-z]+"));

        return word;
    }

    public static boolean isGroupWord(String word) {
        Set<Character> visited = new HashSet<>();
        char prevChar = '\0'; // 이전에 등장한 문자

        for (char ch : word.toCharArray()) {
            if (visited.contains(ch)) {
                if (ch != prevChar) {
                    return false;
                }
            } else {
                visited.add(ch);
                prevChar = ch;
            }
        }

        return true;
    }

    public static int countGroupWords(String[] words) {
        int count = 0;

        for (String word : words) {
            if (isGroupWord(word)) {
                count++;
            }
        }

        return count;
    }
}
