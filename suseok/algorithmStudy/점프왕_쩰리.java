package suseok;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 점프왕_쩰리 {
  
    static int n;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
      
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        String result = bfs(0, 0);
        System.out.println(result);
    }

    static String bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (visited[p.x][p.y]) {
                continue;
            }

            visited[p.x][p.y] = true;

            if (map[p.x][p.y] == -1) {
                return "HaruHaru";
            }

            for (int dx = 0; dx < 2; dx++) {
                int nx = p.x + dx;
                int ny = p.y + (1 - dx);

                if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return "Hing";
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
