package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class BJ_이항계수_1_11050 {

	static int N, K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		System.out.println(solve(N, K));
		
	}
	
	static int solve(int n, int k) {
		if (n == k) return 1;
		if (k == 1) return n;
		
		return solve(n-1, k) + solve(n-1, k-1);
	}
}
