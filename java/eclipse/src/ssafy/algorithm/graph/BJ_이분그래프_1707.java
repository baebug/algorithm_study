package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

// 간선이 두개인 원소가 하나밖에 없으면 이분그래프 아님? --> 응 아님
// bfs 돌리는데 갔던 곳 또 만나면 아니다? visited = true 만나거나 탐색 다 끝나고 visited = false 가 있으면 "No"
public class BJ_이분그래프_1707 {
	
	static int T, V, E;		// V: 정점의 수 , E: 간선의 수
	static boolean[] visited;
	static int[] colors;
	static boolean flag;
	static List<Integer>[] list;
	static Deque<Integer> dq;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			V = Integer.parseInt(stk.nextToken());
			E = Integer.parseInt(stk.nextToken());
			
			dq = new ArrayDeque<>();
			
			list = new ArrayList[V+1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			
			flag = bfs(1);
			for (int i = 1; i <= V; i++) {
				if (!flag) break;
				if (colors[i] == 0) {
					flag = bfs(i);
				}
			}
			
			if (flag) sb.append("YES").append('\n');
			else sb.append("NO").append('\n');
		}
		
		System.out.print(sb);
	}
	
	static boolean bfs(int n) {
		int cur = -1;
		dq.clear();
		colors = new int[V+1];
		visited = new boolean[V+1];
		visited[n] = true;
		colors[n] = 1;
		dq.addLast(n);
		
		while (!dq.isEmpty()) {
			cur = dq.removeFirst();
			int color = colors[cur];
			
			for(int i : list[cur]) {
				if (visited[i]) {
					if (color == colors[i])	return false;
					else continue;
				}
				
				visited[i] = true;
				if (color == 1) colors[i] = 2;
				else colors[i] = 1;
				
				dq.addLast(i);
			}
		}
		
		for(int i : list[cur]) {
			if (colors[cur] == colors[i]) return false;
		}
		
		return true;
	}
}
