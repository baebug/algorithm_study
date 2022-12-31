package basic;

// dp 는 아직 미숙하다. 나중에 다시?
public class PG_마법의엘리베이터_2 {

    int ub = 100_000_000;
    int[] dp = new int[ub+1];

    public int solution(int storey) {
        int answer = 0;
        solve(storey);

        System.out.println(dp[0]);
        return answer;
    }

    void solve(int storey) {
        dp[storey] = 0;

        for(int i=1; storey-i>=0; i++) {
            dp[storey-i] = i;
        }

        for(int i=1; storey+i<=ub; i++) {
            dp[storey+i] = i;
        }

        // dp
    }
}
