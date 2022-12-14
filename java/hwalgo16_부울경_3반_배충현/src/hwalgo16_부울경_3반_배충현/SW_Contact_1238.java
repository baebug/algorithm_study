package hwalgo16_부울경_3반_배충현;

import java.io.*;
import java.util.*;

public class SW_Contact_1238 {

	static StringBuilder sb = new StringBuilder();
	static int T, N, st, ans, cnt;
	static boolean[] visited;
	static List<Integer>[] child;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = 10;
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			st = Integer.parseInt(stk.nextToken());
			visited = new boolean[101];
			child = new List[101];
			for (int i = 0; i < child.length; i++) {
				child[i] = new ArrayList<>();
			}
			dq = new ArrayDeque<>();
			
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				child[Integer.parseInt(stk.nextToken())].add(Integer.parseInt(stk.nextToken()));
			}
			
			ans = cnt = 0;
			visited[st] = true;
			dq.addLast(new int[] {st, 1});
			
			while(!dq.isEmpty()) {
				int[] cur = dq.removeFirst();
				if (cur[1] > cnt) {
					ans = cur[0];
					cnt = cur[1];
				}
				else if (cur[1] == cnt) ans = Math.max(ans, cur[0]);
				
				for(int i : child[cur[0]]) {
					if (visited[i]) continue;
					visited[i] = true;
					dq.addLast(new int[] {i, cur[1]+1});
				}
			}
			
			sb.append(ans).append('\n');
			
		}
		
		System.out.print(sb);
	}

}
