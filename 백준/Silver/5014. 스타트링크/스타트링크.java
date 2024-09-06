//BFS
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[]temp = br.readLine().split(" ");

        int total = Integer.parseInt(temp[0]);
        int now = Integer.parseInt(temp[1]);
        int goal = Integer.parseInt(temp[2]);
        int up = Integer.parseInt(temp[3]);
        int down = Integer.parseInt(temp[4]);
        if(now == goal) {
            System.out.println(0);
            System.exit(0);
        }
//        boolean trigger = false;

        boolean[] visited = new boolean[total+1];
        int count = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{now, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
//            System.out.println(Arrays.toString(cur));
            int cNow = cur[0];
            int cCount = cur[1];
            if(cNow == goal){
                count=cCount;
                break;
            }
            int cNowUp = cNow + up;
            int cNowDown = cNow - down;
            if(cNowUp<=total && !visited[cNowUp]){
                visited[cNowUp] = true;
                q.offer(new int[]{cNowUp, cCount+1});
            }
            if(cNowDown>0 && !visited[cNowDown]){
                visited[cNowDown] = true;
                q.offer(new int[]{cNowDown, cCount+1});
            }
        }
        if(count!=0){
            bw.write(count+"");
        }else{
            bw.write("use the stairs");
        }

        bw.close();
    }
}