package ssafy;

import java.io.*;
import java.util.*;

public class BJ_외판원순회_2098_342 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, ans, INF = 919191919;
	static int[][] input, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		dp = new int[N+1][(1<<N+1)];
		
		System.out.println(solve(1, 3));
		
	}
	
	static int solve(int cur, int path) {
		if (path == (1<<N+1)-1) {
			if (input[cur][1] == 0) return INF;
			return input[cur][1];
		}
		if (dp[cur][path] != 0) return dp[cur][path];
		int result = INF;
		for (int i = 2; i <= N; i++) {
			if ((path & 1<<i)!= 0 || input[cur][i] == 0) continue;
			result = Math.min(result, solve(i, path|1<<i) + input[cur][i]);
		}
		return dp[cur][path] = result;
	}
	
}
