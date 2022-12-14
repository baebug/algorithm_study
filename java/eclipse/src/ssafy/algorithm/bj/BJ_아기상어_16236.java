package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_아기상어_16236 {

	static int N, M, ans, cnt, sy, sx, ssize;
	static int[][] input, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static PriorityQueue<Eatable> eq = new PriorityQueue<>();
	static Deque<int[]> dq = new ArrayDeque<>();
	static boolean[][] visited;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(stk.nextToken());
				input[i][j] = tmp;
				if (tmp == 9) {
					sy = i; sx = j; ssize = 2;
				}
			}
		}
		
		ans = 0;
		input[sy][sx] = 0;
		
		while(true) {
			find();
			
			if (eq.isEmpty()) {
				System.out.println(ans);
				return;
			}
			eat();
		}

	}
	
	static void eat() {
		Eatable cur = eq.poll();
		ans += cur.d;
		sy = cur.y; sx = cur.x;
		input[sy][sx] = 0;
		cnt++;
		if (cnt == ssize) {
			cnt = 0;
			ssize++;
		}
	}
	
	static void find() {
		eq.clear();
		dq.clear();
		visited = new boolean[N][N];
		
		visited[sy][sx] = true;
		dq.addLast(new int[] {sy, sx, 0});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cy = cur[0];
			int cx = cur[1];
			int cd = cur[2];
			if (input[cy][cx] > 0 && input[cy][cx] < ssize) eq.add(new Eatable(cy, cx, cd));
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				
				if (ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if (visited[ny][nx] || input[ny][nx] > ssize) continue;
				visited[ny][nx] = true;
				dq.addLast(new int[] {ny, nx, cd+1});
				
			}
		}
	}

	static class Eatable implements Comparable<Eatable> {
		int y, x, d;
		
		Eatable(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
		public int compareTo(Eatable o) {
			if (this.d != o.d) {
				return this.d - o.d;
			} else if (this.y != o.y) {
				return this.y - o.y;
			} return this.x - o.x;
		}
	}
}
