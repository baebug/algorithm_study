package ssafy;

import java.io.*;
import java.util.*;

public class SW_벽돌깨기_5656 {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N, W, H, ans;
	static int[][] input, dt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			stk = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(stk.nextToken());
			W = Integer.parseInt(stk.nextToken());
			H = Integer.parseInt(stk.nextToken());

			// 입력받기
			input = new int[H][W];
			for(int i=0; i<H; i++) {
				stk = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					input[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			// N, demo, cnt
			solve(0, input, 0);
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
			
		}
		
		System.out.println(sb);
		
	}
	
	static void solve(int n, int[][] board, int cnt) {
		
	}
}
