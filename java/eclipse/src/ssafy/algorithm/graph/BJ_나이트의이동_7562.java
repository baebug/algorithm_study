package ssafy.algorithm.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_나이트의이동_7562 {
	
	static int T, l, py, px, ty, tx;
	static int[][] dt = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	static int[][] visited;
	static Deque<Knight> dq;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer stk;
		
		for (int t = 1; t <= T; t++) {
			l = Integer.parseInt(br.readLine());
			dq = new ArrayDeque<>();
			visited = new int[l][l];
			for (int i = 0; i < l; i++) {
				Arrays.fill(visited[i], 99999);
			}
			
			stk = new StringTokenizer(br.readLine());
			py = Integer.parseInt(stk.nextToken());
			px = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			ty = Integer.parseInt(stk.nextToken());
			tx = Integer.parseInt(stk.nextToken());
			
			bfs();
			
		}
		
		System.out.print(sb);
	}
	
	static void bfs() {
		visited[py][px] = 0; 
		dq.addLast(new Knight(py, px, 0));
		
		
		while (!dq.isEmpty()) {
			Knight cur = dq.peekFirst();
			int cy = cur.y;
			int cx = cur.x;
			int cc = cur.cnt;
			if (cy == ty && cx == tx) {
				sb.append(cc).append('\n');
				return;
			}
			
			for (int d = 0; d < 8; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				int nc = cc + 1;
				
				if (ny<0 || nx<0 || ny>=l || nx>= l) continue;
				if (visited[ny][nx] > nc) visited[ny][nx] = nc;
				else continue;
				
				dq.addLast(new Knight(ny, nx, nc));
				
			}
			dq.removeFirst();
		}
		
	}
	
	static class Knight {
		int y;
		int x;
		int cnt;
		
		public Knight(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
}
