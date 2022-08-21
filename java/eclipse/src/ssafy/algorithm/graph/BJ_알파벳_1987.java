package ssafy.algorithm.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_알파벳_1987 {
	
	static int R, C, ans;
	static char[][] input;
	static int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		input = new char[R][];
		for (int i = 0; i < R; i++) {
			input[i] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1, 0 | 1<<input[0][0]-'A');

		System.out.println(ans);
	}
	
	static void dfs(int y, int x, int cnt, int flag) {
		ans = Math.max(ans, cnt);
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dt[d][0];
			int nx = x + dt[d][1];
			if (ny<0||nx<0||ny>=R||nx>=C) continue;
			if ((flag & 1<<input[ny][nx]-'A') != 0) continue;
			
			dfs(ny, nx, cnt+1, flag | 1<<input[ny][nx]-'A');
		}
	}
}
