import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
       PriorityQueue<int[]> heap = new PriorityQueue<>((o1,o2)-> o1[1] - o2[1]);
        int jobCount = 0;
        int idx = 0;
        int end = 0;
        int sum = 0;
        Arrays.sort(jobs,(o1,o2) -> o1[0] - o2[0]);

        while(jobCount<jobs.length){
            while(idx < jobs.length && jobs[idx][0]<=end){
                heap.add(jobs[idx++]);
            }
            if(heap.isEmpty()){
                end = jobs[idx][0];
            }else{
                int[] temp = heap.poll();
                sum += temp[1] + end -temp[0];
                end += temp[1];
                jobCount++;
            }
        }
        
        return sum/jobs.length;

    }
}
