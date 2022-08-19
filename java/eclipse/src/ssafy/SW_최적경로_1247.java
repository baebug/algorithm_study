package ssafy;

import java.io.*;
import java.util.*;

// 회사 - 고객 방문 - 집
// 
public class SW_최적경로_1247 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, T, ans;
	static int[] c, h;
	static int[][] input, path;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			
			N = Integer.parseInt(br.readLine());
			input = new int[N][2];
			path = new int[N][];
			stk = new StringTokenizer(br.readLine());
			
			int cx = Integer.parseInt(stk.nextToken());
			int cy = Integer.parseInt(stk.nextToken());
			int hx = Integer.parseInt(stk.nextToken());
			int hy = Integer.parseInt(stk.nextToken());
			c = new int[] {cy, cx};
			h = new int[] {hy, hx};
			
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				input[i] = new int[] {y, x};
			}
			
			ans = Integer.MAX_VALUE;
			perm(0, 0);
			
			sb.append(ans).append('\n');
			
		}
		
		System.out.print(sb);
		
		
	}
	
	static void perm(int cnt, int flag) {
		if (cnt == N) {
			int sum = Math.abs(c[0] - path[0][0]) + Math.abs(c[1] - path[0][1]);
			for (int i = 1; i < N; i++) {
				sum += Math.abs(path[i][0] - path[i-1][0]) + Math.abs(path[i][1] - path[i-1][1]);
			}
			sum += Math.abs(h[0] - path[N-1][0]) + Math.abs(h[1] - path[N-1][1]);
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			path[cnt] = input[i];
			perm(cnt+1, flag|1<<i);
		}
	}
}
