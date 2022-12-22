package basic;

public class PG_기사단원의무기_1 {
    public int solution(int number, int limit, int power) {
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

        int div = 2;
        int[] tmp = new int[num+1];

        while(num > 1) {
            if (num % div == 0) {
                num /= div;
                tmp[div]++;
            }
            else div++;
        }

        int rst = 1;

        for(int c : tmp) {
            rst *= c+1;
        }

        return rst;
    }
}
