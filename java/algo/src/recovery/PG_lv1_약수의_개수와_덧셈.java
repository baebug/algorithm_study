package recovery;

/**
 * 약수의 개수 = 소인수분해 후 (지수+1)의 곱
 * 18 = 2 * 3^2 = 6개
 * 1, 2, 3, 6, 9, 18
 *
 * 즉, 홀수인 지수가 있으면 약수의 개수는 짝수개다.
 */
public class PG_lv1_약수의_개수와_덧셈 {

    static int left, right;

    public static int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<=right; i++) {
            boolean flag = false;
            int[] visited = new int[i+1];
            int tmp = i;
            int div = 2;

            while (true) {
                if (tmp % div == 0) {
                    tmp /= div;
                    visited[div]++;
                } else div++;

                if (div > tmp) break;
            }

            for(int f : visited) {
                if ((f&1) == 1) {
                    flag = true;
                    break;
                }
            }

            if (flag) answer += i;
            else answer -= i;
        }

        return answer;
    }

    public static void init() {
        left = 1;
        right = 1000;
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(left, right));
    }

}
