import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Deque<String> cache = new ArrayDeque<>();
        
        if(cacheSize==0){
            return cities.length*5;
        }
        
        for(String c: cities){
            String lowerC = c.toLowerCase();
            if(cache.contains(lowerC)){
                answer+=1;
                cache.remove(lowerC);
                cache.addFirst(lowerC);
            }else{
                answer+=5;
                if(cache.size()==cacheSize){
                    cache.removeLast();
                    cache.addFirst(lowerC);
                }else{
                    cache.addFirst(lowerC);
                }
            }
        }
        
        return answer;
    }
}