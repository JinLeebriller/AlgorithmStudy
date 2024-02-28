package algorithmStudy;

import java.util.*;

public class Solution {
    static class Job implements Comparable<Job> {
        int arrivalTime;
        int processingTime;

        public Job(int arrivalTime, int processingTime) {
            this.arrivalTime = arrivalTime;
            this.processingTime = processingTime;
        }

        @Override
        public int compareTo(Job other) {
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
    }

    public static int solution(int[][] jobs) {
        int answer, idx, cnt, end;
        answer = idx = cnt = end = 0;

        Job[] job = new Job[jobs.length];
        PriorityQueue<Job> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.processingTime));

        for(int i = 0 ; i < jobs.length ; i++) {
            job[i] = new Job(jobs[i][0], jobs[i][1]);
        }

        Arrays.sort(job);

        while(cnt < jobs.length) {
            while(idx < jobs.length && job[idx].arrivalTime <= end) {
                queue.offer(job[idx]);
                idx++;
            }

            if(queue.isEmpty()) {
                end = job[idx].arrivalTime;
            } else {
                answer += end - queue.peek().arrivalTime + queue.peek().processingTime;
                end += queue.poll().processingTime;
                cnt++;
            }
        }

        return answer / jobs.length;
    }
}