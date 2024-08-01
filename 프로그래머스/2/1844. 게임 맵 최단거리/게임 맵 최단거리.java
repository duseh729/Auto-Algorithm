import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dc = {1, 0, 0, -1};
        int[] dr = {0, 1, -1, 0};
        boolean[][] visited = new boolean[n][m];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            int dist = temp[2];
            
            if(r==n-1 && c==m-1){
                return dist;
            }
            for(int i=0; i<4; i++){
                int nc = c+dc[i];
                int nr = r+dr[i];
                if(nc>=0 && nc<m && nr>=0 && nr<n && maps[nr][nc]==1){
                    if(!visited[nr][nc]){
                        visited[nr][nc]=true;
                        queue.add(new int[]{nr, nc, dist+1});
                    }
                }
            }
        }
        
        return -1;
    }
}