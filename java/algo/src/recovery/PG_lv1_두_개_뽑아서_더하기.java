package recovery;

import java.util.*;

public class PG_lv1_두_개_뽑아서_더하기 {

    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        Integer[] ans = set.toArray(new Integer[0]);
        answer = Arrays.stream(ans).mapToInt(i -> i).toArray();
        Arrays.sort(answer);

        return answer;
    }
}
