import java.util.*;
class Solution {
    static int answer = 0;
    Deque<Integer> sosu = new ArrayDeque<>();
    // isPrime(Integer.parseInt(sb.toString()))
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        backtrack(numbers, visited, new StringBuilder());
        // System.out.println(sosu);
        for(int i: sosu){
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }
    
    private void backtrack(String numbers, boolean[] visited, StringBuilder sb){
        // System.out.println(sb);
        // basecase
        if(sb.length()>0 && !sosu.contains(Integer.parseInt(sb.toString()))){
            // answer++;
            // return;
            sosu.push(Integer.parseInt(sb.toString()));
        }
        
        // recursive call
        for(int i=0; i<numbers.length(); i++){
            if(visited[i]) continue;
            sb.append(numbers.charAt(i));
            
            visited[i]=true;
            backtrack(numbers, visited, sb);
            
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;
        }
    }
    
    public boolean isPrime(int n) {
        if(n==0 || n==1){
            return false;
        }
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return false;
          }
        }
	return true;
}
}