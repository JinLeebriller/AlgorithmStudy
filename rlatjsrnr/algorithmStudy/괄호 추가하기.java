import java.util.ArrayList;
import java.util.Scanner;

public class AddParentheses {

    static int answer;
    static ArrayList<String> operator;
    static ArrayList<Integer> number;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        operator = new ArrayList<>();
        number = new ArrayList<>();
        answer = Integer.MIN_VALUE;

        System.out.print("수식을 입력하세요 : ");
        String[] str = scan.next().split("");

        for (String s : str) {
            if(s.equals("+") || s.equals("-") || s.equals("*")){
                operator.add(s);
                continue;
            }
            number.add(Integer.parseInt(s));
        }

        dfs(number.get(0), 0);
        System.out.println(answer);
    }

    public static void dfs(Integer result, int opIdx) {
        // 주어진 연산자의 개수를 초과한 경우
        if(opIdx >= operator.size()){
            answer = Math.max(answer, result);
            return;
        }

        // 괄호가 없는 경우
        int result1 = calc(result, number.get(opIdx+1), operator.get(opIdx));
        dfs(result1, opIdx+1);

        // 괄호가 있는 경우
        if(opIdx + 1 < operator.size()){
            // result의 오른쪽에 있는 값을 연산
            int result2 = calc(number.get(opIdx+1), number.get(opIdx+2), operator.get(opIdx+1));
            // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김
            dfs(calc(result, result2, operator.get(opIdx)), opIdx+2);
        }
    }

    public static int calc(int a, int b, String operator){
        return switch (operator) {
            case "*" -> a * b;
            case "+" -> a + b;
            case "-" -> a - b;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
