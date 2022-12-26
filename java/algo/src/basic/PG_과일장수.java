package basic;

import java.util.Arrays;

public class PG_과일장수 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int size = score.length;
        Arrays.sort(score); // 오름차순으로 정렬

        for(int i=size-1; i>=m-1; i-=m) {
            int _min = k;
            for(int j=0; j<m; j++) {
                _min = Math.min(_min, score[i-j]);
            }
            answer += _min * m;
        }

        return answer;
    }
}
