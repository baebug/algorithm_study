package basic;

public class PG_점찍기_2 {
    public long solution(int k, int d) {
        long answer = 0;

        for(int cx=0; cx<=d; cx+=k) {
            int y = getY(cx, d)/k;

            answer += y + 1;
        }

        return answer;
    }

    int getY(double cx, double d) {
        return (int) Math.sqrt(d*d - cx*cx);
    }

}
