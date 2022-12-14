package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_신나는함수실행_9184 {

	static StringBuilder sb = new StringBuilder();
	static int a, b, c;
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		dp = new int[105][105][105];
		
		while (true) {
			stk = new StringTokenizer(br.readLine());
			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			if (a == -1 && b == -1 && c == -1) {
				System.out.print(sb);
				return;
			}
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
				.append(w(a, b, c)).append('\n');
		}
		
	}
	
	static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if (dp[a][b][c] != 0) return dp[a][b][c];
		
		if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		
		return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}

}
