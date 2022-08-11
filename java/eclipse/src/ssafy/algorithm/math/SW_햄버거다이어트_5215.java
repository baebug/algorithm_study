package ssafy.algorithm.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_햄버거다이어트_5215 {

	static int T, N, L, ans;
	static M[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());		// 재료 수
			L = Integer.parseInt(stk.nextToken());		// 제한 칼로리
			input = new M[N];
			
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				input[i] = new M(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
			}
			
			Arrays.sort(input);
			
			ans = 0;
			solve(0, 0, 0);
			
			sb.append(ans).append('\n');
			
		}
		
		System.out.print(sb);
		
	}
	
	static void solve(int idx, int score, int cals) {
		if (idx == N) {
			if (cals <= L) ans = Math.max(ans, score);
			return;
		}
		if (cals > L) {
			return;
		}
		
		ans = Math.max(ans, score);
		solve(idx+1, score, cals);
		solve(idx+1, score+input[idx].taste, cals+input[idx].cal);
		
	}
	
	static class M implements Comparable<M> {
		int taste;
		int cal;
		
		public M(int t, int c) {
			this.taste = t;
			this.cal = c;
		}
		
		public int compareTo(M o) {
			return this.cal == o.cal ? this.taste - o.taste : this.cal - o.cal;
		}
	}

}
