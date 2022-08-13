package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

public class BJ_테트로미노_14500 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, result = Integer.MIN_VALUE;
	static int[][] input;
	
	static int[][][] dt = {
			{{0, 1}, {0, 2}, {0, 3}}, // 가로 네칸
			{{1, 0}, {2, 0}, {3, 0}}, // 세로 네칸
			{{1, 0}, {1, 1}, {0, 1}}, // 네모
			{{1, 0}, {2, 0}, {2, 1}}, // L
			{{1, 0}, {2, 0}, {2, -1}}, // L 대칭
			{{1, 0}, {0, 1}, {0, 2}}, // L 90도
			{{1, 0}, {0, -1}, {0, -2}}, // L 90도 대칭
			{{0, -1}, {1, 0}, {2, 0}}, // L 180도
			{{0, 1}, {1, 0}, {2, 0}}, // L 180도 대칭
			{{0, 1}, {0, 2}, {-1, 2}}, // L 270도
			{{0, -1}, {0, -2}, {-1, -2}}, // L 270도 대칭
			{{1, 0}, {1, 1}, {2, 1}}, // 번개
			{{1, 0}, {1, -1}, {2, -1}}, // 번개 대칭
			{{0, 1}, {1, 0}, {1, -1}}, // 번개 90도
			{{0, -1}, {1, 0}, {1, 1}}, // 번개 90도 대칭
			{{-1, 0}, {0, 1}, {0, -1}}, // ㅗ
			{{1, 0}, {2, 0}, {1, 1}}, // ㅏ
			{{1, 0}, {2, 0}, {1, -1}}, // ㅓ
			{{0, -1}, {1, 0}, {0, 1}} // ㅜ
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		input = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// for 문 돌리면서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				solve(i, j);
			}
		}
		
		System.out.println(result);
		
	}
	
	static void solve(int y, int x) {
		for (int i = 0; i < dt.length; i++) {
			int sum = input[y][x];
			for (int d = 0; d < dt[i].length; d++) {
				int ny = y + dt[i][d][0];
				int nx = x + dt[i][d][1];
				
				if (nx<0 || ny<0 || nx>=M || ny>=N) break;
				
				sum += input[ny][nx];
			}
			result = Math.max(result, sum);
		}
	}
	
}
