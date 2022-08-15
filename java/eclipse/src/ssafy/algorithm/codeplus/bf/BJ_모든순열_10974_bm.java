package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_모든순열_10974_bm {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		solve(0, 0);
		
		System.out.print(sb);
	
	}
	
	static void solve(int cnt, int flag) {
		if (cnt == N) {
			for(int i : input) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if ((flag & 1<<i) != 0) continue;
			
			input[cnt] = i;
			solve(cnt+1, flag | 1<<i);
		}
	}
	
}
