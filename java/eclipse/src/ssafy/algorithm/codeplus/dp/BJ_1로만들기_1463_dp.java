package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

public class BJ_1로만들기_1463_dp {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] dp = new int[1000001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			if (i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if (i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		
		System.out.println(dp[N]);
	}
}
