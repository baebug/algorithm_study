package ssafy.algorithm.implement;

import java.io.*;
import java.util.*;

public class BJ_배열돌리기1_16926_2 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, R;
	static int[][] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for (int i = 0; i < R; i++) {
			rotate(0, 0, N-1, M-1);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(input[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	// 시작점, 끝점 (포함)
	static void rotate(int sy, int sx, int ey, int ex) {
		if (ey-sy < 1 || ex-sx < 1) return;
		
		int tmp = input[sy][sx];
		
		// 첫 행 왼쪽으로 땡기기
		for (int i = sx; i < ex; i++) {
			input[sy][i] = input[sy][i+1];
		}
		// 끝열 위로 땡기기
		for (int i = sy; i < ey; i++) {
			input[i][ex] = input[i+1][ex];
		}
		// 밑행 오른쪽으로 땡기기
		for (int i = ex; i > sx; i--) {
			input[ey][i] = input[ey][i-1];
		}
		// 첫열 아래로 내리기
		for (int i = ey; i > sy; i--) {
			input[i][sx] = input[i-1][sx];
		}
		input[sy+1][sx] = tmp;
		
		rotate(sy+1, sx+1, ey-1, ex-1);
	}
}
