package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_파리퇴치_2001 {

	static int T, N, M;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + t + " " + catchFly(M));
			
		}
	}
	
	static int catchFly(int m) {
		
		int max = 0;
		
		for (int i = 0; i < N - m + 1; i++) {
			for (int j = 0; j < N - m + 1; j++) {
				int sum = 0;
				for (int k1 = 0; k1 < m; k1++) {
					for (int k2 = 0; k2 < m; k2++) {
						sum += arr[i+k1][j+k2];
					}
				}
				max = Math.max(max, sum);
			}
		}
		
		return max;
	}

}
