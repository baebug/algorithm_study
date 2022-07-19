package ssafy.hw.step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2032 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int max = Integer.MIN_VALUE;
		int[][] dt = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr.length; x++) {
				int sum = 0;
				for (int i = 0; i < 5; i++) {
					int ny = y + dt[i][0];
					int nx = x + dt[i][1];
					
					if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					
					sum += arr[ny][nx];
				}
				max = Math.max(max, sum);
				
			}
		}
		System.out.println(max);

	}

}

