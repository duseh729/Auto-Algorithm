//BFS
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");

        int now = Integer.parseInt(temp[0]);
        int to = Integer.parseInt(temp[1]);

        Deque<int[]> q = new ArrayDeque<>();
        int count = 0;
        q.offer(new int[]{now, 0});

        boolean[] visited = new boolean[Math.max(now, to)*2+1];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cNow = cur[0];
            int cCount = cur[1];

            if (cNow == to) {
                count=cCount;
                break;
            }

            if(cNow*2<=to*2 && !visited[cNow * 2]) {
                q.offer(new int[]{cNow * 2, cCount + 1});
                visited[cNow * 2] = true;
            }
            if(cNow+1<=to && !visited[cNow + 1]) {
                q.offer(new int[]{cNow + 1, cCount + 1});
                visited[cNow + 1] = true;
            }
            if(cNow-1>=0 && !visited[cNow - 1]) {
                q.offer(new int[]{cNow - 1, cCount + 1});
                visited[cNow - 1] = true;
            }

        }

        bw.write(count + "\n");
        bw.close();
    }
}