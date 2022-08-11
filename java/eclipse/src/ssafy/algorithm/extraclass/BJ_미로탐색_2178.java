package ssafy.algorithm.extraclass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_미로탐색_2178 {

	static int N, M;
	static int[][] input, visited, dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Deque<P> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		visited = new int[N][M];
		
		dq = new ArrayDeque<>();
		
		// 입력 받기
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				input[i][j] = tmp[j] - '0';
			}
		}
		
		visited[0][0] = 1;
		dq.addLast(new P(0, 0, 1));
		bfs();
		System.out.println(visited[N-1][M-1]);
		
	}
	
	static void bfs() {
		
		while (!dq.isEmpty()) {
			P cur = dq.peekFirst();
			int cy = cur.y;
			int cx = cur.x;
			int ct = cur.time;
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				int nt = ct + 1;
				
				if (ny<0 || nx<0 || ny>=N || nx>=M) continue;
				if (input[ny][nx] == 0) continue;
				if (visited[ny][nx] == 0) visited[ny][nx] = nt;
				else if (visited[ny][nx] > nt) visited[ny][nx] = nt;
				else continue;
				
				dq.addLast(new P(ny, nx, nt));
			}
			dq.removeFirst();
		}
	}
	
	static class P {
		int y;
		int x;
		int time;
		
		public P(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}

}
