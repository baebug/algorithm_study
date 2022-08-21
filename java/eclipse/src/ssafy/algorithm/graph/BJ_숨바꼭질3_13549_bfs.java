package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_숨바꼭질3_13549_bfs {
	
	static StringBuilder sb = new StringBuilder();
	static int N, K, ub, ans;
	static Deque<int[]> dq;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		ub = Math.max(N, K) * 2 + 2;
		visited = new int[ub];
		Arrays.fill(visited, -1);
		dq = new ArrayDeque<>();
		
		if (N >= K) {
			System.out.println(N-K);
			return;
		}
		
		// 위치, 시간
		dq.addLast(new int[] {N, 0});
		solve();
		
		System.out.println(ans);
		
	}
	
	static void solve() {
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cx = cur[0];
			int ct = cur[1];
			
			if (cx == K) {
				ans = ct;
				return;
			}
			
			int nx = 2 * cx;
			if (nx < ub && (visited[nx] == -1 || visited[nx] > ct)) {
				visited[nx] = ct;
				dq.addLast(new int[] {nx, ct});
			}
			
			int nt = ct + 1;
			nx = cx - 1;
			if (cx > 0 && (visited[nx] == -1 || visited[nx] > nt)) {
				visited[nx] = nt;
				dq.addLast(new int[] {nx, nt});
			}
			
			nx = cx + 1;
			if (nx < ub && (visited[nx] == -1 || visited[nx] > nt)) {
				visited[nx] = nt;
				dq.addLast(new int[] {nx, nt});
			}
			
			
		}
	}
}
