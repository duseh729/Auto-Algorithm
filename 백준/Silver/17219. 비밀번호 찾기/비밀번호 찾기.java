import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");

            map.put(temp[0], temp[1]);
        }

        for(int i=0; i<m; i++){
            String temp = br.readLine();

            bw.write(map.get(temp)+"\n");
        }
        bw.close();
    }
}