package ssafy.algorithm.incomplete;

import java.io.*;
import java.util.*;

// 직사각형 보드에 빨/파 구슬 하나씩 넣고 빨간 구슬을 빼낸다.
// 왼 오 위 아래로 기울이기
// 구슬은 무조건 끝까지 간다.
// 10번 이하로 빼낼 수 없으면 -1 출력
// 가는 길에 O 가 있으면 탈출. 동시에 빠져도 실패 : -1
public class BJ_구슬탈출2_13460 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, result;
	static int[] R, B, G;
	static char[][] board;
	static int[][] dt = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상 하 좌 우
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		board = new char[N][];
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		// 빨간공, 파란공 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'R') R = new int[] {i, j};
				else if (board[i][j] == 'B') B = new int[] {i, j};
				else if (board[i][j] == 'O') G = new int[] {i, j};
			}
		}
		
		solve(0);
		
		if (flag) System.out.println(result);
		else System.out.println(-1);
		
	}
	
	static void solve(int cnt) {
		if (cnt > 10) return;
		if (R[0] == G[0] && R[1] == G[1]) {
			if (B[0] == G[0] && B[1] == G[1]) {
				return;
			}
			flag = true;
			result = cnt;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			go(d);
			solve(cnt+1);
		}
	}
	
	static void go(int d) {	// d 상하좌우
		// 기본적으로 빨간색을 먼저 보낼건데 파란색이 먼저 움직여야 하는 경우 고려
		if ((d==0 && B[0] < R[0]) || (d==1 && B[0] > R[0]) || (d==2 && B[1] < R[1]) || (d==3 && B[1] > R[1])) {
			B = move(B, d);
			R = move(R, d);
		} else {
			R = move(R, d);
			B = move(B, d);
		}
	}
	
	// d 방향으로 기울이고 도착 좌표 반환하는 메소드, 구멍에 도착하면 구멍의 좌표를 출력한다.
	// 현재 좌표는 벽이 아니다.
	static int[] move(int[] ball, int d) {
		int y = ball[0];
		int x = ball[1];
		int cy = ball[0];
		int cx = ball[1];
		
		while (true) {
			int ny = cy + dt[d][0];
			int nx = cx + dt[d][1];
			
			// 어차피 벽에 막히기때문에 arrayIndex 벗어나는 체크 안해도 됨
			if (board[ny][nx] == 'O') return new int[] {ny, nx};
			if (board[ny][nx] == '#' || board[ny][nx] == 'R' || board[ny][nx] == 'B') {
				char tmp = board[y][x];
				board[y][x] = '.';
				board[cy][cx] = tmp;
				return new int[] {cy, cx};
			}
			
			cy = ny;
			cx = nx;
		}
	}
	
	static char[][] copy() {
		char[][] tmp = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			tmp[i] = board[i].clone();
		}
		
		return tmp;
	}

}
