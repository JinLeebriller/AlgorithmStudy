import java.util.*;
class Solution {
    // 동,남,서,북
    static int[] dx = {0,1,0,-1}; // 세로축
    static int[] dy = {1,0,-1,0}; // 가로축

    static int[] oil;
    
    public int solution(int[][] land) {
       oil = new int[land[0].length];

        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if(land[i][j]==1 && !visited[i][j]){
                    bfs(land,visited,i,j);
                }

            }

        }

        int answer = 0;
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
     public static void bfs(int[][] land,boolean[][] visited, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        int count = 1;
        Set<Integer> set = new HashSet<>(); //석유 덩어리 열 위치 저장

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            set.add(now[1]);

            for (int i = 0; i < 4; i++) {
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];
                if (newX < 0 || newX >= land.length || newY < 0 || newY >= land[0].length)
                    continue;
                if (land[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    count += 1;
                }
            }
        }

        for (int idx : set) {
            oil[idx] += count;

        }
     }
}
