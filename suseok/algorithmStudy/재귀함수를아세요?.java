
입력받은 n의 횟수만큼 재귀를 반복하며
정해진 숫자만큼 증가되어 목표가 되는 수치가 되면
종료가 됨

package suseok;

import java.util.Scanner;

public class WhatIsRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("반복할 횟수를 정하세요");
        int N = scanner.nextInt();
        
        recursion(N, 0);
    }

    public static void recursion(int N, int x) {
        if (x == N) {
            return;
        }

        String s = "    ".repeat(x);
        System.out.println(s + "\"재귀함수가 뭔가요?\"");
        System.out.println(s + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(s + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(s + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        
        recursion(N, x + 1);
        
        System.out.println(s + "\"재귀함수가 뭔가요?\"");
        System.out.println(s + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        System.out.println(s + "라고 답변하였지.");
    }
}

d
