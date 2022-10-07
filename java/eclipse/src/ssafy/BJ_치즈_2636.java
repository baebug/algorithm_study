package ssafy;

import java.util.*;
import java.io.*;

public class BJ_치즈_2636 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, cnt, ans;
	static int[][] input, dt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static boolean[][] visited;
	static Deque<int[]> dq;
	static List<int[]> sl;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new int[N][M];

		
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
				if (input[i][j] == 1) cnt++;
			}
		}
		
		while (true) {
			solve();
			if (cnt > sl.size()) {
				cnt -= sl.size();
				ans++;
			} else {
				System.out.println(ans+1);
				System.out.println(cnt);
				return;
			}
		}
		
	}
	
	static void solve() {
		sl = new ArrayList<>();
		dq = new ArrayDeque<>();
		visited = new boolean[N][M];
		
		dq.addLast(new int[] {0, 0});
		visited[0][0] = true;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			
			for(int d=0; d<4; d++) {
				int ny = cur[0] + dt[d][0];
				int nx = cur[1] + dt[d][1];
				
				if (ny<0 || ny>=N || nx<0 || nx>=M || visited[ny][nx]) continue;
				if (input[ny][nx] == 0) {
					dq.addLast(new int[] {ny, nx});
				} else if (input[ny][nx] == 1) {
					sl.add(new int[] {ny, nx});
				}
				visited[ny][nx] = true;
			}
		}
		
		for(int[] s : sl) {
			input[s[0]][s[1]] = 0;
		}
	}
	
}