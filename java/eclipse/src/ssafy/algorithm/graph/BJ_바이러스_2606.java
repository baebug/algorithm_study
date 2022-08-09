package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_바이러스_2606 {

	static int N, M, cnt;
	static boolean[] visited;
	static List<Integer>[] child;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];

		// 간선 정보를 저장할 리스트배열
		child = new ArrayList[N+1];		// 0번 인덱스 더미
		for (int i = 0; i < child.length; i++) {
			child[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			child[a].add(b);
			child[b].add(a);
		}
		
		// 우선순위 없으므로 정렬 안해도 된다.
		
		// 1번 컴퓨터에서 출발
		cnt = 0;
		visited[1] = true;
		dfs(1);
		
		System.out.println(cnt);
		
	}	
	
	static void dfs(int idx) {
		boolean flag = true;
		for (int i : child[idx]) {
			if (!visited[i]) flag = false;
		}
		if (flag) return;
		
		for (int i : child[idx]) {
			if (visited[i]) continue;
			
			visited[i] = true;
			cnt++;
			dfs(i);
		}
	}
}
