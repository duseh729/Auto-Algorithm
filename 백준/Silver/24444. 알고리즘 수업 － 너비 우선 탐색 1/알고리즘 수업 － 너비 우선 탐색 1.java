//BFS
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[]temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int start = Integer.parseInt(temp[2]);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i=0; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            String[] vertex = br.readLine().split(" ");
            graph.get(Integer.parseInt(vertex[0])).add(Integer.parseInt(vertex[1]));
            graph.get(Integer.parseInt(vertex[1])).add(Integer.parseInt(vertex[0]));
        }

        for(int i=0; i<n; i++){
            if(graph.containsKey(i)){
                graph.get(i).sort(Comparator.naturalOrder());
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int[] visited = new int[n+1];
        int count=1;
        visited[start] = count;
        while (!q.isEmpty()){
            int cur = q.poll();

            for(int g: graph.get(cur)){
                if(visited[g]==0){
                    count++;
                    visited[g]=count;
                    q.offer(g);
                }
            }
        }

        for (int i=1; i<=n; i++){
            bw.write(visited[i]+"\n");
        }

        bw.close();
    }
}