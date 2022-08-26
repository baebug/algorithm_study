package ssafy;

import java.io.*;
import java.util.*;

// 크루스칼 -- 간선을 정렬하고 union 친다.
public class SW_최소스패닝트리_3124_kruskal {
	
	static StringBuilder sb = new StringBuilder();
	static int T, V, E, cnt;
	static long ans;
	static int[] p;
	static List<E> el;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			stk = new StringTokenizer(br.readLine());
			V = Integer.parseInt(stk.nextToken());
			E = Integer.parseInt(stk.nextToken());
			el = new ArrayList<>();	
			p = new int[V+1];
			for (int i = 0; i <= V; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < E; i++) {
				stk = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				int dist = Integer.parseInt(stk.nextToken());
				
				el.add(new E(from, to, dist));
			}
			Collections.sort(el, (e1, e2) -> e1.dist - e2.dist);
			
			ans = 0;
			cnt = 0;
			for (int i = 0; i <E; i++) {
				E cur = el.get(i);
				
				if (findset(cur.from) != findset(cur.to)) {
					ans += cur.dist;
					union(cur.from, cur.to);
					cnt++;
				}
				if (cnt == V-1) break;
			}
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	static int findset(int x) {
		if (p[x] == x) return x;
		return p[x] = findset(p[x]);
	}
	
	static void union(int x, int y) {
		int fx = findset(x);
		int fy = findset(y);
		int l = Math.max(fx, fy);
		int s = Math.min(fx, fy);
		p[s] = l;
	}
	
	static class E implements Comparable<E> {
		int from, to, dist;
		
		E(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(E o) {
			return this.dist - o.dist;
		}
	}
}
