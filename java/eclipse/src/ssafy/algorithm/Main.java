package ssafy.algorithm;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, y, x, d, cnt, ans;
	static int[][] dt, arr;
	
	public static void main(String[] args) throws Exception {
		// N M
		// x y d (북: 0, 동: 1, 남: 2, 서: 3)
		// 맵 (1 은 바다, 0 은 육지)
		System.setIn(new FileInputStream("input.txt"));
		
		dt = new int[][] {{-1, 0}, {0, 1}, {0, 1}, {-1, 0}}; // 서 남 동 북
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		arr[y][x] = 2;
		ans = 1;
		
		while (true) {
			cnt = 0;
			
			for (int i = 0; i < 4; i++) {
				
				int ny = y + dt[d][0];
				int nx = x + dt[d][1];
				d = (d + 1) % 4;
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
					cnt++;
					continue;
				}
				
				if (arr[ny][nx] == 0) {
					arr[ny][nx] = 2;
					y = ny;
					x = nx;
					ans++;
					break;
				} else {
					cnt++;
				}
				
				
			}
			
			if (cnt == 4) {
				int nd = (d + 3) % 4;
				y -= dt[nd][0];
				x -= dt[nd][1];
				
				if (y < 0 || x < 0 || y >= N || x >= M) break;
				if (arr[y][x] == 1) break;
			}
			
		}
		
		System.out.println(ans);
		
		
	}

}
