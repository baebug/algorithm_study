package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

// 1씩 증가하고 감소하는 수 --> 계단수
public class BJ_쉬운계단수_10844 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		dp = new long[101][10];
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= 100; i++) {
			dp[i][0] += dp[i-1][1];
			for (int j = 1; j < 9; j++) {
				dp[i][j] += (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
			}
			dp[i][9] += dp[i-1][8];
		}
		
		N = Integer.parseInt(br.readLine());
		
		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans % 1_000_000_000);
	}
}
