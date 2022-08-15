package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

// N 개의 카드를 구매하기 위해 민규가 지불할 금액의 최댓값
public class BJ_카드구매하기_11052 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] input, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		dp = new int[N+1];
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		
		dp[1] = input[1];
		for (int i = 2; i <= N; i++) {
			dp[i] = input[i];
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		
		System.out.println(dp[N]);
		
	}
}
