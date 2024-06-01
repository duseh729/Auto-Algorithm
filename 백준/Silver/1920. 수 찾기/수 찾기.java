import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<String, Boolean> numList = new HashMap<>();

        String[] tempList = br.readLine().split(" ");
        // System.out.println(br.readLine().split(" "));
        for (String element: tempList) {
            // System.out.println(element);
            numList.put(element, true);
        }
        int m = Integer.parseInt(br.readLine());
        String[] tempList2 = br.readLine().split(" ");
        for (String element: tempList2) {
            // System.out.println(numList.get(element));    
            Boolean temp = numList.get(element);
            if(temp != null){
                bw.write(1+ System.lineSeparator());
            }else{
                bw.write(0+ System.lineSeparator());
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}