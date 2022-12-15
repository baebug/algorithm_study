package basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PG_게임맵최단거리 {

    int n, m;
    int[][] visited, dt = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(int[][] maps) {
        // 상대팀 진영에 도착하는 가장 짧은 경우, 못가면 -1
        // 0은 벽, 1은 갈 수 있는 자리
        // 나는 (1, 1) 에서 시작, 상대방은 (n, m)
        n = maps.length;
        m = maps[0].length;

        visited = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], 99999);
        }

        bfs(maps);

        return visited[n-1][m-1] == 99999 ? -1 : visited[n-1][m-1];
    }

    void bfs(int[][] maps) {
        Deque<int[]> dq = new ArrayDeque<>();
        visited[0][0] = 1;
        dq.addLast(new int[] {0, 0});

        while(!dq.isEmpty()) {
            int[] cur = dq.removeFirst();

            int cy = cur[0];
            int cx = cur[1];

            for(int d=0; d<4; d++) {
                int ny = cy + dt[d][0];
                int nx = cx + dt[d][1];

                if (ny<0 || nx<0 || ny>=n || nx>=m) continue;
                if (maps[ny][nx] == 0) continue;

                int nt = visited[cy][cx] + 1;
                if (visited[ny][nx] <= nt) continue;
                visited[ny][nx] = nt;
                dq.addLast(new int[] {ny, nx});
            }
        }
    }
}
