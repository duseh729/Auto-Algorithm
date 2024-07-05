import java.io.*;
import java.util.Arrays;
import java.util.Stack;

class Num{
    int index;
    int value;

    Num(int index, int value){
        this.index = index;
        this.value = value;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();

        String[] nums = br.readLine().split(" ");

        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        // 4            4
        // 3 5 2 7      9 5 4 8
        // 5 7 7 -1     -1 8 8 -1
        Stack<Num> numsStack = new Stack<>();
        for(int i = 0; i < nums.length; i++){
//            for(Num k: numsStack){
//                System.out.print("i: " + i + " k: " + k.value);
//            }
//            System.out.println();
            int num = Integer.parseInt(nums[i]);
            if(numsStack.isEmpty()){
                numsStack.push(new Num(i, num));
                continue;
            }
            while (true){
//                System.out.println(i + " while문 진입");
                if(numsStack.isEmpty()){
                    numsStack.push(new Num(i, num));
                    break;
                }
                if(numsStack.peek().value<num){
                    answer[numsStack.peek().index]=num;
                    numsStack.pop();
                }else if (numsStack.peek().value>=num){
                    numsStack.push(new Num(i, num));
                    break;
                }
            }
        }

//        for(Num k: numsStack){
//            System.out.print(" k: " + k.value);
//        }
//        System.out.println();
//        System.out.println(Arrays.toString(answer));

        for (int i: answer){
            bw.write(i+" ");
        }

        bw.flush();
        bw.close();
    }
}