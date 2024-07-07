import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");

        Deque<Integer> answer = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();

        for(int i = 0; i < Integer.parseInt(temp[0]); i++){
            nums.add(i+1);
        }

        int trigger=0;
        while(nums.size()>0){
//            System.out.println(nums);
            trigger++;
            if(trigger==Integer.parseInt(temp[1])){
                trigger=0;
                answer.add(nums.poll());
                continue;
            }
            nums.add(nums.poll());
        }
//        System.out.println(answer);

        int k = answer.size();
        bw.write("<");
        for(int i=0;i<k;i++){
            if(i==k-1){
                bw.write(answer.poll()+"");
                break;
            }
            bw.write(answer.poll()+", ");
        }
        bw.write(">");

        bw.close();
    }
}