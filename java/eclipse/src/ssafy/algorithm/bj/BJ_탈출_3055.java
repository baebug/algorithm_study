package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_탈출_3055 {
	
	static int R, C, ans;
	static char[][] input;
	static boolean[][][] visited;
	static Deque<int[]> dq;
	static int[] gs;
	static List<int[]> wl;
	static int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		dq = new ArrayDeque<>();
		wl = new ArrayList<>();
		
		stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		input = new char[R][C];
		for (int i = 0; i < R; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (input[i][j] == 'S') gs = new int[] {i, j};
				else if (input[i][j] == '*') wl.add(new int[] {i, j});
			}
		}
		
		visited = new boolean[2][R][C];	// 0 은 고슴도치, 1 은 물
		
		ans = -1;
		
		bfs();
		
		if (ans == -1) System.out.print("KAKTUS");
		else System.out.print(ans);
		
	}
	
	static void bfs() {
		visited[0][gs[0]][gs[1]] = true;
		dq.addLast(new int[] {gs[0], gs[1], 0, 0});	// 고슴도치 넣기
		if (!wl.isEmpty()) {
			for(int[] ws : wl) {
				visited[1][ws[0]][ws[1]] = true;
				dq.addLast(new int[] {ws[0], ws[1], 1}); // 물 넣기
			}
		}
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			
			if (cur[2] == 1) {
				// 물의 이동
				for (int d = 0; d < 4; d++) {
					int ny = cur[0] + dt[d][0];
					int nx = cur[1] + dt[d][1];
					
					if (ny<0 || nx<0 || ny>=R || nx>=C) continue;
					if (visited[1][ny][nx] || input[ny][nx] == 'X' || input[ny][nx] == 'D') continue;
					
					visited[1][ny][nx] = true;
					input[ny][nx] = '*';
					dq.addLast(new int[] {ny, nx, 1});
				}
			}
			else if (cur[2] == 0) {
				// 고슴도치의 이동 -- 고슴도치가 물에 먹혔으면 넘긴다.
				if (input[cur[0]][cur[1]] == '*') continue;
				
				for (int d = 0; d < 4; d++) {
					int ny = cur[0] + dt[d][0];
					int nx = cur[1] + dt[d][1];
					
					if (ny<0 || nx<0 || ny>=R || nx>=C) continue;
					if (visited[0][ny][nx] || input[ny][nx] == 'X' || input[ny][nx] == '*') continue;
					if (input[ny][nx] == 'D') {
						ans = cur[3]+1;
						return;
					}
					
					visited[0][ny][nx] = true;
					dq.addLast(new int[] {ny, nx, 0, cur[3]+1});
				}
			}
		}
	}

}
