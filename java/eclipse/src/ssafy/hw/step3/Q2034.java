package ssafy.hw.step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2034 {

	static int N, totalCnt;
	static int[][] arr;
	static int px, py;
	
	public static void main(String[] args) throws Exception {
		int[][] dt = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		totalCnt = 0;
		
		// 광산 map 가져오
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 0) {
					py = y;
					px = x;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int m = 0; m < M; m++) {
			char c = br.readLine().charAt(0);
			
			if (c == 'U') {
				go(0);
			} else if (c == 'D') {
				go(1);
			} else if (c == 'L') {
				go(2);
			} else if (c == 'R') {
				go(3);
			} else if (c == 'X') {
				for (int d = 0; d < 8; d++) {
					int ny = py + dt[d][0];
					int nx = px + dt[d][1];
					
					if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					
					if (arr[ny][nx] != 0) {
						arr[ny][nx] = 0;
						totalCnt++;
					}
				}
			}
		}
		
		br.close();
		System.out.println("광부 위치 : (" + py + "," + px + ")");
		System.out.println("부순 암석 개수 : " + totalCnt);

	}
	
	static void go(int d) {
		int[][] dt4 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		int ny = py + dt4[d][0];
		int nx = px + dt4[d][1];
		
		if (arr[ny][nx] == 0) {
			py = ny;
			px = nx;
		} else if (arr[ny][nx] == 1) {
			arr[ny][nx] = 0;
			py = ny;
			px = nx;
			totalCnt++;
		} else {
			arr[ny][nx]--;
		}
	}

}
