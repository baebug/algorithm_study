package ssafy;

import java.io.*;
import java.util.*;

// 겹치기도 된다? 근데 겹치면 바로 -1 리턴
public class BJ_두동전_16197 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, ans;
	static boolean arrived;
	static int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 상우하좌
	static char[][] input;
	static List<int[]> coins; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new char[N][M];
		coins = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				input[i][j] = tmp[j];
				if (input[i][j] == 'o') coins.add(new int[] {i, j});
			}
		}
		ans = 11;
		solve(coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1], 1);

		if (ans==11) ans = -1;
		System.out.println(ans);
	}
	
	// 동전 두개로 델타?
	static void solve(int cy1, int cx1, int cy2, int cx2, int cnt) {
		if (cnt > 10) {
			return;
		}
		
		for (int d = 0; d < dt.length; d++) {
			int ny1 = cy1 + dt[d][0];
			int nx1 = cx1 + dt[d][1];
			int ny2 = cy2 + dt[d][0];
			int nx2 = cx2 + dt[d][1];
			boolean flag1 = false, flag2 = false;
			if (ny1<0 || nx1<0 || ny1>=N || nx1>=M) flag1 = true;
			if (ny2<0 || nx2<0 || ny2>=N || nx2>=M) flag2 = true;
			
			if (flag1 && flag2) {
				continue;
			}
			else if (flag1 || flag2) {
				ans = Math.min(ans, cnt);
				continue;
			}
			
			if (input[ny1][nx1] == '#') {
				ny1 = cy1; nx1 = cx1;
			}
			if (input[ny2][nx2] == '#') {
				ny2 = cy2; nx2 = cx2;
			}
			solve(ny1, nx1, ny2, nx2, cnt+1);
		}
	}
}
