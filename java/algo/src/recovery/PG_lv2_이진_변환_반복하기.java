package recovery;

import java.util.Arrays;

public class PG_lv2_이진_변환_반복하기 {

    static String s;

    public static int[] solution(String s) {
        int[] answer = {};
        int cnt = 0, zeroCnt = 0;

        while (!s.equals("1")) {
            int bl = s.length();
            s = s.replace("0", "");
            int al = s.length();

            zeroCnt += bl - al;
            cnt ++;

            s = Integer.toBinaryString(al);
        }

        answer = new int[] {cnt, zeroCnt};
        return answer;
    }

    static void init() {
        s = "110010101001";
    }

    public static void main(String[] args) {
        init();
        System.out.println(Arrays.toString(solution(s)));
    }
}
