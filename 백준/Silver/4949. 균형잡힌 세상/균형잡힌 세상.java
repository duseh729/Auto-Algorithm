import java.io.*;
import java.util.Arrays;
import java.util.Stack;

class Top{
    int index;
    int height;

    Top(int index, int height){
        this.index = index;
        this.height = height;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;


        while(!(line = br.readLine()).equals(".")){
            Stack<Character> bracketStack = new Stack<>();
            boolean flag = true;

            L: for(int i = 0; i < line.length(); i++){
//                System.out.println(line + ": " +Arrays.toString(bracketStack.toArray()));
                char c = line.charAt(i);
                if(bracketStack.empty()){
                    switch(c){
                        case ')':
                            flag = false;
                            break L;
                        case ']':
                            flag = false;
                            break L;
                        case '(':
                            bracketStack.push(c);
                            break;
                        case '[':
                            bracketStack.push(c);
                            break;
                    }
                }else if(!bracketStack.empty()){
                    char currentBracket = bracketStack.peek();
                    switch(c){
                        case ')':
                            if(currentBracket == '('){
                                bracketStack.pop();
                            }else{
                                flag = false;
                                break L;
                            }
                            break;
                        case ']':
                            if(currentBracket == '['){
                                bracketStack.pop();
                            }else{
                                flag = false;
                                break L;
                            }
                            break;
                        case '(':
                            bracketStack.push(c);
                            break;
                        case '[':
                            bracketStack.push(c);
                            break;
                    }
                }
            }
            if(bracketStack.empty() & flag){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
    }
}