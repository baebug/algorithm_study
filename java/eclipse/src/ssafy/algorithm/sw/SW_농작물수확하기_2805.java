package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_농작물수확하기_2805 {

	static int T, N;
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			int center = N / 2;
			int sum = 0;
			
			for (int i = 0; i < N; i++) {
				int tmp = Math.abs(center - i);
				for (int j = tmp; j < N-tmp; j++) {
					sum += arr[i][j];
				}
			}
			
			System.out.printf("#%d %d%n", t, sum);
		}

	}

}
