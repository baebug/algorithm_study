package algorithm_2.dp;

import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N, ans, INF=987654321;
	static int[][] input, visited, dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static PriorityQueue<int[]> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N][N];
			visited = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(visited[i], INF);
			}
			pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
			
			for(int i=0; i<N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					input[i][j] = tmp[j] - '0';
				}
			}
			
			ans = solve();
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int solve() {
		pq.offer(new int[] {0, 0, 0});
		visited[0][0] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if (cur[0] == N-1 && cur[1] == N-1) {
				return cur[2];
			}
			
			for(int d=0; d<4; d++) {
				int ny = cur[0] + dt[d][0];
				int nx = cur[1] + dt[d][1];
				
				if (ny<0 || ny>=N || nx<0 || nx>=N) continue;
				int nv = cur[2] + input[ny][nx];
				if (visited[ny][nx] < nv) continue;
				pq.offer(new int[] {ny, nx, nv});
				visited[ny][nx] = nv;
			}
		}
		
		return 0;
		
	}
	
}