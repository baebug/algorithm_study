package basic;

public class PG_유사칸토어비트열 {
    public int solution(int n, long l, long r) {
        int answer = 0;
        answer = solve(n, r, 0) - solve(n, l-1, 0);
        return answer;
    }

    int solve(int n, long ed, int ans) {
        if (n == 0) return ans;
        int nn = n-1;
        long div = (long) Math.pow(5, nn);
        long k = (ed / div) + 1;
        long rest = ed % div;

        int tmp = ans;
        for(int i=1; i<k; i++) {
            if (i != 3) tmp += (int) Math.pow(4, nn);
        }

        if (k == 3) return tmp;
        else return solve(nn, rest, tmp);
    }

}

// 62 92
// f(62) = 25(1) + 25(1) + 5 + 5 + 2
// f(92) = 25(1) + 25(1) + 25(0) + f(17)