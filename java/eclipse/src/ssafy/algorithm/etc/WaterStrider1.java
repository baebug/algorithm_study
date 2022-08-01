package ssafy.algorithm.etc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaterStrider1 {

	static int T, ans, N, m;
	static int[][] arr, dt;
	
	
	public static void main(String[] args) throws Exception {
		
		dt = new int[][] {{0, 0}, {1, 0}, {0, 1}};
		
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
			
			int[][] jump = new int[m][3];
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					jump[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < m; i++) {
				y = jump[i][0];
				x = jump[i][1];
				d = jump[i][2];
				
				arr[y][x]++;
				
				int ny = y;
				int nx = x;
				
				for (int k = 3; k > 0; k--) {
					ny += k * dt[d][0];
					nx += k * dt[d][1];
					
					if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					
					if (arr[ny][nx] == 1) {
						ans = i + 1;
						break;
					}
					
					arr[ny][nx]++;
				}
				
				if (ans != 0) break;
				
			}
			
			System.out.printf("#%d %d%n", t, ans);
			
		}
		
	}

}
