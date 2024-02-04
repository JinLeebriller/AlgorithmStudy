package algorithmStudy;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(bfs(N, K) + "\n");
        bw.flush();
    }

    static int bfs(int N, int K) {
        if(N == K) return 0;

        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.offer(N);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0 ; i < size ; i++) {
                int n = queue.poll();
                visited[n] = true;

                int multiplication = n * 2;
                int plusOne = n + 1;
                int minusOne = n - 1;

                if(multiplication > 100000) {
                    multiplication /= 2;
                } else if(plusOne > 100000) {
                    plusOne -= 1;
                } else if(minusOne < 0) {
                    minusOne += 1;
                }

                if (multiplication == K || plusOne == K || minusOne == K) {
                    return depth + 1;
                }

                if (!visited[minusOne] && n > K) {
                    queue.offer(minusOne);
                } else {
                    if(!visited[multiplication]) queue.offer(multiplication);
                    if(!visited[plusOne]) queue.offer(plusOne);
                    if(!visited[minusOne]) queue.offer(minusOne);
                }
            }

            depth++;
        }

        return -1;
    }
}
