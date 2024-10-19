package recovery;

public class PG_lv1_내적 {

    static int[] a, b;

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        int n = a.length;

        for(int i=0; i<n; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }

    public static void init() {
        a = new int[] {1, 2, 3, 4};
        b = new int[] {-3, -1, 0, 2};
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(a, b));
    }
}
