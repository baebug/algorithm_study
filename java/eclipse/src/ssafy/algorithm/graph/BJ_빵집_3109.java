package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_빵집_3109 {
	
	static StringBuilder sb = new StringBuilder();
	static int R, C, ans, flag;
	static char[][] input;
	static boolean[][] visited;
	static boolean isArrive;
	static int[][] dt = {{-1, 1}, {0, 1}, {1, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		
		input = new char[R][];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			isArrive = false;
			visited[i][0] = true;
			dfs(i, 0);
		}
		
		System.out.println(ans);
		
	}
	
	static void dfs(int row, int col) {
		if (isArrive) return;
		if (col == C-1) {
			isArrive = true;
			ans++;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			int ny = row + dt[d][0];
			int nx = col + dt[d][1];
			if (nx<0 || ny<0 || nx>=C || ny>=R) continue;
			if (visited[ny][nx] || input[ny][nx] == 'x') continue;
			
			visited[ny][nx] = true;
			dfs(ny, nx);
			if (isArrive) break;
		}
	}
}
