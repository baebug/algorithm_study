package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최단경로_1753 {
	
	static int V, E, K;
	static List<List<Edge>> vertex = new ArrayList<>();
	static boolean[] visited;
	static int[] cost;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(br.readLine());
		
		visited = new boolean[V+1];
		cost = new int[V+1];
		
		for (int i = 0; i <= V; i++) {
			vertex.add(new ArrayList<>());
			cost[i] = INF;
		}
		
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(stk.nextToken());
			int v2 = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			
			vertex.get(v1).add(new Edge(v2, w));
		}
		
		dijkstra();
		
		for (int i = 1; i <= V; i++) {
			System.out.println( cost[i] == INF ? "INF" : cost[i] );
		}

	}
	
	static void dijkstra() {
		cost[K] = 0;
		pq.offer(new Edge(K, 0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if (e.c > cost[e.v]) continue;
			
			if (visited[e.v]) continue;
			
			visited[e.v] = true;
			
			for(Edge ne : vertex.get(e.v)) {
				if (!visited[ne.v] && cost[e.v] + ne.c < cost[ne.v]) {
					cost[ne.v] = cost[e.v] + ne.c;
					pq.add(new Edge(ne.v, cost[ne.v]));
				}
			}
		}
	}
	
	static class Edge {
		int v;	// 정점
		int c;	// 비용
		
		public Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

}
