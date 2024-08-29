import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] costs = new int[n+1][n+1];
        for(int[] fare: fares){
            costs[fare[0]][fare[1]] = fare[2];
            costs[fare[1]][fare[0]] = fare[2];
        }
        
        int[][] distArray = new int[3][n+1];
        for(int[] d: distArray){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((e1, e2)->e1[0]-e2[0]);
        int[] start = {s, a, b};
        for(int i=0; i<3; i++){
            int[] d = distArray[i];
            d[start[i]] = 0;
            pq.offer(new int[]{start[i], 0});
            
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int node = cur[0];
                int dist = cur[1];
                
                for(int j=1; j<=n; j++){
                    if(costs[node][j]==0) continue;
                    if(d[j]>costs[node][j]+dist){
                        d[j]=costs[node][j]+dist;
                        pq.offer(new int[]{j, costs[node][j]+dist});
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int sum=0;
            for(int[] d: distArray){
                sum+=d[i];
            }
            answer=Math.min(sum, answer);
        }
        return answer;
    }
}