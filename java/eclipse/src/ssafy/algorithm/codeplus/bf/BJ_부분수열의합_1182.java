package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_부분수열의합_1182 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, S, total;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		S = Integer.parseInt(stk.nextToken());
		input = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(stk.nextToken()); 
		}
		
		solve(0, 0, 0);
		
		System.out.println(total);
		
	}
	
	static void solve(int idx, int cnt, int sum) {
		if (idx == N) {
			if (cnt > 0 && sum == S) total++;
			return;
		}
		
		solve(idx+1, cnt, sum);
		solve(idx+1, cnt+1, sum+input[idx]);
	}
	
}
