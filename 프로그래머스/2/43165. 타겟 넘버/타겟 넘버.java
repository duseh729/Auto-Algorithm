import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        boolean[] visited = new boolean[numbers.length];
        backtrack(numbers, target, visited, 0);
        return answer;
    }
    static void backtrack(int[] numbers, int target, boolean[] visited, int start){
        int temp=0;
        // System.out.println(Arrays.toString(visited));
        for(int i=0; i<numbers.length; i++){
            if(visited[i]){
                temp-=numbers[i];
            }else{
                temp+=numbers[i];                
            }
        }
        // System.out.println(temp);
        if(temp==target){
            answer++;
        }
        
        if(start==numbers.length){
            return;
        }
        
        for(int i=start; i<numbers.length; i++){
            visited[i]=true;
            backtrack(numbers, target, visited, i+1);
            visited[i]=false;            
        }
    }
}