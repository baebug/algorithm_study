package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// 항상 1열에 있고, 행을 두 칸 차지한다.
// 미세먼지는 20% 확산되고 소수점은 버린다.
// 남은 미세먼지의 양은 a - (a/5)*(방향 수)
public class BJ_미세먼지안녕_17144 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, T, ac, result;
	static int[][] input, demo, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 상 우 하 좌
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken()); 
		M = Integer.parseInt(stk.nextToken()); 
		T = Integer.parseInt(stk.nextToken());
		
		input = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
				if (input[i][j] == -1) ac = i; 
			}
		}
		
		for (int i = 0; i < T; i++) {
			routine();
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result += input[i][j];
			}
		}
		
		System.out.println(result+2);
		
	}
	
	static void routine() {
		demo = copy();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (input[i][j] != -1 && input[i][j] != 0) spread(i, j);
			}
		}
		
		cw();
		ccw();
	}
	
	static void clean() {
		// ac : 공기청정기 밑의 y 값
	}
	
	// 먼지 확산은 한번에 일어나야 하는데? --> 순차적으로 일어나면 영향받는다.
	// copy 떠서 거기 데이터로 넣어주기
	static void spread(int y, int x) {
		int dust = demo[y][x]/5;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dt[d][0];
			int nx = x + dt[d][1];
			
			if (ny<0 || nx<0 || ny>=N || nx>=M) continue;
			if (input[ny][nx] == -1) continue;
			
			input[ny][nx] += dust;
			input[y][x] -= dust;
		}
	}
	
	static void cw() {
		int sy = ac; int ey = N-1;
		int sx = 0; int ex = M-1;
		
		for (int i = sy+1; i < ey; i++) {
			input[i][sx] = input[i+1][sx];
		}
		for (int i = sx; i < ex; i++) {
			input[ey][i] = input[ey][i+1];
		}
		for (int i = ey; i > sy; i--) {
			input[i][ex] = input[i-1][ex];
		}
		for (int i = ex; i > sx+1; i--) {
			input[sy][i] = input[sy][i-1];
		}
		
		input[sy][sx+1] = 0;
	}
	
	static void ccw() {
		int sy = 0; int ey = ac-1;
		int sx = 0; int ex = M-1;
		
		for (int i = ey-1; i > sy; i--) {
			input[i][sx] = input[i-1][sx];
		}
		for (int i = sx; i < ex; i++) {
			input[sy][i] = input[sy][i+1];
		}
		for (int i = sy; i < ey; i++) {
			input[i][ex] = input[i+1][ex];
		}
		for (int i = ex; i > sx+1; i--) {
			input[ey][i] = input[ey][i-1];
		}
		
		input[ey][sx+1] = 0;
	} 
	
	static int[][] copy() {
		int[][] tmp = new int[N][];
		
		for (int i = 0; i < N; i++) {
			tmp[i] = input[i].clone();
		}
		
		return tmp;
	}
}
