import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        int[] answer = new int[]{0};
        boolean[] visited = new boolean[dungeons.length];
        backtrack(new ArrayList<>(), visited, answer, dungeons, k);
        return answer[0];
    }
    private void backtrack(List<int[]> curr, boolean[] visited, int[] answer, int[][] dungeons, int k){
        // basecase
        if(curr.size()==dungeons.length){
            int temp = 0;
            for(int[] i: curr){
                // System.out.println(Arrays.toString(i));
                if(k>=i[0]){
                    k-=i[1];
                    temp++;
                }
            }
            if(temp>answer[0]){
                answer[0]=temp;
            }
            // System.out.println("------");
            // return answer;
        }
        
        // recursive call
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            
            curr.add(dungeons[i]);
            visited[i] = true;
            backtrack(curr, visited, answer, dungeons, k);
            
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}