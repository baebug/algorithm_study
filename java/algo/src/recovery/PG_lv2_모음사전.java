package recovery;

/**
 * 조합
 * 문자열의 사전순 정렬
 * 리스트 정렬 방식
 *  1. List.sort([lambda])
 *  2. Collections.sort(list, [lambda])
 */

import java.util.*;
public class PG_lv2_모음사전 {
    public int solution(String word) {
        int answer = 0;
        String[] chars = new String[] {"A", "E", "I", "O", "U"};

        List<String> dict = new ArrayList<>();

        comb("", 0, 1, chars, dict);
        comb("", 0, 2, chars, dict);
        comb("", 0, 3, chars, dict);
        comb("", 0, 4, chars, dict);
        comb("", 0, 5, chars, dict);

        Collections.sort(dict);

        return dict.indexOf(word)+1;
    }

    public void comb(String word, int st, int cnt, String[] chars, List<String> dict) {
        if (st == cnt) {
            dict.add(word);
            return;
        }

        for(int i=0; i<5; i++) {
            comb(word+chars[i], st+1, cnt, chars, dict);
        }
    }
}
