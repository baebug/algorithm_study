package recovery;

/**
 * 모든 카드를 가지런히 정리하는 개념으로 접근
 */
public class PG_lv1_최소직사각형_solution {

    static int[][] sizes;

    public static int solution(int[][] sizes) {
        int answer = 0;
        int w = 0, h = 0;

        for(int[] card : sizes) {
            w = Math.max(w, Math.max(card[0], card[1]));
            h = Math.max(h, Math.min(card[0], card[1]));
        }

        answer = w * h;

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
