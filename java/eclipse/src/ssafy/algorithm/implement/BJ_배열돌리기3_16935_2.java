package ssafy.algorithm.implement;

import java.io.*;
import java.util.*;

public class BJ_배열돌리기3_16935_2 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, R, n, m;	// N, M 은 짝수
	static int[][] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		n = N-1;
		m = M-1;
		R = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			
			rotate(Integer.parseInt(stk.nextToken()));
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(input[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void rotate6() {
		int[][] tmp = new int[N][M];
		int nn = N/2;
		int mm = M/2;
		
		// 1번이 4번으로
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < mm; j++) {
				tmp[i+nn][j] = input[i][j];
			}
		}
		// 4 --> 3
		for (int i = nn; i < N; i++) {
			for (int j = 0; j < mm; j++) {
				tmp[i][j+mm] = input[i][j];
			}
		}
		// 3 --> 2
		for (int i = nn; i < N; i++) {
			for (int j = mm; j < M; j++) {
				tmp[i-nn][j] = input[i][j];
			}
		}
		// 2 --> 1
		for (int i = 0; i < nn; i++) {
			for (int j = mm; j < M; j++) {
				tmp[i][j-mm] = input[i][j];
			}
		}
		input = tmp;
	}
	
	static void rotate5() {
		int[][] tmp = new int[N][M];
		int nn = N/2;
		int mm = M/2;
		
		// 1번이 2번으로
		for (int i = 0; i < nn; i++) {
			for (int j = 0; j < mm; j++) {
				tmp[i][mm+j] = input[i][j];
			}
		}
		// 2번이 3번으로
		for (int i = 0; i < nn; i++) {
			for (int j = mm; j < M; j++) {
				tmp[nn+i][j] = input[i][j];
			}
		}
		
		// 3번이 4번으로
		for (int i = nn; i < N; i++) {
			for (int j = mm; j < M; j++) {
				tmp[i][j-mm] = input[i][j];
			}
		}
		// 4번이 1번으로
		for (int i = nn; i < N; i++) {
			for (int j = 0; j < mm; j++) {
				tmp[i-nn][j] = input[i][j];
			}
		}
		input = tmp;
	}
	
	static void rotate4() {
		int[][] tmp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = input[j][m-i];
			}
		}
		input = tmp;
	}
	
	static void rotate3() {
		int[][] tmp = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = input[n-j][i];
			}
		}
		
		input = tmp;
	}
	
	static void rotate2() {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][m-j]= input[i][j];
			}
		}
		input = tmp;
	}
	
	static void rotate1() {
		
		for (int i = 0; i < N/2; i++) {
			int[] tmp = input[i];
			input[i] = input[n-i];
			input[n-i] = tmp;
		}
	}
	
	static void rotate(int command) {
		switch (command) {
			case 1:
				rotate1();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				break;
			case 4:
				rotate4();
				break;
			case 5:
				rotate5();
				break;
			case 6:
				rotate6();
				break;
		}
		N = input.length;
		M = input[0].length;
		n = N-1; m = M-1;
	}
}
