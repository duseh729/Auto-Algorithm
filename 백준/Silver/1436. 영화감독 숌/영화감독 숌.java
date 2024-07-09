// 1436 백준 영화감독 숌

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int temp = 0;

        int target=666;

        while (true){
            if(Integer.toString(target).indexOf("666")!=-1){
                temp+=1;
            }
            if(temp==n){
                break;
            }
            target+=1;
        }
        bw.write(Integer.toString(target));

        bw.flush();
        bw.close();
        br.close();
    }
}