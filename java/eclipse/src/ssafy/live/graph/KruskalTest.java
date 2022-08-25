package ssafy.live.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return Integer.compare(this.weight, o.weight);
			return this.weight - o.weight;
		}
	}
	
	static int[] parents;
	static int V, E;
	static Edge[] edgeList;
	
	static void make() {	// 크기가 1인 서로소 집합 생성
		
		parents = new int[V];
		
		for (int i = 0; i < V; i++) {	// 모든 노드가 자신을 부모로 하는 집합
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);	// path compression
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		
		make();
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
		Arrays.sort(edgeList);
		
		int result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if (++count == V-1) break;
			}
		}
		
		System.out.println(result);
		
	}

}
