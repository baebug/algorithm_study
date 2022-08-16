package ssafy.algorithm.recursion;

import java.io.*;
import java.util.*;

public class SW_요리사_4012 {

	static int T;
	static int N, M, result;
	static int[][] input;
	static int[] foodA, foodB;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			
			N = Integer.parseInt(br.readLine());
			input = new int[N+1][N+1];
			M = N/2;
			foodA = new int[M];
			foodB = new int[M];
			selected = new boolean[N+1];
			
			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int tmp = Integer.parseInt(stk.nextToken());
					if (i >= j) input[j][i] += tmp;
					else input[i][j] += tmp;
				}
			}
			
			// 식재료 반띵
			result = Integer.MAX_VALUE;
			choice(1, 0);
			
			sb.append(result).append('\n');
			
		}
		System.out.print(sb);
		
	}
	
	static int calc(int[] foods) {
		int sum = 0;
		for (int i = 0; i < M-1; i++) {
			for (int j = i+1; j < M; j++) {
				sum += input[foods[i]][foods[j]];
			}
		}
		
		return sum;
	}
	
	static void choice(int start, int cnt) {
		if (cnt == M) {
			int idx = 0;
			for (int i = 1; i <= N; i++) {
				if (!selected[i]) foodB[idx++] = i;
			}
			result = Math.min(result, Math.abs(calc(foodA) - calc(foodB)));
			return;
		}
		
		for (int i = start; i <= N; i++) {
			foodA[cnt] = i;
			selected[i] = true;
			choice(i+1, cnt+1);
			selected[i] = false;
		}
	}

}
