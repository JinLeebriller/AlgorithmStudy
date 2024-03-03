import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }
        bfs(board,visited);
    }
    
    static void bfs(int[][] board, boolean[][] visited) {
        int len = board.length;
        boolean result = false;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[2]);
        
        while(!q.isEmpty()) {
           int[] current = q.poll();
           int r = current[0];
           int c = current[1];
           
            if(board[r][c] == -1) {
                result = true;
                break;
            }
            
            int bot = r + board[r][c];
            int right = c + board[r][c];
            
            if(bot < len && !visited[bot][c]) {
                q.add(new int[] {r + board[r][c], c});
                visited[bot][c] = true;
            }
            if(right < len && !visited[r][right]) {
                q.add(new int[] {r, c + board[r][c]});
                visited[r][right] = true;
            }
        }
        if(result) {
            System.out.println("HaruHaru");
            return;
        } 
        System.out.println("Hing");
    }
}
