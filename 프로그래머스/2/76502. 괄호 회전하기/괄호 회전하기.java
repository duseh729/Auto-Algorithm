import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int k = s.length();
        // System.out.println(isCurrect(s));
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=0; i<k-1; i++){
            if(isCurrect(sb.toString())){
                answer++;
            }
            // System.out.println(sb.charAt(0));
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            // System.out.println(sb);
        }
        
        return answer;
    }
    public boolean isCurrect(String bracket){
        Deque<Character> bracketStack = new ArrayDeque<>();
        
        for (int i=0; i<bracket.length(); i++){
            if(bracket.charAt(i)=='('){
                bracketStack.push(')');
            }else if(bracket.charAt(i)=='['){
                bracketStack.push(']');                
            }else if(bracket.charAt(i)=='{'){
                bracketStack.push('}');
            }else{
                if(bracketStack.isEmpty()||bracketStack.pop()!=bracket.charAt(i)){
                    return false;
                }
            }
        }
        if(bracketStack.isEmpty()){
            return true;
        }
        return false;
    }
}