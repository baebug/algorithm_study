package ssafy;

import java.io.*;
import java.util.*;

// 부분집합
// 인접행렬
// 연결 여부 => BFS
public class BJ_게리맨더링_17471_sol {
	
	static StringBuilder sb = new StringBuilder();
	static int N, min, total;
	static int[][] input;
	static boolean[] visited;	// bfs
	static boolean[] select;	// subset
	static Deque<Integer> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		// 구역의 수
		N = Integer.parseInt(br.readLine());
		input = new int[N+1][N+1];
		select = new boolean[N+1];
		min = Integer.MAX_VALUE;
		
		// 구역별 인구수
		stk = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			input[i][0] = Integer.parseInt(stk.nextToken());
			total += input[i][0];
		}
		
		// 구역별 인접 행렬
		for(int i=1; i<=N; i++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			for(int j=1; j<=n; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		subset(1);
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		
	}
	
	static void check() {
		// 1. 연결 구조 => bfs
		// 2. 적어도 한개의 구역을 포함하는가?
		
		dq.clear();
		visited = new boolean[N+1];
		
		// A
		for(int i=1; i<=N; i++) {
			if (select[i]) {
				visited[i] = true;
				dq.addLast(i);
				break;
			}
		}
		
		if (dq.isEmpty()) return;
		
		while(!dq.isEmpty()) {
			int cur = dq.removeFirst();
			
			for(int i=1; i<=N; i++) {
				int adj = input[cur][i];
				if (adj != 0 && !visited[adj] && select[adj]) {
					visited[adj] = true;
					dq.addLast(adj);
				}
			}
		}
		
		// B
		for(int i=1; i<=N; i++) {
			if (!select[i]) {
				visited[i] = true;
				dq.addLast(i);
				break;
			}
		}
		
		if (dq.isEmpty()) return;
		
		while(!dq.isEmpty()) {
			int cur = dq.removeFirst();
			
			for(int i=1; i<=N; i++) {
				int adj = input[cur][i];
				if (adj != 0 && !visited[adj] && !select[adj]) {
					visited[adj] = true;
					dq.addLast(adj);
				}
			}
		}
		
		boolean visitAll = true;
		for(int i=1; i<=N; i++) {
			if (!visited[i]) {
				visitAll = false;
				break;
			}
		}
		
		if (visitAll) {
			int cnt = 0;
			for(int i=1; i<=N; i++) {
				if(select[i]) cnt += input[i][0];
			}
			min = Math.min(min, Math.abs(total - 2*cnt));
		}
	}
	
	// select[] 에 표기를 한다. (선택 비선택)
	static void subset(int idx) {
		if (idx == N+1) {
			check();
			return;
		}
		
		select[idx] = true;
		subset(idx+1);
		select[idx] = false;
		subset(idx+1);
	}
}
