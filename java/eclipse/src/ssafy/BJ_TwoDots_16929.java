package ssafy;

import java.io.*;
import java.util.*;

// 사이클 --> 인접 따라가다 보면 처음 정점이 나온다.
// 사방탐색 --> 같은 색 있으면 cnt+1 (dfs)
// 자기보다 낮은 번호를 만나면 사이클
public class BJ_TwoDots_16929 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, cnt;
	static boolean hasCycle, end;
	static int[][] visited, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static char[][] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new char[N][];
		for (int i = 0; i < N; i++) input[i] = br.readLine().toCharArray();
		
		for (int i = 0; i < N; i++) {
			if (hasCycle) break;
			for (int j = 0; j < M; j++) {
				visited = new int[N][M];
				end = false;
				dfs(i, j);
				if (hasCycle) break;
			}
		}
		
		if (hasCycle) System.out.println("Yes");
		else System.out.println("No");
		
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = ++cnt;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dt[d][0];
			int nx = x + dt[d][1];
			
			if (ny<0 || nx<0 || ny>=N || nx>=M) continue;
			if (input[ny][nx] != input[y][x]) continue;
			
			if (visited[ny][nx] != 0 && visited[ny][nx] < cnt-1 && cnt > 3 && !end) {
				hasCycle = true;
				return;
			}
			
			if (visited[ny][nx] == 0) {
				dfs(ny, nx);
			}
		}
		end = true;
	}
}
