package ssafy;

import java.util.*;
import java.io.*;

public class BJ_달이차오른다가자_1194 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, ry, rx, ty, tx, ans, INF=987654321;
	static int[][] dt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static char[][] input;
	static int[][][] visited;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new char[N][M];
		visited = new int[N][M][1<<7];
		
		for(int i=0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				char tmp = line[j];
				input[i][j] = tmp;
				if (tmp == '0') {
					ry = i;
					rx = j;
					input[i][j] = '.';
				} else if (tmp == '1') {
					ty = i;
					tx = j;
				}
			}
		}
		
		ans = solve();
		
		System.out.println(ans);
		
	}
	
	static int solve() {
		dq = new ArrayDeque<>();
		dq.addLast(new int[] {ry, rx, 1, 0});
		visited[ry][rx][0] = 1;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			
			for(int d=0; d<4; d++) {
				int ny = cur[0] + dt[d][0];
				int nx = cur[1] + dt[d][1];
				
				if (ny<0 || ny>=N || nx<0 || nx>=M) continue;
				
				int nt = cur[2] + 1;
				int flag = cur[3];
				char tmp = input[ny][nx];
				
				if (tmp == '1') return nt-1;
				if (tmp == '#') continue;
				else if (tmp == '.') {
					if (visited[ny][nx][flag] == 0 || visited[ny][nx][flag] > nt) {
						visited[ny][nx][flag] = nt;
						dq.addLast(new int[] {ny, nx, nt, flag});
					}
				}
				else if (tmp >= 'a' && tmp <= 'f') {
					flag |= 1<<(tmp-'a'+1);
					if (visited[ny][nx][flag] == 0 || visited[ny][nx][flag] > nt) {
						visited[ny][nx][flag] = nt;
						dq.addLast(new int[] {ny, nx, nt, flag});
					}
				}
				else if (tmp >= 'A' && tmp <= 'F') {
					if (((flag&1<<(tmp-'A'+1))!=0) && (visited[ny][nx][flag] == 0 || visited[ny][nx][flag] > nt)) {
						visited[ny][nx][flag] = nt;
						dq.addLast(new int[] {ny, nx, nt, flag});
					}
				}
			}
		}
		return -1;
	}
	
}