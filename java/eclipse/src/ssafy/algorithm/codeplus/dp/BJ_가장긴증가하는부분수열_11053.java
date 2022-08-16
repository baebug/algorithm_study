package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

public class BJ_가장긴증가하는부분수열_11053 {
	
	static int N, ans;
	static int[] input, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		dp = new int[N+1];
		Arrays.fill(dp, 1);
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		
		ans = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if(input[i] > input[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);		// 제일 높은 애 들어오면 안바뀌게
					ans = Math.max(ans, dp[i]);
				}
				
			}
		}
		
		System.out.println(ans);
	}
}
