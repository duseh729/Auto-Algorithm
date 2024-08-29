import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] costs = new int[n+1][n+1];
        for(int[] fare: fares){
            costs[fare[0]][fare[1]]=fare[2];
            costs[fare[1]][fare[0]]=fare[2];
        }
        int[][] distArray = new int[3][n+1];
        for(int[] d: distArray){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((e1, e2)->e1[1]-e2[1]);
        int[] start = {s, a, b};
        
        for(int i=0; i<3; i++){
            pq.offer(new int[]{start[i], 0});
            int[] d = distArray[i];
            d[start[i]] = 0;
            
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int node = cur[0];
                int dist = cur[1];
                
                for(int j=1; j<=n; j++){
                    if(costs[node][j]==0) continue;
                    if(d[j]>dist+costs[node][j]){
                        d[j] = dist+costs[node][j];
                        pq.offer(new int[]{j, dist+costs[node][j]});
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int[] d: distArray){
                sum+=d[i];
            }
            answer=Math.min(answer, sum);
        }
        return answer;
    }
}