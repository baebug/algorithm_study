package ssafy;

import java.io.*;
import java.util.*;

public class BJ_이모티콘_14226_mo {
	
	static StringBuilder sb = new StringBuilder();
	static int S;
	static int[] visited;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		S = Integer.parseInt(br.readLine());
		visited = new int[2002];
		dq = new ArrayDeque<>();
		
		bfs();
		
	}
	
	static void bfs() {
		dq.clear();
		dq.addLast(new int[] {1, 0, 0});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cc = cur[0];
			int ct = cur[1];
			int ccp = cur[2];
			
			if (cc == S) {
				System.out.println(ct);
				return;
			}
			
			if (cc > 0) {
				if (visited[cc-1] == 0 || visited[cc-1] > ct+1) visited[cc-1] = ct+1;
				dq.addLast(new int[] {cc-1, ct+1, ccp});
			}
			
			dq.addLast(new int[] {cc, ct+1, cc});
			
			int nc = cc+ccp;
			int nt = ct+1;
			if (nc <= 2001) {
				if (visited[nc] == 0 || visited[nc] > nt) visited[nc] = nt;
				dq.addLast(new int[] {nc, nt, ccp});
			}
			
		}
	}
}
