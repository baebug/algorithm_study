package ssafy;

import java.io.*;
import java.util.*;

public class dpex1 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+5][2]; // 0: 노랑, 1: 파랑
		dp[1][0] = dp[1][1] = 1;
				
		for(int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(dp[N][0]+dp[N][1]);
		
	}
}
