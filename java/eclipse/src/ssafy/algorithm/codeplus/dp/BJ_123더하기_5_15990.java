package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

// 합을 나타낼 때는 수를 1개 이상, 같은 수를 두 번 이상 연속해서 X
public class BJ_123더하기_5_15990 {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N;
	static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		dp = new long[100001][4];
		
		dp[1][1] = dp[2][2] = dp[3][3] = dp[3][1] = dp[3][2] = 1;
		
		for (int i = 4; i <= 100000; i++) {
			dp[i][1] += (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
			dp[i][2] += (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
			dp[i][3] += (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
		}
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			sb.append((dp[N][1]+dp[N][2]+dp[N][3])%1_000_000_009).append('\n');
		}
		System.out.print(sb);
		
	}
}
