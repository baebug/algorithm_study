package ssafy;

import java.io.*;
import java.util.*;

public class SW_홈방범서비스_2117 {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, K, cost, ans, need, cnt;
	static int[][] input, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;
	static List<int[]> hl;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		hl = new ArrayList<>();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			input = new int[N][N];
			hl.clear();
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(stk.nextToken());
					if (input[i][j] == 1) hl.add(new int[] {i, j});
				}
			}
			
			K = 1;
			ans = 0;
			while(true) {
				cost = K*K + (K-1)*(K-1);
				need = (int) Math.ceil((double) cost/M);
				int tmp = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						tmp = Math.max(tmp, solve(i, j));
					}
				}
				if (tmp >= need) ans = Math.max(ans, tmp);
				if (K == N*2) break;
				else K++;
			}
			
			sb.append(ans).append('\n');
			
		}
		System.out.print(sb);
	}
	
	static int solve(int y, int x) {
		cnt = 0;
		for(int[] home : hl) {
			if (dist(y, x, home[0], home[1]) < K) cnt++;
		}
		return cnt;
	}
	
	static int dist(int y, int x, int hy, int hx) {
		return Math.abs(y - hy) + Math.abs(x - hx);
	}
}
