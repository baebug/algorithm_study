package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

public class BJ_2n타일링_11726 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] dp = new int[1001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10_007;
		}
		
		System.out.println(dp[N]);
		
	}
}
