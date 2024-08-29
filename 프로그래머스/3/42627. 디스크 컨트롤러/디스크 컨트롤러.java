import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (e1, e2)->e1[0]-e2[0]);
        
        Queue<int[]> pq = new PriorityQueue<>((e1, e2)->e1[1]-e2[1]);
        
        int currentTime = 0;
        int total = 0;
        int jobIndex = 0;
        int completed = 0;
        while(completed<jobs.length){
            while(jobIndex<jobs.length && currentTime>=jobs[jobIndex][0]){
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }
            
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                currentTime+=job[1];
                total+=currentTime-job[0];
                completed++;
            }else{
                currentTime=jobs[jobIndex][0];
            }
        }
        return total/jobs.length;
    }
}