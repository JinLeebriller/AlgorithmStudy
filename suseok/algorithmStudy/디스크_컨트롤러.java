// PriorityQueue를 사용해서 문제를 풀었습니다
// 일반적인 큐는 먼저 들어간 데이터가 먼저 나가는 구조인 FIFO 형식의 자료구조입니다.  
// 반면에 우선순위 큐의 경우 들어가는 순서와는 상관없이 우선순위가 높은 데이터가 먼저 나가는 자료구조입니다.  우선순위 큐의 경우 힙 자료구조를 통해서 구현될 수 있습니다.
// 라고 하네요

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시간을 기준으로 오름차순 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 소요시간을 기준으로 오름차순 정렬되는 우선순위 큐
      
        int t = 0; 
        int idx = 0; 
        int total = 0;

        while (idx < jobs.length || !pq.isEmpty()) {
            while (idx < jobs.length && jobs[idx][0] <= t) { 
                pq.offer(jobs[idx]);
                idx++;
            }
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                total += t - job[0] + job[1];
                t += job[1];
            } else {
                t = jobs[idx][0]; 
            }
        }

        return total / jobs.length;
    }
}
