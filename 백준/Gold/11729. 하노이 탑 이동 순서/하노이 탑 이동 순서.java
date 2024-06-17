import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static void recursion(int n, int start, int sub, int end) throws IOException {
        if (n == 1) {
            bw.write(start + " " + end + System.lineSeparator());
            return;
        } else {
            recursion(n - 1, start, end, sub);
            bw.write(start +" "+ end + System.lineSeparator());
            recursion(n - 1, sub, start, end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        // String[] temp = Array

        bw.write((int)Math.pow(2, n) - 1 + System.lineSeparator());

        recursion(n, 1, 2, 3);

        bw.flush();
        bw.close();
        br.close();
    }
}