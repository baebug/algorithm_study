package recovery;

import java.util.Arrays;

public class PG_lv2_카펫 {

    static int brown, yellow;

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        /**
         * 가로는 세로보다 길거나 같다.
         * 1. brown 조합을 구하고 -> yellow 로 검증
         * 2. yellow 조합을 구하고 -> brown 으로 검증
         * 같다 -> 가로를 계속 길게
         */

        int w, h;

        w = (int) Math.ceil(brown / 4.0) + 1;
        h = brown/2 - w + 2;

        while ((w-2)*(h-2) != yellow) {
            w++;
            h--;
        }

        answer = new int[] {w, h};
        return answer;
    }

    static void init() {
        brown = 24;
        yellow = 24;
    }

    public static void main(String[] args) {
        init();
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }
}
