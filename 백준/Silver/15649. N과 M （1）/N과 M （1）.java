import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        int num = Integer.parseInt(temp[0]);
        int num2 = Integer.parseInt(temp[1]);

        backtrack(num, num2, 1, new boolean[num+1], new StringBuilder());

        System.out.println(sb);
        bw.close();
    }
    static void backtrack(int num, int num2, int now, boolean[] visited, StringBuilder cur){
        if(cur.length() == num2){
            for(int i = 0; i < num2; i++){
                sb.append(cur.charAt(i)+" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= num; i++){
            if(!visited[i]){
                visited[i] = true;
                cur.append(i);
                backtrack(num, num2, now, visited, cur);
                cur.deleteCharAt(cur.length()-1);
                visited[i] = false;
            }
        }
    }
}