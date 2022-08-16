package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

public class BJ_설탕배달_2839_dp {
	
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		dp = new int[5001];
		Arrays.fill(dp, 5000);
		dp[3] = dp[5] = 1;
		
		for (int i = 6; i <= 5000; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
		}
		
		N = Integer.parseInt(br.readLine());
		
		if (dp[N] >= 5000) System.out.println(-1);
		else System.out.println(dp[N]);
	}
	
}
