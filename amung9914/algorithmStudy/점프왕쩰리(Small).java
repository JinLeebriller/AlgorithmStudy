import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < graph.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        if(visited[N-1][N-1]){
            System.out.println("HaruHaru");
        }else{
            System.out.println("Hing");
        }

    }

    static void dfs(int x,int y){
        visited[x][y] = true;
        //오른쪽[x=0,y=1], 아래[x=1,y=0]
        int[] dx = new int[2];
        int[] dy = new int[2];

        dx[1] = graph[x][y];
        dy[0] = graph[x][y];
        for (int i = 0; i < dx.length; i++) {
            if(x+dx[i]>= graph.length || y+dy[i]>= graph.length)
                continue;

            if(!visited[x+dx[i]][y+dy[i]])
                dfs(x+dx[i],y+dy[i]);
        }
    }

}
