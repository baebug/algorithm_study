package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_벽부수고이동하기_2206 {
	
	static int N, M, INF = Integer.MAX_VALUE;
	static int[][] input, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][][] minTable;
	static boolean[][][] visited;
	static boolean isArrive;
	static Deque<P> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		int chance = 1;				// 벽뿌 가능 횟수
		input = new int[N][M];		// 0, 0 --> N-1, M-1
		visited = new boolean[chance+1][N][M];	// 3차원으로 변경 --> 벽 뿌신 애가 간 길, 안 뿌신 애가 간 길
		isArrive = false;
		minTable = new int[chance+1][N][M];
		for (int c = 0; c <= chance ; c++) {
			for (int i = 0; i < minTable[0].length; i++) {
				Arrays.fill(minTable[c][i], INF);
			}
		}
		dq = new ArrayDeque<>();
		
		// 입력 받기
		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				int tmp = row[j] - '0';
				input[i][j] = tmp;
			}
		}
		
		visited[chance][0][0] = true;
		minTable[chance][0][0] = 1;
		dq.addLast(new P(0, 0, chance, 1));
		bfs();
		
		// 모든 경우(벽뿌신거) 에서 도착한 적이 있으면 isArrive = true 
		for (int c = 0; c <= chance; c++) {
			if (visited[c][N-1][M-1]) isArrive = true;  
		}
		
		// 도착 안했으면
		if (!isArrive) {
			System.out.println(-1);
		} else {
			// 도착했다면
			int result = Integer.MAX_VALUE;
			for (int c = 0; c <= chance; c++) {
				result = Math.min(result, minTable[c][N-1][M-1]);
			}
			System.out.println(result);
		}
		
	}
	
	static void bfs() {
		while (!dq.isEmpty()) {
			P cur = dq.peekFirst();
			int cy = cur.y;
			int cx = cur.x;
			int cc = cur.chance;
			int ct = cur.time;
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				int nc = cc;
				int nt = ct + 1;
				
				if (ny<0 || ny>=N || nx<0 || nx>=M) continue;
				if (visited[nc][ny][nx]) continue;
				if (minTable[nc][ny][nx] > nt) minTable[nc][ny][nx] = nt;
				else continue;
				if (input[ny][nx] == 1) {
					if (nc > 0)  nc--;
					else continue;
				} 
				visited[nc][ny][nx] = true;
				dq.addLast(new P(ny, nx, nc, nt));
			}
			dq.removeFirst();
		}
	}
	
	static class P {
		int y;
		int x;
		int chance;
		int time;
		
		public P() {}
		
		public P(int y, int x, int chance, int time) {
			this.y = y;
			this.x = x;
			this.chance = chance;
			this.time = time;
		}

	}
}
