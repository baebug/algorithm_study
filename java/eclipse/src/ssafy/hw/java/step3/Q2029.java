package ssafy.hw.step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2029 {

	public static void main(String[] args) throws Exception {
		int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr.length; x++) {
				
				if (arr[y][x] == 1) {
					for (int d = 0; d < 4; d++) {
						int cnt = 1;
						int ny = y;
						int nx = x;
						
						while (true) {
							ny += dt[d][0];
							nx += dt[d][1];
							
							if (ny < 0 || nx < 0 || ny >= N || nx >= N) break;
							
							if (arr[ny][nx] == 1) {
								max = Math.max(max, cnt);
								break;
							} else {
								cnt++;
							}
						}
					}
				}
			}
		}
		System.out.println(max);

	}

}
