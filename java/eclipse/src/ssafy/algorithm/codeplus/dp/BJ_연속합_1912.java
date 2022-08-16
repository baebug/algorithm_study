package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

// n 개의 정수 수열 중 연속된 수를 더해 만들 수 있는 가장 큰 합
// 음수가 나오면 끊긴다.
// 정수 1~10만개, 수는 -1000~1000
public class BJ_연속합_1912 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, ans = Integer.MIN_VALUE;
	static int[] input, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
			ans = Math.max(ans, input[i]);
		}
		
		if (ans <= 0) {
			System.out.println(ans);
			return;
		}
		
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if (dp[i-1] + input[i] >= 0) {
				dp[i] = dp[i-1] + input[i];
				ans = Math.max(ans, dp[i]);
			}
			else dp[i] = 0;
		}
		
		System.out.println(ans);
		
	}
}
