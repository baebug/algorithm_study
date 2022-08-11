package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_토마토3D_7569 {
	
	static int M, N, H, result;
	static int[][][] input, minTable;
	static int[][] dt = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
	static boolean[][][] visited;
	static Deque<T> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stk.nextToken());
		N = Integer.parseInt(stk.nextToken());
		H = Integer.parseInt(stk.nextToken());
		input = new int[H][N][M];
		visited = new boolean[H][N][M];
		minTable = new int[H][N][M];
		dq = new ArrayDeque<>();
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				Arrays.fill(minTable[k][i], 1000001);
			}
		}
		
		// 입력 받기
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int tmp = Integer.parseInt(stk.nextToken());
					input[k][i][j] = tmp;
					if (tmp == -1) visited[k][i][j] = true;
					else if (tmp == 1) {
						visited[k][i][j] = true;
						minTable[k][i][j] = 0;
						dq.addLast(new T(k, i, j, 0));
					}
				}
			}
		}
		
		result = -1;
		
		bfs();
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[k][i][j]) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	static void bfs() {
		T last = new T();
		while (!dq.isEmpty()) {
			T cur = dq.peekFirst();
			int cz = cur.z;
			int cy = cur.y;
			int cx = cur.x;
			int cc = cur.cnt;
			
			for (int d = 0; d < 6; d++) {
				int nz = cz + dt[d][0];
				int ny = cy + dt[d][1];
				int nx = cx + dt[d][2];
				int nc = cc + 1;
				
				if (nz<0 || nz>=H || ny<0 || ny>=N || nx<0 || nx>=M) continue;
				if (visited[nz][ny][nx]) continue;
				if (minTable[nz][ny][nx] > nc) minTable[nz][ny][nx] = nc;
				else continue;
				
				visited[nz][ny][nx] = true;
				dq.addLast(new T(nz, ny, nx, nc));
			}
			last = dq.removeFirst();
		}
		result = Math.max(last.cnt, result);
	}
	
	static class T {
		int z;
		int y;
		int x;
		int cnt;
		
		public T() {}
		
		public T(int z, int y, int x, int cnt) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
