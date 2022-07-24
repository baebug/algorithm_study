package ssafy.algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaterStrider2 {

	static int T, ans, N, m;
	static int[][] arr, dt;
	
		
	public static void main(String[] args) throws Exception {
		
		dt = new int[][] {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			ans = 0;
			
			int x, y, d;
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				
				int ny = y;
				int nx = x;
				
				for (int k = 3; k > 0; k--) {
					ny += k * dt[d][0];
					nx += k * dt[d][1];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					
					if (arr[ny][nx] == 1) break;
					
					if (k == 1) {
						arr[ny][nx] = 1;
						ans++;
					}
				}
				
			}
			
			System.out.printf("#%d %d%n", t, ans);
			
		}

	}

}
