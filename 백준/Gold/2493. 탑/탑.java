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
        String[] tops = br.readLine().split(" ");
        int[] heights = new int[n];
        int[] results = new int[n];
        
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(tops[i]);
        }

        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                results[i] = 0;
            } else {
                results[i] = stack.peek() + 1;
            }
            
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            bw.write(results[i] + " ");
        }
        
        bw.flush();
        bw.close();
    }
}
