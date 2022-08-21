package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_데스나이트_16948 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, r1, r2, c1, c2;
	static int[][] dt = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
	static Deque<int[]> dq;
	static int[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], -1);
		}
		dq = new ArrayDeque<>();
		
		stk = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(stk.nextToken());
		c1 = Integer.parseInt(stk.nextToken());
		r2 = Integer.parseInt(stk.nextToken());
		c2 = Integer.parseInt(stk.nextToken());
		
		dq.addLast(new int[] {r1, c1, 0});
		visited[r1][c1] = 0;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			
			for (int d = 0; d < 6; d++) {
				int nr = cur[0] + dt[d][0];
				int nc = cur[1] + dt[d][1];
				int nt = cur[2] + 1;
				
				if (nr == r2 && nc == c2) {
					System.out.println(nt);
					return;
				}
				
				if (nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if (visited[nr][nc] == -1 || visited[nr][nc] > nt) visited[nr][nc] = nt;
				else continue;
				
				dq.addLast(new int[] {nr, nc, nt});
			}
		}
		
		System.out.println(-1);
		
	}
}
