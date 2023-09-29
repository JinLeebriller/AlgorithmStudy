package suseok;

public class remove {
	public int solution(String s) {
		
		StringBuilder stack = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == ch) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(ch);
            }
        }
        
        if (stack.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

이건 스택 공부한걸 적자면

스택은 주로 데이터를 순서대로 쌓고 빼내는데 사용되며.

Stack<Character> stack = new Stack<>();
스택 선언시에 

import java.util.Stack; //import
Stack<Integer> stack = new Stack<>(); //int형 스택 선언
Stack<String> stack = new Stack<>(); //char형 스택 선언

스택 선언을 해도 되지만 string형으로 stack 쌓을때
StringBuilder로 선언해서 하면됨

Stack에 값을 추가하고 싶다면 push(value)라는 메서드를 활용하면 됨

stack에서 값을 제거하고싶다면 pop()이라는 메서드를 사용하면 됨
stack.clear();     stack의 전체 값 제거 (초기화)

// 실제 프로그래머스에 제출한 답

class Solution {
    public int solution(String s) {
        StringBuilder stack = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == ch) {
                stack.deleteCharAt(stack.length() - 1); 
            } else {
                stack.append(ch);
            }
        }
        
        if (stack.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}


