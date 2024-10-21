package recovery;

import java.util.*;

public class PG_lv2_영어_끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};

        Set<String> set = new HashSet<>();
        Character lastAl = words[0].charAt(0);

        for(int idx=0, i=1; idx<words.length; idx++, i++) {
            String cur = words[idx];
            if (set.contains(cur) || lastAl != cur.charAt(0)) {
                return new int[] {(idx%n)+1, (idx/n)+1};
            } else {
                set.add(cur);
                lastAl = cur.charAt(cur.length()-1);
            }
        }

        return answer;
    }
}
