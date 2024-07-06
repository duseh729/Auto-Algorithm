import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");

        HashMap<String, String> password = new HashMap<>();
        for(int i=0; i<Integer.parseInt(temp[0]); i++){
            String[] passwordInput = br.readLine().split(" ");

            password.put(passwordInput[0], passwordInput[1]);
        }

        for(int i=0; i<Integer.parseInt(temp[1]); i++){
            String passwordInput = br.readLine();

            bw.write(password.get(passwordInput)+"\n");
        }

        bw.close();
    }
}