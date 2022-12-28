package basic;

import java.util.ArrayList;
import java.util.List;

public class PG_숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        return Math.max(solve(arrayA, arrayB), solve(arrayB, arrayA));
    }

    int solve(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int size = arrayA.length;

        // 철수가 가진 카드들의 최대공약수를 구한다.
        int gcd = arrayA[0];
        for(int i=1; i<size; i++) {
            gcd = getGCD(gcd,arrayA[i]);
        }

        // 최대공약수의 약수를 전부 구한다.
        List<Integer> commons = new ArrayList<>();
        for(int i=1; i*i<=gcd; i++) {
            if (gcd % i == 0) {
                commons.add(i);
                if (i*i != gcd) commons.add(gcd/i);
            }
        }

        // 약수들을 역순으로 영희 나눠보다가 안나눠지면 stop
        commons.sort((a, b) -> b-a);
        for(int div : commons) {
            boolean flag = true;
            for(int tmp : arrayB) {
                if (tmp % div == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer = div;
                break;
            }
        }

        return answer;
    }

    int getGCD(int a, int b) {
        int M = Math.max(a, b);
        int m = Math.min(a, b);

        while(true) {
            int tmp = M % m;

            if (tmp == 0) {
                return m;
            } else {
                M = m;
                m = tmp;
            }
        }
    }
}
