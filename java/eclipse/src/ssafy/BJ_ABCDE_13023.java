package ssafy;

import java.io.*;
import java.util.*;

public class BJ_ABCDE_13023 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, cnt;
	static boolean flag;
	static boolean[] visited;
	static List<Integer>[] input;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		dq = new ArrayDeque<>();
		input = new List[N];
		for (int i = 0; i < N; i++) {
			input[i] = new ArrayList<>();
		}
		
		// 친구 관계 받기
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			input[a].add(b);
			input[b].add(a);
		}
		
		for (int i = 0; i < N; i++) {
			Collections.sort(input[i]);
		}
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			if (!flag) dfs(i, 1);
			
		}
		
		if (flag) System.out.println(1);
		else System.out.println(0);
		
	}
	
	static void dfs(int i, int cnt) {
		if (flag) return;
		if (cnt == 5) {
			flag = true;
			return;
		}
		
		for(int f : input[i]) {
			if (visited[f]) continue;
			
			visited[f] = true;
			dfs(f, cnt+1);
			visited[f] = false;
		}
	}
}
