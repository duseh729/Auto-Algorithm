import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, computers, n, visited);
                answer++;         
            }
        }
        
        return answer;
    }
    void dfs(int index,int[][] computers, int n, boolean[] visited){
        visited[index] = true;
        for(int i=0; i<n; i++){
            if(computers[index][i]==1 && !visited[i]){
                dfs(i, computers, n, visited);
            }
        }
    }
}