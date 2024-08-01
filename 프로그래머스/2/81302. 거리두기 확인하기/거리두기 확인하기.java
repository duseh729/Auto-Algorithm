import java.util.*;

class Solution {
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int temp = 0;
        L: for (String[] place : places) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        if (!bfs(i, j, place)) {
                            answer[temp] = 0;
                            temp++;
                            continue L;
                        }
                    }
                }
            }
            answer[temp] = 1;
            temp++;
        }
        return answer;
    }

    boolean bfs(int i, int j, String[] place) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new int[] { i, j, 0 });
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (distance > 0 && place[x].charAt(y) == 'P') {
                return false;
            }

            if (distance < 2) {
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny] && place[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        queue.add(new int[] { nx, ny, distance + 1 });
                    }
                }
            }
        }
        return true;
    }
}
