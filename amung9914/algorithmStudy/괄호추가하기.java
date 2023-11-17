// 모르겠어서 컨닝함

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem16637 {
    static int ans = 0;
    static List<Integer> nums = new ArrayList<>(); //숫자만 모음
    static List<Character> ops = new ArrayList<>(); //연산자만 모음

    public static void main(String[] args) throws Exception {
        //8*3+5
        String input = "8*3+5+2+2*7+3-6";
        char[] chars = input.toCharArray();
        for(char c : chars){
            if(c=='+'||c=='-'||c=='*'){
                ops.add(c);
            }else{
                nums.add(Integer.parseInt(String.valueOf(c)));
            }
        }
        dfs(nums.get(0),0);
        System.out.println(ans);
    }
    //재귀함수
    // a+b*c안 경우
    // (a+b)*c
    // a+(b*c)
    // 2가지를 비교한다.
    private static void dfs(int result, int idx){
        if(idx == ops.size()){
            ans = Math.max(ans, result);
            return;
        }
        // 결과 = 계산(연산자,1번숫자,2번숫자=1번숫자 다음순서로 리스트에 저장되있는 숫자)
        // 연산결과랑 다음 순서를 또 함수에 전달(재귀)
        int result1 = calc(ops.get(idx),result,nums.get(idx+1));
        dfs(result1, idx+1);
        // 처음 인덱스 말고 그 다음 idx 괄호로 계산
        if(idx+1<ops.size()){
            System.out.println(idx);
            int result2 = calc(ops.get(idx+1), nums.get(idx+1), nums.get(idx+2));
            dfs(calc(ops.get(idx),result,result2),idx+2);
        }
    }

    //계산
    private static int calc(char op, int n1, int n2){
        return switch (op) {
            case '+' -> n1 + n2;
            case '-' -> n1 - n2;
            case '*' -> n1 * n2;
            default -> -1;
        };
    }
}

