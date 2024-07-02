import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();

            String temp = br.readLine();

            for (int j = 0; j < temp.length(); j++) {
                // System.out.println(temp.charAt(j));
                char character = temp.charAt(j);
                if (character == '<') {
                    if (!leftStack.empty()) {
                        rightStack.push(leftStack.pop());
                    } else {
                        continue;
                    }
                } else if (character == '>') {
                    if (!rightStack.empty()) {
                        leftStack.push(rightStack.pop());
                    } else {
                        continue;
                    }
                } else if (character == '-') {
                    if (!leftStack.empty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(character);
                }
            }

            // System.out.println(rightStack.toString());
            // System.out.println(rightStack.size());
            int rightStackSize = rightStack.size();
            for (int k=0; k<rightStackSize; k++) {
                leftStack.push(rightStack.pop());
            }
            
            for(char k : leftStack){
                bw.write(k+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
