class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        backtrack(k, visited, n, dungeons, 0);
        return answer;
    }
    private void backtrack(int cur_k, boolean[] visited, int n, int[][] dungeons, int cnt){
        // basecase
        if(cnt>answer){ // if(필요 피로도>k){
            answer = cnt; // answer = max();
        } 
        
        // recursive call
        for(int i=0; i<n; i++){
            if(cur_k>= dungeons[i][0] && !visited[i]){
                visited[i] = true; // dungeons[i] 추가
                backtrack(cur_k - dungeons[i][1], visited, n, dungeons, cnt+1); // backtrack();
                visited[i] = false; // dungeons[i] 빼기
            }
        }
    }
}