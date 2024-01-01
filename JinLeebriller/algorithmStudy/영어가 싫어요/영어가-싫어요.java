package algorithmStudy;

public class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0 ; i < number.length ; i++) {
            numbers = numbers.replaceAll(number[i], String.valueOf(i));
        }

        answer = Long.parseLong(numbers);

        return answer;
    }
}