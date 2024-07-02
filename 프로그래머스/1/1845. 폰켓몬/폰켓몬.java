import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap poketmon = new HashMap<>();
        
        for (int temp: nums){
            poketmon.put(temp, true);
        }
        // System.out.println(poketmon.toString());
        // System.out.println(poketmon.size());
        if(poketmon.size()>nums.length / 2){
            return nums.length/2;
        }else{
            return poketmon.size();
        }
        // return answer;
    }
}