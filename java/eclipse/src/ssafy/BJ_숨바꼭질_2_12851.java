package ssafy;

import java.io.*;
import java.util.*;

public class BJ_숨바꼭질_2_12851 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, K, ub, ans, INF = 919191919;
	static int[] visited;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		if (N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		
		ub = Math.max(N, K) * 2 + 2;
		visited = new int[ub];
		Arrays.fill(visited, INF);
		dq = new ArrayDeque<>();
		
		dq.addLast(new int[] {N, 0});
		visited[N] = 0;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cp = cur[0];
			int ct = cur[1];
			
			int nt = ct+1;
			int np = cp-1;
			if (np >= 0 && visited[np] >= nt) {
				dq.addLast(new int[] {np, nt});
				visited[np] = nt;
				if (np == K) ans++;
			}
			
			np = cp+1;
			if (np < ub && visited[np] >= nt) {
				dq.addLast(new int[] {np, nt});
				visited[np] = nt;
				if (np == K) ans++;
			}
			
			np = cp*2;
			if (np < ub && visited[np] >= nt) {
				dq.addLast(new int[] {np, nt});
				visited[np] = nt;
				if (np == K) ans++;
			}
		}
		
		System.out.println(visited[K]);
		System.out.println(ans);
		
	}
}
