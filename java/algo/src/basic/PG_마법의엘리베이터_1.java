package basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// bfs 방식 --> 너무 느리다! 탈락!
public class PG_마법의엘리베이터_1 {

    int[] visited;
    int ub;
    int INF = 987654321;
    Deque<int[]> dq = new ArrayDeque<>();

    public int solution(int storey) {
        int log = (int) Math.log(storey);
        ub = (int) Math.pow(10, log);
        visited = new int[ub+2];
        Arrays.fill(visited,INF);
        return solve(storey);
    }

    int solve(int storey) {
        visited[0] = 0;
        dq.addLast(new int[] {storey, 0});

        while(!dq.isEmpty()) {
            int[] cur = dq.removeFirst();

            if (cur[0] == 0) return cur[1];

            int nt = cur[1]+1;

            for(int digit=0; ; digit++) {
                int tmp = cur[0] - (int)Math.pow(10,digit);
                if (tmp >= 0) {
                    if (visited[tmp] > nt) {
                        visited[tmp] = nt;
                        dq.addLast(new int[] {tmp, nt});
                    }
                }
                else break;
            }

            for(int digit=0; ; digit++) {
                int tmp = cur[0] + (int)Math.pow(10,digit);
                if (tmp <= ub) {
                    if (visited[tmp] > nt) {
                        visited[tmp] = nt;
                        dq.addLast(new int[] {tmp, nt});
                    }
                }
                else break;
            }
        }

        return -1;
    }
}
