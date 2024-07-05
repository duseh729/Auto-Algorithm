class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int n = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                n++;
            }else{
                n--;
            }
            if (n<0){
                return false;
            }
        }
        
        if(n!=0){
            return false;
        }else{
            return true;
        }
    }
}