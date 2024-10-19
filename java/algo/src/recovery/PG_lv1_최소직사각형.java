package recovery;

import java.util.Arrays;

public class PG_lv1_최소직사각형 {

    static int[][] sizes;

    public static int solution(int[][] sizes) {
        int answer = 0;

        while (true) {
            Arrays.sort(sizes, (a, b) -> b[0] - a[0]);
            int[] wMax = sizes[0];

            Arrays.sort(sizes, (a, b) -> b[1] - a[1]);
            int[] hMax = sizes[0];

            // 현재 너비
            answer = wMax[0] * hMax[1];

            // wMax 를 돌렸을 때 너비가 줄어드나?
            if (answer > Math.max(wMax[1], hMax[0]) * Math.max(wMax[0], hMax[1])) {
                int tmp = wMax[0];
                wMax[0] = wMax[1];
                wMax[1] = tmp;
            } else break;
        }

        return answer;
    }

    static void init() {
        sizes = new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(sizes));
    }
}
