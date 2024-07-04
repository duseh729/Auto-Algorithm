import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Boolean> phoneBookMap = new HashMap<>();
        
        for(String p: phone_book){
            phoneBookMap.put(p, true);
        }
        
        for(String k: phoneBookMap.keySet()){
            for(int i=1; i<k.length(); i++){
                String target = k.substring(0,i);
                // System.out.println(target);
                if(phoneBookMap.getOrDefault(target, false)){
                    return false;
                }
            }
        }
        return answer;
    }
}