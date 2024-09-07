//BFS
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[]temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[1]);
        int m = Integer.parseInt(temp[0]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] temp2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp2[j]);
            }
        }
//        System.out.println(Arrays.deepToString(map));

        Deque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            count=cur[2];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] == 0){
                    q.offer(new int[]{nx, ny, count+1});
                    map[nx][ny] = 1;
                }
            }
        }
        for(int[] M: map){
            for(int MM: M){
                if(MM==0){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}