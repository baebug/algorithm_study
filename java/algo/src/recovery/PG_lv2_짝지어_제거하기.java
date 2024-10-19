package recovery;

import java.util.*;

public class PG_lv2_짝지어_제거하기 {

    static String s;

    public static int solution(String s) {
        int answer = -1;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Deque<String> dq = new ArrayDeque<>();

        char[] carr = s.toCharArray();

        for(int i=0; i<carr.length; i++) {
            String cur = String.valueOf(carr[i]);
            if (dq.isEmpty()) dq.addLast(cur);
            else {
                if (dq.peekLast().equals(cur)) dq.removeLast();
                else dq.addLast(cur);
            }
        }

        if (dq.isEmpty()) answer = 1;
        else answer = 0;

        return answer;
    }

    static void init() {
        s = "cdcd";
    }

    public static void main(String[] args) {
        init();
        System.out.println(solution(s));
    }
}
