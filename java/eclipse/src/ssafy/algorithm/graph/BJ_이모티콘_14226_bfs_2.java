package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_이모티콘_14226_bfs_2 {
	
	static StringBuilder sb = new StringBuilder();
	static int S, ub;
	static Deque<int[]> dq;
	static int ans;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		S = Integer.parseInt(br.readLine());
		ub = 2*S+2;
		dq = new ArrayDeque<>();
		visited = new boolean[ub][ub];
		
		bfs();
		
		System.out.println(ans);
		
	}
	
	static void bfs() {
		// 개수, 복사 수, 시간
		dq.addLast(new int[] {1, 0, 0});
		visited[1][0] = true;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cc = cur[0];
			int cp = cur[1];
			int ct = cur[2];
			
			if (cc == S) {
				ans = ct;
				return;
			}
			
			// 복사
			if (!visited[cc][cc]) {
				dq.addLast(new int[] {cc, cc, ct+1});
				visited[cc][cc] = true;
			}
			
			// 붙여넣기
			if (cc+cp < ub && !visited[cc+cp][cp]) {
				dq.addLast(new int[] {cc+cp, cp, ct+1});
				visited[cc+cp][cp] = true;
			}
			
			// 삭제
			if (cc > 0 && !visited[cc-1][cp]) {
				dq.addLast(new int[] {cc-1, cp, ct+1});
				visited[cc-1][cp] = true;
			}
		}
	}
}
