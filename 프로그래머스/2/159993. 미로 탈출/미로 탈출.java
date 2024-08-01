import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        boolean[][] visited2 = new boolean[n][m];
        
        int[] dr={-1, 0, 1, 0};
        int[] dc={0, 1, 0, -1};
        Deque<int[]> queue = new ArrayDeque<>();
        
        int[] start = new int[2];
        L: for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j)=='S'){
                    start[0]=i;
                    start[1]=j;
                    break L;
                }
            }
        }
        
        queue.add(new int[]{start[0], start[1], 0});
        
        int[] lIndex = new int[2];
        boolean lTrigger = false;
        int lDist=0;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            int dist = temp[2];
            
            if(maps[r].charAt(c)=='L'){
                lIndex[0]=r;
                lIndex[1]=c;
                lTrigger=true;
                lDist=dist;
                break;
            }
            
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && maps[nr].charAt(nc)!='X'){
                    if(!visited[nr][nc]){
                        visited[nr][nc]=true;
                        queue.add(new int[]{nr, nc, dist+1});
                    }
                }
            }
        }
        // System.out.println(lIndex[0] + " " + lIndex[1] + " " + lDist + " " +  lTrigger);
        queue.clear();
        queue.add(new int[]{lIndex[0], lIndex[1], lDist});
        while(lTrigger && !queue.isEmpty()){
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            int dist = temp[2];
            
            // System.out.println(r + " " + c + " " + dist);
            
            if(maps[r].charAt(c)=='E'){
                return dist;
            }
            
            for(int i=0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && maps[nr].charAt(nc)!='X'){
                    if(!visited2[nr][nc]){
                        visited2[nr][nc]=true;
                        queue.add(new int[]{nr, nc, dist+1});
                    }
                }
            }
        }
        
        return -1;
    }
}