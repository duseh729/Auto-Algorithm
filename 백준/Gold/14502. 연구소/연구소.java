//BFS
import java.io.*;
import java.util.*;

class Main {
    static int answer = 0;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[]temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        String[][] map = new String[n][m];

        for(int i=0; i<n; i++){
            String[] temp2 = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = temp2[j];
            }
        }
        boolean[][] visited= new boolean[n][m];
        makeWall(map, 0, visited);

        bw.write(answer+" ");

        bw.close();
    }
    static void makeWall(String[][] map, int count, boolean[][] visited){
        if(count==3){
//            for (String[] m: map) System.out.println(Arrays.toString(m));
            virus(map);
            return;
        }

        for (int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                if (!visited[i][j] && map[i][j].equals("0")){
                    visited[i][j]=true;
                    map[i][j]="1";
                    makeWall(map, count+1, visited);
                    map[i][j]="0";
                    visited[i][j]=false;
                }
            }
        }
    }
    static void virus(String[][] map){
        String[][] tempMap = new String[n][m];
        for (int i=0; i< tempMap.length; i++){
            tempMap[i] = map[i].clone();
        }

        int[] dr={0, 0, -1, 1};
        int[] dc={-1, 1, 0, 0};

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(tempMap[i][j].equals("2")) queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d=0;d<4;d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && tempMap[nr][nc].equals("0")){
                    visited[nr][nc]=true;
                    queue.offer(new int[]{nr, nc});
                    tempMap[nr][nc]="2";
                }
            }
        }

        countSafeZone(tempMap);

    }
    static void countSafeZone(String[][] map){
//        for (String[] m: map){
//            System.out.println(Arrays.toString(m));
//        }
        int count=0;
        for (String[] m: map){
            for (String mm: m){
                if(mm.equals("0")) {
                    count++;
                }
            }
        }

        answer=Math.max(answer, count);
    }
}