package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

public class BJ_1로만들기_1463_recursion {
	
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int[] d = new int[1000001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		
		System.out.println(dp(N));
	}
	
	static int dp(int x) {
		if (x == 1) return 0;
		if (x == 2) return 1;
		if (x == 3) return 1;
		if (d[x] != 0) return d[x];
		
		if (x % 6 == 0) return d[x] = Math.min(dp(x-1), Math.min(dp(x/3), dp(x/2))) + 1;
		if (x % 3 == 0) return d[x] = Math.min(dp(x/3), dp(x-1)) + 1;
		if (x % 2 == 0) return d[x] = Math.min(dp(x/2), dp(x-1)) + 1;
		return d[x] = dp(x-1) + 1;
		
	}
	
}
