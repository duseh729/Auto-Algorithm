import java.util.*;
class Solution {
    static int answer = 100;
    static HashMap<String, Boolean> visited = new HashMap<>();
    public int solution(String begin, String target, String[] words) {
        List<String> temp = new ArrayList<>(Arrays.asList(words));
        if(!temp.contains(target)){
            return 0;
        }
        
        for(String s: words){
            visited.put(s, false);
        }
        // System.out.println(visited);
        dfs(begin, target, temp, 0);
        return answer;
    }
    static void dfs(String begin, String target, List<String> words, int count){
        visited.put(begin, true);
        if(begin.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        List<String> newWords = new ArrayList<>();
        for(String s: words){
            int cnt = 0;
            for(int j=0; j<begin.length(); j++){
                if(s.charAt(j) == begin.charAt(j)) cnt+=1;
            }
            if(cnt>=begin.length()-1 && !visited.get(s)) newWords.add(s);
        }
        
        for(String s: newWords){
            dfs(s, target, words, count+1);
        }
    }
}