import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    static int num;
    static int num2;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        num = Integer.parseInt(temp[0]);
        num2 = Integer.parseInt(temp[1]);

        backtrack(0, new boolean[num+1], new StringBuilder(), 1);

        System.out.println(sb);
        bw.close();
    }
    static void backtrack(int now, boolean[] visited, StringBuilder cur, int index){
        if(now == num2){
            for(int i = 0; i < num2; i++){
                sb.append(cur.charAt(i)+" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = index; i <= num; i++){
            cur.append(i);
            backtrack(now+1, visited, cur, index+1);
            cur.deleteCharAt(cur.length()-1);
            index+=1;
        }
    }
}