package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_달팽이_1913 {

	static int N, M, ry, rx;
	static int[][] dt = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌
	static int[][] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		result = new int[N][N];
		
		int st = N/2;
		
		int y = st;
		int x = st;
		int d = -1;
		int cnt = 1;
		
		result[y][x] = cnt++;
		ry = y;
		rx = x;
		
		int tmp = 1;
		
		while (true) {
			// 위 아래 (d의 값에 따라 달라짐)
			for (int i = 0; i < tmp; i++) {
				y += d;	// d = -1;
				
				result[y][x] = cnt;
				
				if (cnt == N*N) break;
				
				cnt++;
			}
			
			if (cnt == N*N) break;

			// 좌 우
			for (int i = 0; i < tmp; i++) {
				x -= d;
				
				result[y][x] = cnt++;
				
			}
			
			d *= -1;
			tmp++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (result[i][j] == M) {
					ry = i+1;
					rx = j+1;
				}
				sb.append(result[i][j] + " ");
			}
			sb.append('\n');
		}
		sb.append(ry + " " + rx);
			
		System.out.println(sb);
	}

}
