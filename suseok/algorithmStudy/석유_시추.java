// 이거도 DFS네;;
// 저는 효율성 테스트에서 안되네요

public class Solution {

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        // 각 열마다 석유 덩어리 크기 저장
        int[] oilCnt = new int[m];

        for (int i = 0; i < m; i++) {
            // 방문 여부 체크 배열
            boolean[][] visited = new boolean[n][m];

            for (int j = 0; j < n; j++) {
                // 석유 덩어리 탐색
                if (!visited[j][i] && land[j][i] == 1) {
                    oilCnt[i] += dfs(land, visited, j, i);
                }
            }
        }

        // 최대 석유량 계산
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, oilCnt[i]);
        }

        return answer;
    }

    // DFS 탐색
    private int dfs(int[][] land, boolean[][] visited, int y, int x) {
        int cnt = 1;
        visited[y][x] = true;

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (0 <= nextY && nextY < land.length && 0 <= nextX && nextX < land[0].length && !visited[nextY][nextX] && land[nextY][nextX] == 1) {
                cnt += dfs(land, visited, nextY, nextX);
            }
        }

        return cnt;
    }
}
