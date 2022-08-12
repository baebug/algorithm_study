package ssafy;

import java.io.*;
import java.util.*;

// 찾아다니면서 0이 몇개 있는지 판단 --> 한개 있으면 55 - sum. 반복.
public class BJ_스도쿠_2580_fail {
	
	static int N = 9;
	static int[][] input;
	static int[] rowZ, colZ;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		input = new int[9][9];
		rowZ = new int[9];	// 몇 번째 행에 몇 개의 0이 있는지
		colZ = new int[9];	// 몇 번째 열에 몇 개의 0이 있는지
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				 int tmp = Integer.parseInt(stk.nextToken());
				 input[i][j] = tmp;
				 if (tmp == 0) {
					 rowZ[i]++; colZ[j]++;
				 }
			}
		}
		
		while(!isFull()) {
			for (int i = 0; i < 9; i++) if (rowZ[i] == 1) fillRow(i);
			for (int i = 0; i < 9; i++) if (colZ[i] == 1) fillCol(i);
			for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) fillRec(i, j);
			
			for (int i = 0; i < 9; i++) if (rowZ[i] == 2) fillRandRow(i);
//			for (int i = 0; i < 9; i++) if (colZ[i] == 2) fillRandCol(i);
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(input[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
		return;
		
	}
	
	static boolean isFull() {
		for (int i = 0; i < 9; i++) {
			if (rowZ[i] != 0 || colZ[i] != 0) return false; 
		}
		return true;
	}
	
	static void fillRec(int i, int j) {
		int sy = 3*i, sx = 3*j;
		int cnt = 0;
		int sum = 0; 
		int ty = -1, tx = -1;
		
		for (int y = sy; y < sy+3; y++) {
			for (int x = sx; x < sx+3; x++) {
				if (input[y][x] == 0) {
					cnt++;
					if (cnt == 2) break;
					ty = y;
					tx = x;
				}
				sum += input[y][x];
			}
		}
		
		if (cnt == 1) {
			input[ty][tx] = 45 - sum;
			rowZ[ty]--;
			colZ[tx]--;
		}
		return;
	}
	
	static void fillRow(int r) {
		int tmp = 0;
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			if (input[r][i] == 0) tmp = i;
			sum += input[r][i];
		}
		
		input[r][tmp] = 45 - sum;
		rowZ[r]--;
		colZ[tmp]--;
		return;
	}
	
	static void fillCol(int c) {
		int tmp = 0;
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			if (input[i][c] == 0) tmp = i;
			sum += input[i][c];
		}
		
		input[tmp][c] = 45 - sum;
		colZ[c]--;
		rowZ[tmp]--;
		return;
	}
	
	static void fillRandRow(int r) {
		int tmp = -1;
		boolean[] check = new boolean[1000];
		for (int i = 0; i < 9; i++) {
			if (input[r][i] == 0) tmp = i;	// 제일 마지막 0 이 있는 위치 tmp
			check[input[r][i]] = true;
		}
		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				input[r][tmp] = i;			// tmp 에 아직 안들어간 i 를 넣음
				return;
			}
		}
	}
	
	static void fillRandCol(int c) {
		int tmp = -1;
		boolean[] check = new boolean[1000];
		for (int i = 0; i < 9; i++) {
			if (input[i][c] == 0) tmp = i;	// 제일 마지막 0 이 있는 위치 tmp
			check[input[i][c]] = true;
		}
		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				input[tmp][c] = i;			// tmp 에 아직 안들어간 i 를 넣음
				return;
			}
		}
	}
}
