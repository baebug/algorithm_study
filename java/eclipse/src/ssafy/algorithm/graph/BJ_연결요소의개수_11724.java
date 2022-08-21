package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_연결요소의개수_11724 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, ans;
	static List<Integer>[] child;
	static boolean[] visited;
	static Deque<Integer> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		dq = new ArrayDeque<>();
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		visited = new boolean[N+1];
		child = new List[N+1];
		for (int i = 0; i <= N; i++) {
			child[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			child[a].add(b);
			child[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
			}
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int i) {
		dq.clear();
		dq.addLast(i);
		visited[i] = true;
		
		while (!dq.isEmpty()) {
			int cur = dq.removeFirst();
			
			for (int c : child[cur]) {
				if (visited[c]) continue;
				
				dq.addLast(c);
				visited[c] = true;
			}
		}
		
		ans++;
	}
}
