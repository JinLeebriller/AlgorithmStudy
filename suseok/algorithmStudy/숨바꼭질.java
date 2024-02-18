// 문제가 어려워서
// 찾아보면서 하니까

// BFS와 DFS가 있었습니다
// https://devuna.tistory.com/32
// 깊이 우선 탐색(DFS)과 너비 우선 탐색(BFS)를 뜻하며 

// 1. 깊이 우선 탐색 (DFS, Depth-First Search)
// : 최대한 깊이 내려간 뒤, 더이상 깊이 갈 곳이 없을 경우 옆으로 이동

// 2. 너비 우선 탐색 (BFS, Breadth-First Search)
// : 최대한 넓게 이동한 다음, 더 이상 갈 수 없을 때 아래로 이동

// 해당 문제는 BFS에 해당하는 문제이다

import java.util.*;

public class 숨바꼭질 {

    static class Node {
        int position;
        int time;

        Node(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 수빈이 위치
        int k = scanner.nextInt(); // 동생 위치

        // 방문 여부를 저장하는 배열
        boolean[] visited = new boolean[100001];

        // 큐를 생성
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0)); // 초기 위치를 큐에 삽입

        // 큐가 비어질 때까지 반복
        while (!queue.isEmpty()) {
          
            Node node = queue.poll(); // 큐에서 가장 앞에 있는 노드를 꺼냄
          
            int position = node.position;
          
            int time = node.time;

            // 현재 위치가 동생 위치와 같으면 시간 출력 후 종료
            if (position == k) {
                System.out.println(time);
                return;
            }

            // 다음 이동할 위치를 계산
            for (int nextPosition : new int[]{position - 1, position + 1, 2 * position}) {
                // 범위를 벗어나거나 이미 방문한 위치는 건너뜀
                if (nextPosition < 0 || nextPosition > 100000 || visited[nextPosition]) {
                    continue;
                }

                // 다음 이동할 위치를 큐에 삽입
                queue.offer(new Node(nextPosition, time + 1));

                // 다음 이동할 위치를 방문했음으로 표시
                visited[nextPosition] = true;
            }
        }

        // 동생을 찾을 수 없는 경우 -1 출력
        System.out.println(-1);
    }
}
