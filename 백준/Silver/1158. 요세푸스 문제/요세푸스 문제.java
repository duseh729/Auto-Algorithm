import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            deque.add(i+1);
        }

        int cnt = 0;
        bw.write('<');
        while(!deque.isEmpty()){
            cnt++;
            if(cnt==m){
                cnt=0;
                int k = deque.poll();
                if(deque.isEmpty()){
                    bw.write(k+ ">");
                }else{
                    bw.write(k+ ", ");
                }
            }else{
                deque.add(deque.poll());
            }
        }

        bw.close();
    }
}