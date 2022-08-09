package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_DFS와BFS_1260 {

	static int N, M, V;
	static List<Integer>[] child;
	static boolean[] visited;
	static Deque<Integer> dq;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		V = Integer.parseInt(stk.nextToken());
		visited = new boolean[N+1];
		child = new ArrayList[N+1];
		dq = new ArrayDeque<>();
		
		for (int i = 0; i < child.length; i++) {
			child[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			child[a].add(b);
			child[b].add(a);
		}
		
		// 작은 것부터 방문
		for (int i = 0; i < child.length; i++) {
			Collections.sort(child[i]);
		}
		
		// 초기화
		sb.setLength(0);
		dq.clear();
		
		// dfs 돌면서 출력문 작성
		visited[V] = true;
		sb.append(V).append(' ');
		dfs(V);
		sb.append('\n');
		
		// bfs 를 위한 방문 초기화
		Arrays.fill(visited, false);
		
		visited[V] = true;
		dq.addLast(V);
		sb.append(V).append(' ');
		
		while (!dq.isEmpty()) {
			int cur = dq.peekFirst();
			
			for (int i : child[cur]) {
				if (visited[i]) continue;
				visited[i] = true;
				dq.addLast(i);
				sb.append(i).append(' ');
			}
			
			dq.removeFirst();
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int st) {
		boolean flag = true;
		for (int i : child[st]) {
			if (!visited[i]) flag = false;
		}
		if (flag) return;
		
		for (int i : child[st]) {
			if (visited[i]) continue;
			
			visited[i] = true;
			sb.append(i).append(' ');
			
			dfs(i);
		}
	}
	
}
