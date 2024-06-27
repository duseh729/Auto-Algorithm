import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participantMap = new HashMap<String, Integer>();
        HashMap<String, Integer> completionMap = new HashMap<String, Integer>();
        
        for(String temp: participant){
            if(participantMap.containsKey(temp)){
                int tempInt = participantMap.get(temp);
                participantMap.put(temp, tempInt+1);
            }else{
                participantMap.put(temp, 1);
            }
        }        
        for(String temp: completion){
            if(completionMap.containsKey(temp)){
                int tempInt = completionMap.get(temp);
                completionMap.put(temp, tempInt+1);
            }else{
                completionMap.put(temp, 1);
            }
        }
        // System.out.println(participantMap);
        
        for(String temp: completion){
            // System.out.println(temp);
            if(participantMap.containsKey(temp)){
                int tempInt = participantMap.get(temp);
                if (tempInt>1){
                    participantMap.put(temp, tempInt-1);
                }else{                    
                    participantMap.remove(temp);
                }
            }
        }
        for(String temp: participantMap.keySet()){
            return temp;
        }
        return answer;
    }
}

