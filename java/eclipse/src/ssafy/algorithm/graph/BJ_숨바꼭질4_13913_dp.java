package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_숨바꼭질4_13913_dp {
	
	static StringBuilder sb = new StringBuilder();
	static int N, K, ub;
	static int[] dp, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		ub = Math.max(N, K) * 2 + 2;
		dp = new int[ub];
		
		if (N >= K) {
			sb.append(N-K).append('\n');
			for (int i = N; i >= K; i--) {
				sb.append(i).append(' ');
			}
			System.out.print(sb);
			return;
		}
		
		
		for (int i = 1; N - i >= 0; i++) {
			dp[N-i] = i;
		}
		
		for (int i = 1; N + i < ub; i++) {
			dp[N+i] = i;
		}
		
		for (int i = 1; i <= K; i++) {
			dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
			dp[i*2-1] = Math.min(dp[i*2-1], dp[i*2] + 1);
			dp[i*2+1] = Math.min(dp[i*2+1], dp[i*2] + 1);
		}
		
		sb.append(dp[K]).append('\n');
		
		result = new int[dp[K]+1];
		int tmp = K;
		result[0] = tmp;
		
		for (int i = 1; i < result.length; i++) {
			if (dp[tmp-1] == dp[tmp] - 1) {
				result[i] = tmp-1;
				tmp -= 1;
			}
			else if (dp[tmp+1] == dp[tmp] - 1) {
				result[i] = tmp+1;
				tmp += 1;
			}
			else if (dp[tmp/2] == dp[tmp] - 1) {
				result[i] = tmp/2;
				tmp /= 2;
			}
		}
		
		for (int i = 1, size = result.length; i <= result.length; i++) {
			sb.append(result[size-i]).append(' ');
		}
		
		System.out.print(sb);
	}
}
