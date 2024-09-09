//BFS
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int location = Integer.parseInt(input[2]);

            int[][] map = new int[x][y];
            boolean[][] visited = new boolean[x][y];

            for(int j=0; j<location; j++){
                String[] locationInput = br.readLine().split(" ");
                int r = Integer.parseInt(locationInput[0]);
                int c = Integer.parseInt(locationInput[1]);

                map[r][c] = 1;
            }
            Deque<int[]> q = new ArrayDeque<>();
            int count = 0;

            for(int r=0; r<x; r++){
                for(int c=0; c<y; c++){
                    if(map[r][c]==1 && !visited[r][c]){
                        count++;
                        q.offer(new int[]{r, c});
                        visited[r][c]=true;
                        while(!q.isEmpty()){
                            int[] cur = q.poll();
                            for(int d=0; d<4; d++){
                                int nr = cur[0] + dr[d];
                                int nc = cur[1] + dc[d];

                                if(nr>=0 && nr<x &&nc>=0 && nc<y && !visited[nr][nc] && map[nr][nc]==1){
                                    visited[nr][nc]=true;
                                    q.offer(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                }
            }
            bw.write(count+"\n");
        }

        bw.close();
    }
}