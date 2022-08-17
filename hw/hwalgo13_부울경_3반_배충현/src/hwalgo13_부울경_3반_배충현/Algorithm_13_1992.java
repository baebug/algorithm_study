package hwalgo13_부울경_3반_배충현;

import java.io.*;
import java.util.*;

public class Algorithm_13_1992 {
		
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				input[i][j] = tmp[j] - '0';
			}
		}
		
		solve(0, 0, N);
		
		System.out.println(sb);
	}
	
	static void solve(int sy, int sx, int n) {
		int result = check(sy, sx, n);
		if (result == 1) {
			sb.append(1);
			return;
		} else if (result == 0) {
			sb.append(0);
			return;
		}
		
		sb.append('(');
		solve(sy, sx, n/2);
		solve(sy, sx+n/2, n/2);
		solve(sy+n/2, sx, n/2);
		solve(sy+n/2, sx+n/2, n/2);
		sb.append(')');
		
	}
	
	static int check(int sy, int sx, int n) {
		boolean flag0, flag1;
		flag0 = flag1 = true;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[sy+i][sx+j] == 0) flag1 = false;
				if (input[sy+i][sx+j] == 1) flag0 = false;
			}
		}
		
		if (flag1) return 1;
		else if (flag0) return 0;
		return -1;
	}
	
}
