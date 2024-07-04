import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String bracket = br.readLine();

            Stack<Character> bracketStack = new Stack<>();

            boolean answer = true;
            for(int j=0; j<bracket.length(); j++){
                char currentBracket = bracket.charAt(j);
                if(bracketStack.empty() & currentBracket==')'){
                    answer=false;
                    break;
                }
                if(currentBracket=='('){
                    bracketStack.push(currentBracket);
                }else if(currentBracket==')'){
                    bracketStack.pop();
                }    
            }
            if(!bracketStack.empty()){
                answer=false;
            }

            if(answer){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }

        bw.close();
    }
}