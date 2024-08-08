import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i<places.length; i++){
            if(check(places[i])) answer[i] = 1;
        }
        return answer;
    }
    
    boolean check(String[] place){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(place[i].charAt(j)=='P'){
                    if(!bfs(place, new boolean[5][5], i, j)) return false;
                } 
            }
        }
        return true;
    }
    
    boolean bfs(String[] place, boolean[][] visited, int i, int j){
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j, 0});
        visited[i][j] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[2]>=2) continue;
            
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr>=0 && nr<5 && nc>=0 && nc<5 && place[nr].charAt(nc)!='X'){
                    if(!visited[nr][nc]){
                        if(place[nr].charAt(nc)=='P') return false;
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, cur[2]+1});
                    }
                }
            }
        }
        return true;
    }
}