//BFS
import java.io.*;
import java.util.*;

class Main {
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[][] paper = new String[N][N];

        for(int i=0; i<N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                paper[i][j] = temp[j];
            }
        }
        backtrack(paper, N);

        bw.write(white+ "\n");
        bw.write(blue+ " ");

        bw.close();
    }
    static void backtrack(String[][] paper, int N){
        if(N==1){
            if (paper[0][0].equals("0"))white++;
            else blue++;
            return;
        }

        boolean flag = false;
        String first = paper[0][0];

//        for (String[] p: paper){
//            System.out.println(Arrays.toString(p));
//        }
//        System.out.println("---------------");
        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!first.equals(paper[i][j])){
                    flag=true;
                    break;
                }
            }
        }
        if (!flag){
            if (first.equals("0")) white++;
            else blue++;
        }else{
            for (int i=0; i<4; i++){
                String[][] next = new String[N/2][N/2];

                if (i==0){
                    for (int j=0; j<N/2; j++){
                        for (int k=0; k<N/2; k++){
                            next[j][k] = paper[j][k];
                        }
                    }
                    backtrack(next, N/2);
                }else if (i==1){
                    for (int j=0; j<N/2; j++){
                        for (int k=N/2; k<N; k++){
                            next[j][k-N/2] = paper[j][k];
                        }
                    }
                    backtrack(next, N/2);

                }else if (i==2){
                    for (int j=N/2; j<N; j++){
                        for (int k=0; k<N/2; k++){
                            next[j-N/2][k] = paper[j][k];
                        }
                    }
                    backtrack(next, N/2);

                }else{
                    for (int j=N/2; j<N; j++){
                        for (int k=N/2; k<N; k++){
                            next[j-N/2][k-N/2] = paper[j][k];
                        }
                    }
                    backtrack(next, N/2);

                }

            }
        }
    }
}