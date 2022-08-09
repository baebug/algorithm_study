package ssafy.algorithm.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_알고리즘수업_깊이우선탐색2_24480 {

	static int N, M, R, idx;
	static int[] node, order;		// 정점 집합
	static int[][] child;	// 간선 집합
	static Map<Integer, List<Integer>> map;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		visited = new boolean[N+1];	// index 0 : dummy
		order = new int[N+1];
		map = new HashMap<>();
		
		// 무방향그래프이므로 간선의 정보를 받으면 양쪽에 방문할 수 있는 노드를 넣어준다.
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			List<Integer> aMap = map.getOrDefault(a, new ArrayList<>());
			aMap.add(b);
			map.put(a, aMap);
			
			List<Integer> bMap = map.getOrDefault(b, new ArrayList<>());
			bMap.add(a);
			map.put(b, bMap);
		}
		
		// 정점의 집합 1 ~ N
		node = new int[N];
		for (int i = 0; i < N; i++) {
			node[i] = i;
		}
		
		// 간선의 집합 (map 에 들어있는거 정렬해서 넣기)
		child = new int[N+1][];
		for (int i = 0; i < N+1; i++) {
			List<Integer> tl = map.getOrDefault(i, new ArrayList<>());
			Collections.sort(tl, (i1, i2) -> i2 - i1);
			int[] ta = tl.stream().mapToInt(in -> in).toArray();
			child[i] = ta;
		}
		
		idx = 1;
		dfs(R);
		
		// R 에서 각 노드를 방문하는 순서를 출력, 방문할 수 없는 경우 0을 출력한다. 배열과 idx 를 들고가면서 찍어준다.
		for (int i = 1; i < order.length; i++) {
			sb.append(order[i]).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int n) {
		
		order[n] = idx++;
		visited[n] = true;
		for (int c : child[n]) {
			if (visited[c]) continue;
			
			visited[c] = true;
			dfs(c);
			
		}
	}
	
}
