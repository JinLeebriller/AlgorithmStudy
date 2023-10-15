class Solution {
    static int[] memo;
    public int solution(int n) {
        memo = new int[n+1];
        int answer = fibo(n);
        return answer;
    }
    public int fibo(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        // 메모이제이션 작업(피보나치 이전 결과를 배열에 저장)
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n]=(fibo(n-2)+fibo(n-1))%1234567;
        return memo[n];
    }
}
