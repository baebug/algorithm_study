package ssafy;

import java.io.*;
import java.util.*;

public class dpex2 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+5];
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i=3; i<=N; i++) {
			dp[i] = 2 * dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
	}
}
