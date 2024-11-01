package recovery;

/**
 * 이진탐색 (이분탐색)
 */

import java.util.*;

public class PG_lv2_퍼즐_게임_챌린지 {

    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        // (diff - level) * (time_cur + time_prev) + time_cur

        int[] sum_times = Arrays.copyOf(times, times.length);

        for(int i=times.length-1; i>0; i--) {
            sum_times[i] += sum_times[i-1];
        }

        int maxLevel = 100000;
        int minLevel = 1;

        while (minLevel < maxLevel) {
            int tmp = (maxLevel + minLevel) / 2;

            if (calcLevel(tmp, diffs, times, sum_times, limit)) maxLevel = tmp;
            else minLevel = tmp+1;
        }

        return maxLevel;
    }

    public boolean calcLevel(int level, int[] diffs, int[] times, int[] sum_times, long limit) {
        long sum = 0;

        for(int i=0; i<diffs.length; i++) {
            if (diffs[i] > level) sum += (diffs[i] - level) * sum_times[i] + times[i];
            else sum += times[i];

            if (sum > limit) break;
        }

        if (sum <= limit) return true;

        return false;
    }
}
