package basic;

import java.util.*;

public class PG_디펜스게임 {

    int round, endRound, sum;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    // n 10억, k 50만, enemy 100만
    // n 초과할때까지 pq 에 계속 담고 -> 높은 순으로 k 번 뺀다.

    public int solution(int n, int k, int[] enemy) {
        endRound = enemy.length;

        while (true) {
            if (round == endRound) break;

            pq.add(enemy[round]);
            sum += enemy[round];

            if (n < sum) {
                if (k == 0) break;
                k--;
                sum -= pq.remove();
            }

            round++;
        }

        return round;
    }

}