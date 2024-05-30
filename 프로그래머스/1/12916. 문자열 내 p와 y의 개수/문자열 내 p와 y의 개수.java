class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int[] counts = {0 ,0};
        
        s.chars()
            .mapToObj(i -> (char)i)
            .forEach(i -> {
                if(i=='p' || i=='P'){
                    counts[0]++;
                }else if(i=='y' || i == 'Y'){
                    counts[1]++;
                }
            });
        
        if(counts[0]==counts[1]){
        return answer;
        }else{
        return false;

        }

    }
}