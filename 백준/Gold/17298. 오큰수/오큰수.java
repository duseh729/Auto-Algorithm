import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        int[] answer = new int[temp.length];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<temp.length; i++){
            while (true) {
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int current = Integer.parseInt(temp[stack.peek()]);
                if(current<Integer.parseInt(temp[i])){
                    answer[stack.pop()] = Integer.parseInt(temp[i]);
                }else{
                    stack.push(i);
                    break;
                }
            }
        }
        for(int i: answer){
            bw.write(i+" ");
        }

        bw.close();
    }
}