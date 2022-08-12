package ssafy;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N = 9;
	static int[][] input, sv;
	static int[] rv, cv;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		input = new int[9][9];
		rv = new int[9];
		cv = new int[9];
		sv = new int[3][3];
		
		// 입력
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				 input[i][j] = Integer.parseInt(stk.nextToken());
				 rv[i] |= (1<<input[i][j]);
				 cv[j] |= (1<<input[i][j]);
				 sv[i/3][j/3] |= (1<<input[i][j]);
			}
		}
		
		// 순회하다가 0 을 만나면 --> rv, cv, sv 를 참고해서 칸을 채운다.
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (input[i][j] == 0) dfs(i, j);
			}
		}
		
		
		// 출력
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(input[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
		return;
		
	}
	
	static void sudoku(int r, int c) {
		List<Integer> list = new ArrayList<>();
		// 들어올 수 있는 숫자 확인?
		for (int i = 1; i < 10; i++) {
			if ((rv[r] & 1<<i) == 0 && (cv[c] & 1<<i) == 0 && (sv[r/3][c/3] & 1<<i) == 0) {
				list.add(i);
			}
		}
		
		if (list.size() == 1);
		else if (list.size() > 1);
		
//				rv[r] |= 1<<i;
//				cv[c] |= 1<<i;
//				sv[r/3][c/3] |= 1<<i;
//				input[r][c] = i;
		
	}
	
	static void dfs(int r, int c) {
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i < 10; i++) {
			if ((rv[r] & 1<<i) == 0 && (cv[c] & 1<<i) == 0 && (sv[r/3][c/3] & 1<<i) == 0) {
				list.add(i);
			}
		}
		
		// 더 이상 넣을 숫자가 없으면 리턴
		if (list.size() == 0) return;
		
		for (int i : list) {
			// i 넣고 --> 다른 0 찾아서 dfs 호출? --> 리턴오면 빼고?
			check(r, c, i);
			input[r][c] = i;
			for (int j = 1; j < 10; j++) {
				 if (input[r][j] == 0) dfs(r, j);
				 if (input[j][c] == 0) dfs(j, c);
			}
			input[r][c] = 0;
			uncheck(r, c, i);
		}
		
	}
	
	static void check(int r, int c, int i) {
		rv[r] |= 1<<i;
		cv[c] |= 1<<i;
		sv[r/3][c/3] |= 1<<i;
	}
	
	static void uncheck(int r, int c, int i) {
		rv[r] ^= 1<<i;
		cv[c] ^= 1<<i;
		sv[r/3][c/3] ^= 1<<i;
	}
	
}
