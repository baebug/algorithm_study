package recovery;

/**
 * 배열의 정렬
 * 문자열의 사전순 정리
 * 문자열로 정수를 관리할 때, 앞자리가 0 인 경우에 대한 유의
 */

import java.util.*;
public class PG_lv2_가장_큰_수 {
    class Solution {
        public String solution(int[] numbers) {
            StringBuilder sb = new StringBuilder();
            String[] aaa = new String[numbers.length];

            for(int i=0; i<numbers.length; i++) {
                aaa[i] = Integer.toString(numbers[i]);
            }

            Arrays.sort(aaa, (o1, o2) -> Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2));

            if (aaa[0].startsWith("0")) return "0";

            for(int i=0; i<numbers.length; i++) {
                sb.append(aaa[i]);
            }

            return sb.toString();
        }
    }
}
