package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

public class BJ_123더하기_9095 {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[12];
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for (int i = 4; i <= N; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			sb.append(dp[N]).append('\n');
		}
		
		System.out.print(sb);
	}
}
