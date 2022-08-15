package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

// 0 으로 시작하지 않으며 1이 두 번 연속으로 나타나지 않으면 이친수.
public class BJ_이친수_2193 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		dp = new long[91][2];
		// 1의 자리가 1 인 수
		dp[1][1] = 1;
		
		for (int i = 2; i <= 90; i++) {
			dp[i][0] += dp[i-1][0] + dp[i-1][1];
			dp[i][1] += dp[i-1][0];
		}
		
		N = Integer.parseInt(br.readLine());
		
		System.out.println(dp[N][0]+dp[N][1]);
		
	}
}
