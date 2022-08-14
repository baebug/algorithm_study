package ssafy.algorithm.codeplus.math;

import java.io.*;
import java.util.*;

// g(x) --> x 보다 작거나 같은 자연수의 모든 약수의 합
public class BJ_약수의합_17425 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, T;
	static long[] dp, quo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		dp = new long[1000001];
		quo = new long[1000001];
		
		for (int i = 1; i < quo.length; i++)
			quo[i] = 1000000/i;
		
		for (int i = 1; i < quo.length; i++)
			for (int j = 1; j <= quo[i]; j++)
				dp[i*j] += i;
		
		for (int i = 2; i < quo.length; i++)
			dp[i] += dp[i-1];
		
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			System.out.println(dp[N]);
		}
	}
	
}
