package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;


public class BJ_퇴사_14501_dp {
	
	static StringBuilder sb = new StringBuilder();
	static int N, total, ans;
	static int[][] input;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		// 1 일부터 N일 까지 상담
		input = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			input[i] = new int[] {Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
		}
		
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			total = 0;
			if (i + input[i][0] -1 <= N) dp[i] = input[i][1];
			for (int j = 1; j < i; j++) {
				int ed = j + input[j][0] -1;
				if (ed > N) continue;
				if (ed < i) {
					total = Math.max(total, dp[i]+dp[j]);
				}
			}
			dp[i] = Math.max(dp[i], total);
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
