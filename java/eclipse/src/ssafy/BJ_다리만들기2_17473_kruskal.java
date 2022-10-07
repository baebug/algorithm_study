package ssafy;

import java.io.*;
import java.util.*;

public class BJ_다리만들기2_17473_kruskal {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, V, cnt, ans, INF=987654321;
	static int[][] input, dist, dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상 하 좌 우
	static boolean[][] visited;
	static int[] parent;
	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		// 입력받기
		input = new int[N][M];
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// dfs로 섬 개수 세기
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (!visited[i][j] && input[i][j] == 1) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		
		
		// 섬의 포인트에서 dt 로 쭉 이동하다가 다른 섬을 만나면 dist 갱신
		dist = new int[cnt+1][cnt+1];
		for(int i=0; i<=cnt; i++) {
			Arrays.fill(dist[i], INF);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (input[i][j] != 0) calc(i, j);
			}
		}
		
		for(int i=1; i<=cnt; i++) {
			for(int j=1; j<=cnt; j++) {
				if (dist[i][j] == INF) continue;
				pq.offer(new Edge(i, j, dist[i][j]));
			}
		}
		
		V = cnt;
		
		parent = new int[V+1];
		makeSet(V);
		
		int count = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if (union(e.v1, e.v2)) {
				ans += e.cost;
				count++;
			}
			
			if (count == V - 1) break;
		}
		
		if (count != V-1) ans = -1;
		System.out.println(ans == 0 ? -1 : ans);
		
	}
	
	static void calc(int y, int x) {
		int st = input[y][x];
		
		for(int d=0; d<4; d++) {
			int ny = y;
			int nx = x;
			int cnt = 0;
			while(true) {
				ny += dt[d][0];
				nx += dt[d][1];
				
				if (ny<0 || ny>=N || nx<0 || nx>=M) break;
				if (input[ny][nx] == st) break;
				else if (input[ny][nx] == 0) {
					cnt++;
					continue;
				}
				else {
					int target = input[ny][nx];
					if (cnt >=2) {
						dist[target][st] = Math.min(dist[target][st], cnt);
						dist[st][target] = Math.min(dist[st][target], cnt);
					}
					break;
				}
			}
		}
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		input[y][x] = cnt;
		
		for(int d=0; d<4; d++) {
			int ny = y + dt[d][0];
			int nx = x + dt[d][1];
			
			if (ny<0 || ny>=N || nx<0 || nx>=M) continue;
			if (visited[ny][nx] || input[ny][nx] == 0) continue;
			dfs(ny, nx);
		}
	}
	
	static void makeSet(int num) {
		for(int i=1; i<=num; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	// 크루스칼 알고리즘에서 간선 선택과정에서 사이클이 생기는 부분에 대한 코드 효율 (void -> boolean)
	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (py == px) return false;
		
		if (px < py) parent[py] = px;
		else parent[px] = py;
		return true;
	}
	
	static class Edge {
		int v1, v2, cost;
		
		Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
	}
	
}
