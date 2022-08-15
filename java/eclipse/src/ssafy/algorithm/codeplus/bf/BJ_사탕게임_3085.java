package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

public class BJ_사탕게임_3085 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, result = Integer.MIN_VALUE;
	static char[][] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new char[N][];
		
		for (int i = 0; i < N; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		// 좌우 바꿔보기 + 먹기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				swapR(i, j);
				check();
				swapR(i, j);
			}
		}
		
		// 위아래 바꿔보기 + 먹기
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N; j++) {
				swapD(i, j);
				check();
				swapD(i, j);
			}
		}
		
		System.out.println(result);
		
	}
	
	// 본인 오른쪽이랑 swap
	static void swapR(int y, int x) {
		char tmp = input[y][x];
		input[y][x] = input[y][x+1];
		input[y][x+1] = tmp;
	}
	
	// 본인 아래랑 swap
	static void swapD(int y, int x) {
		char tmp = input[y][x];
		input[y][x] = input[y+1][x];
		input[y+1][x] = tmp;
	}
	
	static void check() {
		checkRow();
		checkCol();
	}
	
	static void checkRow() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, cnt);
			cnt = 0;
			char tmp = input[i][0];
			for (int j = 0; j < N; j++) {
				if (tmp == input[i][j]) cnt++;
				else {
					result = Math.max(result, cnt);
					tmp = input[i][j];
					cnt = 1;
				}
			}
		}
		result = Math.max(result, cnt);
	}
	
	static void checkCol() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, cnt);
			cnt = 0;
			char tmp = input[0][i];
			for (int j = 0; j < N; j++) {
				if (tmp == input[j][i]) cnt++;
				else {
					tmp = input[j][i];
					result = Math.max(result, cnt);
					cnt = 1;
				}
			}
		}
		result = Math.max(result, cnt);
	}
	
}
