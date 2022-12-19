package basic;

public class PG_점찍기_1 {
    public long solution(int k, int d) {
        long answer = 0;

        int cy = d/k * k;

        for(int cx=0; cx<=d; cx+=k) {
            while(!valid(cy, cx, d)) {
                cy -= k;
            }
            answer += cy/k + 1;
        }

        return answer;
    }

    boolean valid(long y, long x, long d) {
        return y*y + x*x <= d*d;
    }
}
