import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> bracketStack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char b = s.charAt(i);
            if(bracketStack.isEmpty()&b==')'){
                return false;
            }else if(b=='('){
                bracketStack.push(b);
            }else{
                bracketStack.pop();
            }
        }
        
        if(!bracketStack.isEmpty()) return false;
        return answer;
    }
}