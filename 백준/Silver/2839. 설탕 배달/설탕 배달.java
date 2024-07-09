// 백준 2839 설탕배달
// 1. 문제 파악
// 상근이란 새기가 설탕 배달하는데 귀찮아서 최소한의 봉지로 배달하려 한다.
// 봉지는 3키로와 5키로가 있음.
// ex) 18키로 배달해야 한다면, 3키로 6개 가져가도 되지만 5키로 3개에 3키로 1개가 효율이 좋음.
// 2. 접근 방법
// 배달해야 하는 값에 5키로씩 빼는 방법을 사용하면 될 거 같다.
// 그리고 값이 안나오면 리턴 -1

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

//        System.out.println();
        boolean trigger = true;
        while(true) {
            if(n%5==0){
                answer+=n/5;
                break;
            }else{
                n-=3;
                answer++;
            }
            if(n==0){
                break;
            }
            if(n<3){
                trigger = false;
                break;
            }
        }
        if(trigger){
            bw.write(answer+"");
        }else{
            bw.write(-1+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}