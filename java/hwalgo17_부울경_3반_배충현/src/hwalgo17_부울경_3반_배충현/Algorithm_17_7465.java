package hwalgo17_부울경_3반_배충현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Algorithm_17_7465 {
	
	static int T, N, M, ans;
	static List<Integer>[] adj;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> dq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		dq = new ArrayDeque<>();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			visited = new boolean[N+1];
			adj = new List[N+1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}
			
			ans = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) bfs(i);
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void bfs(int i) {
		dq.clear();
		visited[i] = true;
		dq.addLast(i);
		
		while(!dq.isEmpty()) {
			int cur = dq.removeFirst();
			
			for(int c : adj[cur]) {
				if (visited[c]) continue;
				visited[c] = true;
				dq.addLast(c);
			}
		}
		
		ans++;
	}

}
