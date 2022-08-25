package ssafy;

import java.io.*;
import java.util.*;

public class BJ_섬의개수_4963 {
	
	static StringBuilder sb = new StringBuilder();
	static int w, h, ans;
	static int[][] input, dt = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		while (true) {
			stk = new StringTokenizer(br.readLine());
			w = Integer.parseInt(stk.nextToken());
			h = Integer.parseInt(stk.nextToken());
			if (w==0 && h==0) return;
			input = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					input[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (input[i][j] == 1 && !visited[i][j]) {
						check(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	
	static void check(int y, int x) {
		visited[y][x] = true;
		
		for (int d = 0; d < 8; d++) {
			int ny = y + dt[d][0];
			int nx = x + dt[d][1];
			
			if (nx<0 || ny<0 || ny>=h || nx>=w) continue;
			if (input[ny][nx] == 1 && !visited[ny][nx]) check(ny, nx);
		}
				
	}
}
