class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // [앞 행렬 길이][뒤 행렬 길이]
        int[][] answer = new int[arr1.length][arr2[0].length];
        // 0행렬의 곱셈 : 앞 0행렬[0]*뒤0행렬[0] + 앞0행렬[1]+뒤1행렬[0]
        for(int i=0;i<arr1.length;i++){
            for(int j=0; j<arr2[0].length;j++){
                int temp = 0;
                for(int k=0; k<arr2.length;k++){
                    temp += arr1[i][k]*arr2[k][j];        
                }
                answer[i][j] = temp;
            }
        }
        return answer;
    }
}
