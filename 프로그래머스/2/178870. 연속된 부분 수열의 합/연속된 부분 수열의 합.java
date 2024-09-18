class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1_000_000};
        
        int start = 0;
        int sum = 0;
        
        for(int end = 0; end<sequence.length; end++){
            sum+=sequence[end];
            
            while(sum>k){
                sum-=sequence[start];
                start++;
            }
            
            if(sum==k){
                if(answer[1]-answer[0]>end-start){
                    answer[1]=end;
                    answer[0]=start;
                }
            }
        }
        return answer;
    }
}