package ssafy.hw.step3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2030 {

	public static void main(String[] args) throws Exception {
		int[][] dt = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int max = Integer.MIN_VALUE;
		int[] max_p = new int[2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 장애물 만났는지 파악하는 boolean? or blockCnt
		// 전체 개수 세는 totalCnt
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int totalCnt = 0;
				int blockCnt = 0;
				
				if (arr[y][x] == 0) {
					totalCnt++;
					
					for (int i = 0; i < 8; i++) {
						
						int ny = y;
						int nx = x;
						
						while (true) {
							ny += dt[i][0];
							nx += dt[i][1];
							
							if (ny < 0 || nx < 0 || ny >= N || nx >= N) break;
							
							if (arr[ny][nx] == 1) {
								blockCnt++;
								if (blockCnt == 2) break;
							} else {
								blockCnt = 0;
								totalCnt++;
							}
						}
						
					}
					
					
				} else if (arr[y][x] == 1) {
					blockCnt++;
					
					for (int i = 0; i < 8; i++) {
						
						int ny = y;
						int nx = x;
						
						while (true) {
							ny += dt[i][0];
							nx += dt[i][1];
							
							if (ny < 0 || nx < 0 || ny >= N || nx >= N) break;
							
							if (arr[ny][nx] == 1) {
								blockCnt++;
								if (blockCnt == 2) break;
							} else {
								blockCnt = 0;
								totalCnt++;
							}
						}
						
					}
				}
				if (totalCnt > max) {
					max = totalCnt;
					max_p[0] = y;
					max_p[1] = x;
				}
			}
		}
		
		br.close();
		System.out.println(max);
		System.out.println(max_p[0] + "," + max_p[1]);

	}

}
