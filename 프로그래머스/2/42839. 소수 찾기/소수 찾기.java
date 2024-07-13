import java.util.*;

class Solution {
    Set<Integer> nums = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        backtrack(new StringBuilder(), numbers, visited);
        for(int i: nums){
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    private void backtrack(StringBuilder sb, String numbers, boolean[] visited){
        if(sb.length()>0) nums.add(Integer.parseInt(sb.toString()));
        
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            sb.append(numbers.charAt(i));
            
            backtrack(sb, numbers, visited);
            
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
        
    }
    
    private boolean isPrime(int n){
        if(n==0||n==1){
            return false;
        }
        for(int i=2; i<=(int)n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}