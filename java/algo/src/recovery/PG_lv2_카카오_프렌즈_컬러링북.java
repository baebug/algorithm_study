package recovery;

import java.util.*;

public class PG_lv2_카카오_프렌즈_컬러링북 {

    static int m, n;
    static int[][] picture;

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] dt = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] visited = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (picture[i][j] == 0 || visited[i][j] != 0) continue;

                dq.addLast(new int[] {i, j, picture[i][j]});
                visited[i][j] = picture[i][j];
                ++numberOfArea;

                int cnt = 0;

                while (!dq.isEmpty()) {
                    int[] cur = dq.removeFirst();
                    cnt++;

                    int cx = cur[0];
                    int cy = cur[1];
                    int cv = cur[2];

                    for(int d=0; d<4; d++) {
                        int nx = cx + dt[d][0];
                        int ny = cy + dt[d][1];

                        if (nx>=0 && nx<m && ny>=0 && ny<n && picture[nx][ny]==cv && visited[nx][ny]==0) {
                            dq.addLast(new int[] {nx, ny, cv});
                            visited[nx][ny] = cv;
                        }
                    }
                }

                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void init() {
        m = 6;
        n = 4;
        picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    }

    public static void main(String[] args) {
        init();
        System.out.println(Arrays.toString(solution(m, n, picture)));
    }

}
