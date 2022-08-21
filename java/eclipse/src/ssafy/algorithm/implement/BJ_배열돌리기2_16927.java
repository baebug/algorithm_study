package ssafy.algorithm.implement;

import java.io.*;
import java.util.*;

public class BJ_배열돌리기2_16927 {
	
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
		
		int sx = 0, sy = 0, ey = N-1, ex = M-1;
		while(true) {
			int mod = R % (((ey-sy) + (ex-sx)) * 2);
			rotate(sy, sx, ey, ex, mod);
			sx += 1; sy+=1; ey-=1; ex-=1;
			if (ey-sy<1 || ex-sx<1) break;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(input[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	// 시작점, 끝점 (포함), 몇 회 돌릴 것인가?
	static void rotate(int sy, int sx, int ey, int ex, int r) {
		for (int k = 0; k < r; k++) {
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
		}
	}
}
