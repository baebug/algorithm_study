package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class SW_작업순서_1267_bfs {
	
	static StringBuilder sb = new StringBuilder();
	static int T, V, E;
	static List<Integer>[] adj;
	static int[] preCnt;
	static boolean[] visited, checked;
	static Deque<Integer> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = 10;
		dq = new ArrayDeque<>();
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			
			stk = new StringTokenizer(br.readLine());
			V = Integer.parseInt(stk.nextToken());
			E = Integer.parseInt(stk.nextToken());
			adj = new List[V+1];
			for (int i = 0; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			preCnt = new int[V+1];
			visited = new boolean[V+1];
			checked = new boolean[V+1];
			
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				
				adj[from].add(to);
				preCnt[to]++;
			}
			
			while(true) {
				// 0 인 애들 담기
				for (int i = 1; i <= V; i++) {
					if (!checked[i] && preCnt[i] == 0) {
						checked[i] = true;
						dq.addLast(i);
					}
				}
				
				if (dq.isEmpty()) break;
				
				// 0인 애들을 시행 --> sb 에 넣고 후행 애들 까기
				while(!dq.isEmpty()) {
					int cur = dq.removeFirst();
					sb.append(cur).append(' ');
					
					for(int c : adj[cur]) {
						preCnt[c]--;
					}
				}
				
			}
			
			sb.append('\n');
		}
		
		System.out.println(sb);
		
	}
}
