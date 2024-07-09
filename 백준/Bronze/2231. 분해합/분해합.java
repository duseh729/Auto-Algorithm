import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int temp = 1;
//        System.out.println(returnConstructor(198));


        while (true) {
            int a = returnConstructor(temp);
            if(n>temp && !(a==n)){
                temp+=1;
            }else{
                break;
            }
        }
        if(returnConstructor(temp)==n){
            bw.write(temp + "");
        }else{
            bw.write(0 + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static int returnConstructor(int n){
        int temp=0;

        String nString = Integer.toString(n);

        for(int i=0; i<nString.length(); i++){
            temp+=Character.getNumericValue(nString.charAt(i));
//            System.out.println(temp);
        }
        if(n+temp>19900){
//            System.out.println(n + " " + temp);
        }
        return n+temp;
    }
}