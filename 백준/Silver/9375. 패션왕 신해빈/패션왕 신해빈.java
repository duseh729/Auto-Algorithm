// 패션왕 신해빈
// 해빈이는 패션에 민감해서 같은 옷의 조합을 입지 않는다.
// 예를 들어 오늘 안경, 코트, 상의를 입었다면, 다음 날은 바지를 입거나 안경 대신 선글라스를 착용해야 한다.
// 해빈이가 며칠동안 알몸이 아닌 옷을 입고 나갈 수 있는 지 구하는 문제.
// 첫 째 줄에 테스트 케이스의 수가 주어짐. (max 100)
// 그 다음 테스트 케이스의 첫 째 줄에 옷의 개수가 주어짐. 0 <= n <= 30
// 그리고 공백으로 구분된 옷과 옷의 종류가 주어짐.
// ex) hat headgear
//     sunglasses eyewear
// HashMap 문제임.
// 옷의 종류로 중복을 체크하면 될 거 같음.

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            // 1. N개의 옷 입력 받기
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hash = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                hash.put(type, hash.getOrDefault(type, 0) + 1);
            }

            // 2. 전체 경우의 수 계산하여 출력
            int answer = 1;
            for(int val : hash.values())
                answer *= val + 1;
            bw.write(String.valueOf(answer - 1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
//출처: https://coding-grandpa.tistory.com/128 [개발자로 취직하기:티스토리]