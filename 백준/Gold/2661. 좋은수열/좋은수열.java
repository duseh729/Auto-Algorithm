import java.util.*;
import java.io.*;
class Main {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        backtrack("");
    }
    static void backtrack(String s){
        if(s.length() == n){
            System.out.println(s);
            System.exit(0);
        }
        for(int i = 1; i<=3; i++){
            if(goodSequence(s + i)) backtrack(s + i);
        }
    }
    static boolean goodSequence(String s){
        for(int i = 1; i<=s.length()/2; i++){
            String front = s.substring(s.length()-i*2,s.length()-i);
            String back = s.substring(s.length()-i,s.length());
            if(front.equals(back)) return false;
        }
        return true;
    }
}