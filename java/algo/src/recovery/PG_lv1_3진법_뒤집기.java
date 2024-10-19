package recovery;

import java.util.*;

public class PG_lv1_3진법_뒤집기 {

    static int n;

    public static int solution(int n) {
        int answer = 0;

        String s = toSamString(n);
        int l = s.length();
        
        for(int i=l-1, idx=0; i>=0; i--, idx++) {
            int val = Integer.parseInt(Character.toString(s.charAt(i)));
            answer += val * Math.pow(3, idx);
        }

        return answer;
    }

    private static String toSamString(int n) {
        List<String> tl = new ArrayList<>();

        while (n != 0) {
            int tmp = n % 3;
            tl.add(tmp+"");
            n /= 3;
        }

        return String.join("", tl);
    }

    static void init() {
        n = 45;
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(n));
    }
}
