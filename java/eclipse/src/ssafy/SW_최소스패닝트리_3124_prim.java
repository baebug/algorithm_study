package ssafy;

import java.io.*;
import java.util.*;

// 프림 -- 힙으로 dist 가 가장 작은 간선을 계속 본다.
public class SW_최소스패닝트리_3124_prim {
	
	static StringBuilder sb = new StringBuilder();
	static int T, V, E;
	static long ans;
	static List<Edge>[] adj;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			stk = new StringTokenizer(br.readLine());
			V = Integer.parseInt(stk.nextToken());
			E = Integer.parseInt(stk.nextToken());
			adj = new List[V+1];
			pq = new PriorityQueue<>();
			visited = new boolean[V+1];
			for (int i = 0; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				stk = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				int dist = Integer.parseInt(stk.nextToken());
				
				adj[from].add(new Edge(to, dist));
				adj[to].add(new Edge(from, dist));
			}
			
			ans = 0;
			visited[1] = true;
			addEdge(1);
			
			while(!pq.isEmpty()) {
				Edge cur = pq.poll();
				
				if (visited[cur.next]) continue;
				visited[cur.next] = true;
				ans += cur.dist;
				addEdge(cur.next);
				
			}
			
			sb.append("#").append(t).append(" ").append(ans).append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	static class Edge implements Comparable<Edge> {
		int next, dist;
		
		Edge(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	static void addEdge(int from) {
		for(Edge edge : adj[from]) {
			if (visited[edge.next]) continue;
			pq.add(edge);
		}
	}

}
