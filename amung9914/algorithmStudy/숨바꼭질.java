import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] visit = new int[100001]; // 시간 입력

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        System.out.println(bfs(queue,k));
    }

    static int bfs(Queue<Integer> queue, int k){

        while(!queue.isEmpty()){
            int num = queue.poll();

            if(num==k){
                return visit[num];
            }

            if(num-1>=0 && num-1<=100000 && visit[num-1]==0){
                queue.offer(num-1);
                visit[num-1] = visit[num]+1;
            }
            if(num+1<=100000 && visit[num+1]==0){
                queue.offer(num+1);
                visit[num+1] = visit[num]+1;

            }
            if(num*2<=100000 && visit[num*2]==0){
                queue.offer(num*2);
                visit[num*2] = visit[num]+1;
            }

        }
        return -1;
    }
}
