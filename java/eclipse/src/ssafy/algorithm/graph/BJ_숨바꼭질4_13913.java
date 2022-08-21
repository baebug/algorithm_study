package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

// 수빈이는 걸을 때 +-1, 순간이동 하면 *2
// 1. 가장 빠른 시간, 2. 어떻게 이동해야 하는지
public class BJ_숨바꼭질4_13913 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, K, ub;
	static int[] visited;
	static Deque<P> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		dq = new ArrayDeque<>();
		ub = Math.min(Math.max(N, K) * 2, 100000);
		visited = new int[ub+1];
		
		if (N >= K) {
			sb.append(N - K).append('\n');
			for (int i = N; i >= K; i--) {
				sb.append(i).append(' ');
			}
			System.out.print(sb);
			return;
		}
		
		bfs();
		
		System.out.print(sb);
		
	}
	
	static void bfs() {
		dq.clear();
		dq.add(new P(N, 0));
		visited[N] = 1;
		
		while(!dq.isEmpty()) {
			P cur = dq.removeFirst();
			int x = cur.x;
			int cnt = cur.cnt;
			List<Integer> path = cur.path;
			
			if (x == K) {
				sb.append(cnt + (x-K)).append('\n');
				for(int p : path) {
					sb.append(p).append(' ');
				}
				return;
			}
			
			
			int[] choice = new int[] {x-1, x+1, 2*x};
			for (int c : choice) {
				if (c < 0 || c > ub) continue;
				if (visited[c] == 0 || visited[c] > cnt) {
					dq.addLast(new P(c, cnt+1, path));
					visited[c] = cnt+1;
				}
			}
		}
	}
	
	static class P {
		int x, cnt;
		List<Integer> path;
		
		P(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
			this.path = new ArrayList<>();
			this.path.add(x);
		}
		
		P(int x, int cnt, List path) {
			this.x = x;
			this.cnt = cnt;
			this.path = new ArrayList<>(path);
			this.path.add(x);
		}
	}
}
