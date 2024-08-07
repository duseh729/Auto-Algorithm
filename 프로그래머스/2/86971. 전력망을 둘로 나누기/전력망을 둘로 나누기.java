import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer=n;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] w: wires){
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        for(int g: graph.keySet()){
            for(int k=0; k<graph.get(g).size(); k++){
                // System.out.println(graph);
                int first = graph.get(g).remove(k);
                int second = graph.get(first).indexOf(g);
                graph.get(first).remove(Integer.valueOf(g));
                // System.out.println(graph.get(first));
                // System.out.println("first second: " + first+ " "+ second);
                // System.out.println(g+ " " +temp);
                int count = bfs(graph, g, n);
                int count2 = bfs(graph, first, n);
                // System.out.println("count count2: " +count + " " + count
                answer = Math.min(Math.abs(count-count2), answer);
                // System.out.println(g + " " + graph.get(g) + " " + temp);
                graph.get(g).add(k, first);
                graph.get(first).add(second, g);
            }
        }
        
        return answer;
    }
    int bfs(Map<Integer, List<Integer>> graph, int startVertex, int n){
        // System.out.println(graph);
        boolean[] visited = new boolean[n+1];
        int count=0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(startVertex);
        visited[startVertex]=true;
        
        while(!queue.isEmpty()){
            int curVertex = queue.poll();
            
            count++;
            
            for(int next: graph.get(curVertex)){
                if(!visited[next]){
                    visited[next]=true;
                    queue.offer(next);
                }
            }
        }
        
        return count;
    }
}