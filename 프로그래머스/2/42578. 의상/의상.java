import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> cloth = new HashMap<>();
        
        for(String[] c: clothes){
            cloth.put(c[1], cloth.getOrDefault(c[1], 0) + 1);
        }
        for(String k: cloth.keySet()){
            answer*=(cloth.get(k)+1);
        }
        return answer-1;
    }
}