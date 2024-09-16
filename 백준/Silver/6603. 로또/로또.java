import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String[] temp = br.readLine().split(" ");
            if(temp[0].equals("0")) break;

            int n = Integer.parseInt(temp[0]);
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(temp[i+1]);
            }

            backtrack(nums, new ArrayList<>(), 0);
            System.out.println(); // 각 케이스 사이에 줄바꿈 추가
        }
    }

    static void backtrack(int[] nums, List<Integer> list, int start){
        if(list.size() == 6){
            for(int i: list){
                System.out.print(i + " ");
            }
            System.out.println(); // 한 줄 출력 후 줄바꿈
            return;
        }

        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
