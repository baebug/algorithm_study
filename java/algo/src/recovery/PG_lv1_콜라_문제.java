package recovery;

public class PG_lv1_콜라_문제 {

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int restCoke = n%a;
            int newCoke = (n/a) * b;

            answer += newCoke;
            n = restCoke + newCoke;
        }

        return answer;
    }
}
