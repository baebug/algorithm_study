package recovery;

import java.util.Arrays;

public class PG_lv1_예산 {

    static int budget;
    static int[] d;

    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int cost : d) {
            if (budget >= cost) {
                budget -= cost;
                answer++;
            }
            else break;
        }

        return answer;
    }

    static void init() {
        d = new int[] {1, 3, 2, 5, 4};
        budget = 9;
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(d, budget));
    }
}
