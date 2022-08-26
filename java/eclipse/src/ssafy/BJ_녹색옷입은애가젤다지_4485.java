package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_4485 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, t, INF = 919191919;
	static int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static PriorityQueue<P> pq;
	static int[][] input, dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			input = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			solve();
			
			sb.append("Problem").append(' ').append(++t).append(":").append(' ').append(dist[N-1][N-1]).append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	static void solve() {
		pq = new PriorityQueue<>();
		
		pq.offer(new P(0, 0, input[0][0]));
		
		while(!pq.isEmpty()) {
			P cur = pq.poll();
			if (cur.val > dist[cur.y][cur.x]) continue;
			else dist[cur.y][cur.x] = cur.val;
			
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dt[d][0];
				int nx = cur.x + dt[d][1];
				
				if (ny<0 || nx<0 || ny>=N || nx>=N) continue;
				if (dist[ny][nx] > cur.val + input[ny][nx]) {
					dist[ny][nx] = cur.val + input[ny][nx];
					pq.offer(new P(ny, nx, dist[ny][nx]));
				}
				
			}
		}
		
	}
	
	static class P implements Comparable<P> {
		int y, x, val;
		
		P(int y, int x, int val) {
			this.y = y;
			this.x = x;
			this.val = val;
		}
		
		@Override
		public int compareTo(P o) {
			return this.val - o.val;
		}
	}
}
