package ssafy;

import java.io.*;
import java.util.*;

public class BJ_맥주마시면서걸어가기_9205_fw {
	static StringBuilder sb = new StringBuilder();
	static int T, N, V, INF=987654321;
	static int[][] input, dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			V = N+2;
			input = new int[V][];
			for(int i=0; i<V; i++) {
				stk = new StringTokenizer(br.readLine());
				input[i] = new int[] {Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
			}
			
			dist = new int[V][V];
			for(int i=0; i<V; i++) {
				for(int j=0; j<V; j++) {
					if (i==j) continue;
					int d = getDist(input[i], input[j]);
					if (d > 1000) dist[i][j] = INF;
					else dist[i][j] = d;
				}
			}
			
			for(int k=0; k<V; k++) {
				for(int i=0; i<V; i++) {
					if (i==k) continue;
					for(int j=0; j<V; j++) {
						if (j==i || j==k) continue;
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			
			sb.append(dist[0][V-1] == INF ? "sad" : "happy").append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static int getDist(int[] p1, int[] p2) {
		return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
	}
}