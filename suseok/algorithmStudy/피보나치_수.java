피보나치 수열을 자바로 활용하여 푸는방법을 참고한곳
그냥 똑같이 했읍니다..

https://memostack.tistory.com/92

class Solution {
    public int solution(int n) {
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }

        return arr[n];
    }
}
