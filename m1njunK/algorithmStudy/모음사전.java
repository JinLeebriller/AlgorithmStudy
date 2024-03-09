class Solution {
    public int solution(String word) {
        int answer = word.length();
        String gather = "AEIOU";
        int arr[] = {781,156,31,6,1};
        
        for(int i = 0; i < word.length(); i++){
            answer += arr[i] * gather.indexOf(word.charAt(i));
        }
        
        return answer;
    }
}
