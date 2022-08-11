package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_토마토_7576 {
	
	static int N, M, result;
	static int[][] input, minMap, dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] visited;
	static Deque<T> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stk.nextToken());
		N = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		minMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				minMap[i][j] = 1000001;
			}
		}
		visited = new boolean[N][M];
		
		dq = new ArrayDeque<>();
		
		// 입력 받기
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				 int tmp = Integer.parseInt(stk.nextToken());
				 input[i][j] = tmp;
				 if (tmp == -1) {
					 visited[i][j] = true;
				 } else if (tmp == 1) {
					 dq.add(new T(i, j, 0));
					 visited[i][j] = true;
					 minMap[i][j] = 0;
				 }
			}
		}
		
		result = -1;
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(result);
		
		
	}
	
	static void bfs() {
		T last = new T();
		
		while (!dq.isEmpty()) {
			T cur = dq.peekFirst();
			int cy = cur.y;
			int cx = cur.x;
			int cc = cur.cnt;
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				int nc = cc + 1;
				
				if (ny<0 || nx<0 || ny>=N || nx>=M) continue;
				if (input[ny][nx] != 0 || visited[ny][nx]) continue;
				if (minMap[ny][nx] > nc) minMap[ny][nx] = nc;
				else continue;
				
				visited[ny][nx] = true;
				dq.addLast(new T(ny, nx, nc));
			}
			last = dq.removeFirst();
		}
		result = Math.max(result, last.cnt);
	}
	
	static class T {
		int y;
		int x;
		int cnt;
		
		public T() {}
		
		public T(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
