import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Arrays.fill(answer, 0);
        
        Deque<Integer> pricesStack = new ArrayDeque<>();
        
        for(int i=0; i<prices.length; i++){
            answer[i] = prices.length-1-i;
            while(true){
                if(pricesStack.isEmpty()){
                    // 0: index, 1: day
                    pricesStack.push(i);
                    break;
                }
                int currentPriceIndex = pricesStack.peek();
                if(prices[i]<prices[currentPriceIndex]){
                    answer[currentPriceIndex] = i-currentPriceIndex;
                    pricesStack.pop();
                }else{
                    pricesStack.push(i);               
                    break;
                }
            }
        }
        // System.out.println(pricesStack);
        
        return answer;
    }
}