package basic;

import java.util.ArrayList;
import java.util.List;

public class PG_명예의전당1_1 {
    public int[] solution(int k, int[] score) {
        int size = score.length;
        int[] answer = new int[size];
        int cnt = 0;
        List<Integer> tmp = new ArrayList<>();

        for(int i=0; i<size; i++) {
            tmp.add(score[i]);
            tmp.sort((a, b) -> b-a);

            if (cnt < k) {
                answer[i] = tmp.get(cnt++);
            } else {
                answer[i] = tmp.get(k-1);
            }
        }
        return answer;
    }
}
