package recovery;

public class PG_lv1_음양더하기 {

    static int[] absolutes;
    static boolean[] signs;

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int n = absolutes.length;

        for(int i=0; i<n; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

    public static void init() {
        absolutes = new int[] {4,7,12};
        signs = new boolean[] {true, false, true};
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(absolutes, signs));
    }
}
