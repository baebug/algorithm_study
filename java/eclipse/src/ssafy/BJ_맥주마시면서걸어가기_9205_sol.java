package ssafy;

import java.io.*;
import java.util.*;

public class BJ_맥주마시면서걸어가기_9205_sol {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N, V;
	static final int INF = 987654321;
	static int[][] input, dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			V = N+2;
			input = new int[V][2];
			dist = new int[V][V];
			
			for(int i=0; i<V; i++) {
				stk = new StringTokenizer(br.readLine());

				input[i][0] = Integer.parseInt(stk.nextToken());
				input[i][1] = Integer.parseInt(stk.nextToken());
			}
			
			// 입력 => 인접행렬
			for(int i=0; i<V; i++) {
				// 현재 따지는 i 정점의 좌표
				int vy = input[i][0];
				int vx = input[i][1];
				
				for(int j=0; j<V; j++) {
					if (i==j) continue;
					int ty = input[j][0];
					int tx = input[j][1];
					int dis = Math.abs(ty-vy) + Math.abs(tx-vx);
					
					// 중요포인트
					// dis > 50*20 => 갈 수 없다. => INF
					if (dis > 1000) dist[i][j] = INF;
					else dist[i][j] = dis;
				}
			}
			
			// 플로이드 워셜 적용
			for(int k=0; k<V; k++) {			// 경유지
				for(int i=0; i<V; i++) {		// 출발지
					if (i==k) continue;
					for(int j=0; j<V; j++) {	// 도착지
						if (j==i || j==k) continue;
						
						// i -> j vs i -> k -> j
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			// 모든 정점에서 다른 정점으로 가는 최소 비용이 dist 인접 행렬에 계산되어 있음. (갈 수 없는 구간은 INF)
			sb.append(dist[0][V-1] != 0 && dist[0][V-1] < INF ? "happy" : "sad").append('\n');
			
		}
		
		System.out.print(sb);
		
	}
}
