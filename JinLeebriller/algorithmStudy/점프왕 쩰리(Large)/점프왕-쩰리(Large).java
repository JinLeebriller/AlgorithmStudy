package algorithmStudy;

import java.io.*;
import java.util.*;

public class Main {
    static boolean reachedDestination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            while(st.hasMoreTokens()) {
                map[i][cnt] = Integer.parseInt(st.nextToken());
                cnt++;
            }
        }

        dfs(0, 0, map, visited);

        bw.write(reachedDestination ? "HaruHaru" : "Hing");
        bw.flush();
    }

    static void dfs(int row, int column, int[][] map, boolean[][] visited) {
        if(row >= map.length || column >= map.length) return;
        if(map[row][column] == 0) return;
        if(visited[row][column]) return;

        if(map[row][column] == -1) {
            reachedDestination = true;
            return;
        }

        visited[row][column] = true;

        dfs(row + map[row][column], column, map, visited);
        dfs(row, column + map[row][column], map, visited);
    }
}
