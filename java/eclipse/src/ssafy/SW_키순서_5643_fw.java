package ssafy;

import java.io.*;
import java.util.*;

// 내 키가 몇 번째인가? --> 나보다 작은 애, 나보다 큰 애 가 몇 명인지 알면 된다.
// i 와 j 의 관계를 알 수 있으면 Math.min([i][j], [j][j]) 의 값이 INF 가 아니다.
public class SW_키순서_5643_fw {
	
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, ans, INF=987654321;
	static int[][] input, dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			input = new int[N+1][N+1];
			
			for(int i=0; i<=N; i++) {
				Arrays.fill(input[i], INF);
			}
			
			for(int i=0; i<M; i++) {
				stk = new StringTokenizer(br.readLine());
				input[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())] = 0;
			}
			
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					if (i==k) continue;
					for(int j=1; j<=N; j++) {
						if (j==i || j==k) continue;
						input[i][j] = Math.min(input[i][j], input[i][k]+input[k][j]);
					}
				}
			}
			
			ans = N;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if (i==j) continue;
					if (input[i][j] != 0 && input[j][i] != 0) {
						ans--;
						break;
					}
				}
			}
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
		}
		
		System.out.print(sb);
	}
}