package ssafy.hw.step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2008 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[][] dt = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[N][N];
			int max = 0;
			
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					
					if (arr[y][x] == 'B') {
						boolean isPark = false;
						
						for (int i = 0; i < 8; i++) {
							int ny = y + dt[i][0];
							int nx = x + dt[i][1];
							
							if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
							
							if (arr[ny][nx] == 'G') {
								isPark = true;
								break;
							}
							
						}
						
						if (!isPark) {
							int cnt = 0;
							for (int i = 0; i < N; i++) {
								if (arr[y][i] == 'B') {
									cnt++;
								}
								if (arr[i][x] == 'B') {
									cnt++;
								}
							}
							cnt--;
							
							max = Math.max(max, cnt);
						}
					}
					
					
				}
			}
			
			System.out.println("#" + t + " " + max);
			
		}
		
		br.close();

	}

}

