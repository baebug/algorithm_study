package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// 무지성 벽 세우고 bfs 돌려보기
// 벽 3개 조합을 어떻게 하지?
public class BJ_연구소_14502 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, result = Integer.MIN_VALUE;
	static int[][] input, demo, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌
	static boolean[][] visited;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		solve(0, 0);
		
		System.out.println(result);
		
	}
	
	static void solve(int sty, int cnt) {
		if (cnt == 3) {
			// bfs
			infect();
			int safe = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (demo[i][j] == 0) safe++;
				}
			}
			// max 값
			result = Math.max(result, safe);
			return;
		}
		
		for (int i = sty; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (input[i][j] != 0) continue;
				
				input[i][j] = 1;
				solve(i, cnt+1);
				input[i][j] = 0;
			}
		}
	}
	static void bfs(int y, int x) {
		dq.clear();
		visited[y][x] = true;
		dq.addLast(new int[] {y, x});
		
		while (!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cy = cur[0];
			int cx = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				
				if (nx<0 || ny<0 || nx>=M || ny>=N) continue;
				if (visited[ny][nx]) continue;
				if (demo[ny][nx] == 1 || demo[ny][nx] == 2) continue;
				
				visited[ny][nx] = true;
				demo[ny][nx] = 2;
				dq.addLast(new int[] {ny, nx});
			}
		}
	}
	
	static void infect() {
		demo = copy();
		visited = new boolean[N][M];
		// input 을 카피 받아오기
		// 순회하면서 2 를 만나면 전염시키기 (visited)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (demo[i][j] == 2 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		// 끝나면 solve 에서 순회돌면서 안전영역 세고 max
	}
	
	static int[][] copy() {
		int[][] tmp = new int[N][];
		
		for (int i = 0; i < N; i++) {
			tmp[i] = input[i].clone();
		}
		
		return tmp;
	}
}
