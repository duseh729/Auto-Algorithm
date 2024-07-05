import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;
        
        Queue<Integer> q1 = new ArrayDeque<Integer>();
        Queue<Integer> q2 = new ArrayDeque<Integer>();
        
        long q1Sum = 0;
        long q2Sum = 0;
        
        for (int value: queue1){
            q1.add(value);
            q1Sum+=value;
        }
        for (int value: queue2){
            q2.add(value);
            q2Sum+=value;
        }
        
        
        for(int i=0; i<n*4; i++){
            if(q1Sum>q2Sum){
                int temp = q1.poll();
                q2.add(temp);
                q1Sum-=temp;
                q2Sum+=temp;
                answer++;
            }else if(q1Sum<q2Sum){
                int temp = q2.poll();
                q1.add(temp);
                q2Sum-=temp;
                q1Sum+=temp;
                answer++;                
            }else{
                return answer;
            }
        }
        
        return -1;
    }
}