package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_카잉달력_6064 {
	
	static StringBuilder sb = new StringBuilder();
	static int T, M, N, x, y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			stk = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(stk.nextToken());
			N = Integer.parseInt(stk.nextToken());
			x = Integer.parseInt(stk.nextToken());
			y = Integer.parseInt(stk.nextToken());
			
			System.out.println(solve());
			
		}
	}
	
	static int solve() {
		int ans = x;
		int k = x;
		if (M == x) x = 0;
		if (N == y) y = 0;
		
		while (ans <= M*N/getGCD(M, N)) {
			if (k % N == y) return ans;
			
			ans += M;
			k = (k+M)%N;
		}
		
		return -1;
	}
	
	static int getGCD(int a, int b) {
		int M = Math.max(a, b);
		int m = Math.min(a, b);
		
		while (true) {
			int tmp = M % m;
			
			if (tmp == 0) {
				return m;
			}
			else {
				M = m;
				m = tmp;
			}
		}
				
	}
	
}
