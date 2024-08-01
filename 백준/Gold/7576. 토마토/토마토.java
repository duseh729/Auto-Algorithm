import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    static int locationX;
    static int locationY;
    static int index;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int[][] board = new int[m][n];
        for(int i = 0; i < m; i++){
            String[] temp2 = br.readLine().split(" ");
            for(int j = 0; j < temp2.length; j++){
                board[i][j]=(Integer.parseInt(temp2[j]));
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
//            System.out.println(Arrays.toString(board.get(i)));
            for(int j = 0; j < n; j++){
//                System.out.println(board.get(i)[j]);
                if(board[i][j]==1){
                    queue.add(new int[]{i, j});
                }
            }
        }
//        System.out.println(queue);
        int count = 0;

         while(true){
             boolean flag = true;
            for(int[] b: board){
                for(int k: b){
                    if(k==0) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(flag){
                break;
            }

             Deque<int[]> newDeque = new ArrayDeque<>();
             while (!queue.isEmpty()){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
//                    System.out.println(nx + " " + ny + " ");
                    if(nx>=0 && nx<m && ny>=0 && ny<n && board[nx][ny]==0){
                        newDeque.add(new int[]{nx, ny});
                        board[nx][ny]=1;
                    }
                }
            }

             if (newDeque.isEmpty()) {
                 count = -1; // 익지 않은 토마토가 남아있는 경우
                 break;
             }

            count++;
             queue.addAll(newDeque);
        }

        bw.write(count + "");

        bw.close();
    }
}