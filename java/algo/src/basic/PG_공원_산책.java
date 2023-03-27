/**
 https://school.programmers.co.kr/learn/courses/30/lessons/172928
 
 */

package basic;

public class PG_공원_산책 {

    int[][] input, dt = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // N W E S
    int sy, sx, w, h;

    public int[] solution(String[] park, String[] routes) {
        h = park.length;
        w = park[0].length();
        input = new int[h][w];

        for (int i=0; i<h; i++) {
            char[] row = park[i].toCharArray();
            for (int j=0; j<w; j++) {
                char tmp = row[j];
                if (tmp == 'S') {
                    sy = i; sx = j;
                } else if (tmp == 'X') {
                    input[i][j] = 1;
                }
            }
        }

        for (String c : routes) {
            char[] command = c.toCharArray();
            char d = command[0];
            int n = command[2] - '0';

            move(d, n);
        }

        return new int[] {sy, sx};
    }

    public void move(char op, int n) {
        int dir = -1;
        switch (op) {
            case 'N':
                dir = 0;
                break;
            case 'W':
                dir = 1;
                break;
            case 'E':
                dir = 2;
                break;
            case 'S':
                dir = 3;
                break;
        }

        int ny = sy;
        int nx = sx;

        for (int i=0; i<n; i++) {
            ny += dt[dir][0];
            nx += dt[dir][1];

            if (ny<0 || ny>=h || nx<0 || nx>=w || input[ny][nx] == 1) return;
        }

        sy = ny;
        sx = nx;
    }

}
