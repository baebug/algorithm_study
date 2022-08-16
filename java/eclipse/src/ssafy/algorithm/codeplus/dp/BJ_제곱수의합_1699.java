package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

// 자연수 N 을 표현하는 제곱수 항의 최소 수
public class BJ_제곱수의합_1699 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		dp = new int[100_001];
		
		N = Integer.parseInt(br.readLine());
		
		Arrays.fill(dp, 100000);

		// 제곱수들은 1이다.
		for (int i = 1; i*i <= 100_000; i++) {
			dp[i*i] = 1;
		}
		
		for (int i = 1; i <= 100_000; i++) {	// dp[i] += dp[i - 자기보다 작은 제곱수들]
			for (int j = 1; j*j < i; j++) {
				dp[i] = Math.min(dp[i-j*j] + 1, dp[i]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
