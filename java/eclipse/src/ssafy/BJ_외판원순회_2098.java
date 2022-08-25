package ssafy;

import java.io.*;
import java.util.*;

public class BJ_외판원순회_2098 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, INF = 987654321;
	static int[][] input, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		dp = new int[N+1][1<<N+1];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		System.out.println(solve(0, 1));
	}
	
	static int solve(int cur, int path) {
		if (path == (1<<N)-1) {
			if (input[cur][0] == 0) return INF;
			return input[cur][0];
		}
		if (dp[cur][path] != 0) return dp[cur][path];
		int result = INF;
		for (int i = 1; i < N; i++) {
			if ((path&1<<i)!=0 || input[cur][i] == 0) continue;
			result = Math.min(result, solve(i, path|(1<<i))+input[cur][i]);
		}
		return dp[cur][path] = result;
	}
}
