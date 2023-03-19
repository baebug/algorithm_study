/**
 Programmers Lv.2
 https://school.programmers.co.kr/learn/courses/30/lessons/169199
 */

package basic;

import java.util.*;

public class PG_리코쳇_로봇 {

    int[][] input, dt = new int[][] {{0, -1}, {-1, 0}, {1, 0}, {0, 1}}; // 0상 1좌 2우 3하
    boolean[][][] visited;
    int sx, sy, ex, ey;

    public int solution(String[] board) {
        int h = board.length;
        int w = board[0].length();

        input = new int[h][w];
        visited = new boolean[h][w][4];

        for (int i=0; i<h; i++) {
            char[] row = board[i].toCharArray();

            for (int j=0; j<w; j++) {
                char tmp = row[j];
                if (tmp == 'D') {
                    input[i][j] = 1;
                } else if (tmp == 'R') {
                    sx = j; sy = i;
                } else if (tmp == 'G') {
                    ex = j; ey = i;
                }
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[] {sy, sx, 0});

        while(!dq.isEmpty()) {
            int[] cur = dq.removeFirst();
            int cy = cur[0];
            int cx = cur[1];

            if (cy == ey && cx == ex) {
                return cur[2];
            }

            for (int d=0; d<4; d++) {
                if (visited[cy][cx][d]) continue;

                int ny = cy;
                int nx = cx;

                while (true) {
                    ny += dt[d][0];
                    nx += dt[d][1];

                    if (ny<0 || ny>=h || nx<0 || nx>=w || input[ny][nx] == 1) {
                        ny -= dt[d][0];
                        nx -= dt[d][1];
                        break;
                    }
                }

                visited[cy][cx][d] = true;
                dq.addLast(new int[] {ny, nx, cur[2]+1});
            }
        }

        return -1;
    }

}
