package basic;

import java.util.Arrays;

public class PG_테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (a, b) -> a[col-1] == b[col-1] ? b[0] - a[0] : a[col-1] - b[col-1]);

        for(int i=row_begin; i<=row_end; i++) {
            int[] row = data[i-1];
            int tmp = 0;
            for(int a : row) {
                tmp += a % i;
            }

//            if (answer == 0) answer = tmp;
//            else
            answer ^= tmp;
        }

        return answer;
    }
}
