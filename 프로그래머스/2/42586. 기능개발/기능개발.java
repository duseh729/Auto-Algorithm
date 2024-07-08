import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Deque<Integer> progressesQueue = new ArrayDeque<>();
        Deque<Integer> speedsQueue = new ArrayDeque<>();
        for(int p: progresses){
            progressesQueue.add(p);
        }
        for(int s: speeds){
            speedsQueue.add(s);
        }
        // System.out.println(progressesQueue);
        
        while(!progressesQueue.isEmpty()){
                int answerTemp=0;
                int day=0;
                int firstProgress = (int)progressesQueue.toArray()[0];
                int firstSpeed = (int)speedsQueue.toArray()[0];
                
                while(firstProgress<100){
                    firstProgress+=firstSpeed;
                    day++;
                }
                progressesQueue.poll();
                speedsQueue.poll();
                answerTemp++;
                
                while(!progressesQueue.isEmpty()){
                    int anotherProgress = (int)progressesQueue.toArray()[0];
                    int anotherSpeed = (int)speedsQueue.toArray()[0];
                    if(anotherProgress+anotherSpeed*day>=100){
                        progressesQueue.poll();
                        speedsQueue.poll();
                        answerTemp++;
                    }else{
                        break;
                    }
                }
                answer.add(answerTemp);
            
        }
        // System.out.println(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
}