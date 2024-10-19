package recovery;

public class PG_lv1_삼총사 {

    static int[] number;
    static int answer;

    public static int solution(int[] number) {
        answer = 0;

        comb(number, 0, 0, 0, 0);

        return answer;
    }

    static void comb(int[] arr, int start, int cnt, int sum, int flag) {
        if (cnt == 3) {
            if (sum == 0) answer++;
            return;
        }
        if (start == arr.length) return;

        for(int i=start; i<arr.length; i++) {
            if ((flag&1<<i) == 1) continue;
            comb(arr, i+1, cnt+1, sum+arr[i], flag|=1<<i);
        }
    }

    static void init() {
        number = new int[] {-3, -2, -1, 0, 1, 2, 3};
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(number));
    }
}
