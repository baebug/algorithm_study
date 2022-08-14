package ssafy.algorithm.codeplus;

import java.io.*;
import java.util.*;

public class BJ_123더하기_9095 {
	
	static StringBuilder sb = new StringBuilder();
	static int T, n, cnt;
	static int[] dp = new int[100];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			
			sb.append(solve(n)).append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	static int solve(int num) {
		if (num == 1) return dp[1] = 1;
		else if (num == 2) return dp[2] = 2;
		else if (num == 3) return dp[3] = 4;
		
		return dp[num] = solve(num-1) + solve(num-2) + solve(num-3);  
		
	}
	
}
