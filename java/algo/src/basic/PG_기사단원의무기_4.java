package basic;

import java.util.Arrays;

public class PG_기사단원의무기_4 {

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

    // 약수의 개수 = 소인수분해 후 지수+1 의 곱 (부분집합개념)
    int calcPower(int num) {
        if (num == 1) return 1;
        if (prime[num]) return 2;

        int[] tmp = new int[num+1];

        for(int i=2; i<=100_000; i++) {
            if (prime[i]) {
                while(num % i == 0) {
                    num /= i;
                    tmp[i]++;
                }
            }

            if (prime[num]) {
                tmp[num]++;
                break;
            }
        }

        int rst = 1;

        for(int c : tmp) {
            rst *= c+1;
        }

        return rst;
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
