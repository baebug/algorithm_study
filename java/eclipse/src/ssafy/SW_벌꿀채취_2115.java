package ssafy;

import java.io.*;
import java.util.*;

public class SW_벌꿀채취_2115 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int N = Integer.parseInt(br.readLine());
		int INF = 987654321;
		
		int[] dp = new int[N+5];
		Arrays.fill(dp, INF);
		dp[3] = 1;
		dp[5] = 1;
		
		for(int i=6; i<=N; i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
		}
		
		System.out.println(dp[N] >= INF ? -1 : dp[N]);
		
	}
}
