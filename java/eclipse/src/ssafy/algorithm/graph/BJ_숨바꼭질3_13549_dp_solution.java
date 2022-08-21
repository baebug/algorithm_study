package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_숨바꼭질3_13549_dp_solution {
	
	static StringBuilder sb = new StringBuilder();
	static int N, K, ub;
	static int[] dp;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		if (N >= K) {
			System.out.println(N-K);
			return;
		}
		
		ub = Math.max(N*2+2, K*2+2);
		dp = new int[ub];
		
		// 뒤로 한 칸 씩 이동하는 경우 다 채운다.
		for (int i = 1; N - i >= 0; i++) {
			dp[N-i] = i;
		}
		
		// 앞으로 한 칸 씩 이동하는 경우 다 채운다.
		for (int i = 1; N + i < ub; i++) {
			dp[N+i] = i;
		}
		
		// 두 배로 이동하는 경우 채운다.
		for (int i = 1; i <= K; i++) {
			dp[i*2] = Math.min(dp[i*2], dp[i]);
			dp[i*2 - 1] = Math.min(dp[i*2 - 1], dp[i*2] + 1);
			dp[i*2 + 1] = Math.min(dp[i*2 + 1], dp[i*2] + 1);
		}
		
		System.out.println(dp[K]);
	
	}
}
