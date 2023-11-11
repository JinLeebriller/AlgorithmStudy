//행렬 곱셈 어떻게 하는지 기억이 안나서 검색 해봤습니다
//요는 
//행렬이 들어 올 떄, A의 행과 B의 열을 순서대로 반복하면서 곱셈을 해주면 된다.
//여기서는 arr1에서의 배열 두개가 A이고 B는 arr2를 뜻한다
//그리고 n×m 크기의 A행렬과 m×k 크기의 B행렬의 곱은 n×k 크기의 행렬로 반환이 된다는 것을 알아두시길 바란다.
//여기서의 n과m 행렬의 갯수입니다
  
//https://st-lab.tistory.com/245

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row1 = arr1.length;
        int col1 = arr1[0].length;
        int col2 = arr2[0].length;

        int[][] answer = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
