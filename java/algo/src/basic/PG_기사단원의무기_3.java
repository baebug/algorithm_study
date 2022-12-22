package basic;

import java.util.Arrays;

public class PG_기사단원의무기_3 {

    boolean[] prime = new boolean[100_001];

    public int solution(int number, int limit, int power) {

        isPrime();

        int answer = 0;

        for(int i=1; i<=number; i++) {
            int tp = calcPower(i);
            if (tp > limit) answer += power;
            else answer += tp;
        }
        return answer;
    }

    int calcPower(int num) {
        if (num == 1) return 1;
        if (prime[num]) return 2;

        int ans = 0;

        for(int i=1; i*i<=num; i++) {
            if (num % i == 0) {
                if (i*i == num) ans += 1;
                else ans += 2;
            }
        }

        return ans;
    }

    void isPrime() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i=2; i<=1000; i++) {
            int tmp = i*2;

            while(tmp <= 100_000) {
                prime[tmp] = false;
                tmp += i;
            }
        }
    }
}
