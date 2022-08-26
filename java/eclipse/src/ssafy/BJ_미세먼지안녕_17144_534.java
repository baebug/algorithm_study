package ssafy;

import java.io.*;
import java.util.*;

public class BJ_미세먼지안녕_17144_534 {
	
	static StringBuilder sb = new StringBuilder();
	static int R, C, T, gc, ans;
	static int[][] input, demo, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		T = Integer.parseInt(stk.nextToken());
		demo = new int[R][];
		input = new int[R][C];
		for (int i = 0; i < R; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
				if (input[i][j] == -1) gc = i;	// 공청기 밑 y 값
			}
		}
		
		for (int i = 0; i < T; i++) {
			spread();
			wind();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ans += input[i][j];
			}
		}
		
		System.out.println(ans+2);
	}
	
	static void wind() {
		// 0 ~ gc-1 , gc ~ R-1
		int sy1 = 0, sy2 = gc, ey1 = gc-1, ey2 = R-1, sx = 0, ex = C-1;
		
		// 윗바람 (반시계 회전) -- 공청기 바로 위는 사라진다.
		for (int i = ey1-1; i > sy1; i--) {
			input[i][sx] = input[i-1][sx];
		}
		for (int i = sx; i < ex; i++) {
			input[sy1][i] = input[sy1][i+1];
		}
		for (int i = sy1; i < ey1; i++) {
			input[i][ex] = input[i+1][ex];
		}
		for (int i = ex; i > sx+1; i--) {
			input[ey1][i] = input[ey1][i-1];
		}
		input[ey1][sx+1] = 0;
		
		// 아랫바람 (시계 회전)
		for (int i = sy2+1; i < ey2; i++) {
			input[i][sx] = input[i+1][sx];
		}
		for (int i = sx; i < ex; i++) {
			input[ey2][i] = input[ey2][i+1];
		}
		for (int i = ey2; i > sy2; i--) {
			input[i][ex] = input[i-1][ex];
		}
		for (int i = ex; i > sx+1; i--) {
			input[sy2][i] = input[sy2][i-1];
		}
		input[sy2][sx+1] = 0;
		
		
	}
	
	static void spread() {
		copy();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (input[i][j] != 0 && input[i][j] != -1) dust(i, j);
			}
		}
	}
	
	static void dust(int y, int x) {
		int q = demo[y][x]/5;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dt[d][0];
			int nx = x + dt[d][1];
			
			if (ny<0 || nx<0 || ny>=R || nx>=C || input[ny][nx] == -1) continue;
			
			input[ny][nx] += q;
			input[y][x] -= q;
		}
	}
	
	static void copy() {
		for (int i = 0; i < R; i++) {
			demo[i] = input[i].clone();
		}
	}
	
}
