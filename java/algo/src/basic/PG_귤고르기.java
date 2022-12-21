package basic;

import java.util.Arrays;

public class PG_귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        Integer[] cnt = new Integer[10_000_001];
        Arrays.fill(cnt, 0);
        for(int kind : tangerine) {
            cnt[kind]++;
        }
        Arrays.sort(cnt, (a, b) -> b-a);

        while(sum < k) {
            sum += cnt[answer++];
        }
        return answer;
    }
}
