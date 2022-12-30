package basic;

public class PG_우박수열정적분 {

    double[] area;
    int idx;

    // range : {3, -2} --> 3 ~ (max_x-2)
    public double[] solution(int k, int[][] ranges) {
        int size = ranges.length;
        double[] answer = new double[size];

        solve(k);

        for (int i=0; i<size; i++) {
            int[] cur = ranges[i];
            int from = cur[0];
            int to = idx + cur[1];

            if (from > to) answer[i] = -1;
            else {
                for(int j=from; j<to; j++) {
                    answer[i] += area[j];
                }
            }
        }

        return answer;
    }

    // 그래프를 그려가면서 구간별 넓이도 같이 저장
    void solve(int k) {
        area = new double[k];
        idx = 0;

        while(true) {
            int tmp = k;
            if ((k&1) == 0) {
                tmp /= 2;
            } else {
                tmp = k * 3 + 1;
            }
            area[idx++] = (double)(k + tmp) / 2;

            if (tmp <= 1) return;
            k = tmp;
        }
    }

}
