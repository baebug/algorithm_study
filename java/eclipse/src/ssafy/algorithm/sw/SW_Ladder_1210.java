package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Ladder_1210 {

	static int[][] arr = new int[100][100];
	static int[][] dt = new int[][] {{-1, 0}, {0, -1}, {0, 1}};	// 위 좌 우
	static int ny, nx;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_ladder.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			
			// 매번 꽉 채우니까 초기화는 필요 X
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ny = 99;
			int nx = 0;
			
			for (int idx = 0; idx < 100; idx++) {
				if (arr[ny][idx] == 2) {
					nx = idx;
					break;
				}
			}
			
			while (true) {
				ny -= 1;
				
				if (ny == 0) {
					break;
				}
				
				// 왼쪽으로 뻗어 나감
				if (canMoveLeft(ny, nx)) {
					while (canMoveLeft(ny, nx)) {
						nx += dt[1][1];
					}
				} else if (canMoveRight(ny, nx)) {
					while (canMoveRight(ny, nx)) {
						nx += dt[2][1];
					}
				}
				
			}
			
			System.out.printf("#%d %d%n", t, nx);
		}

	}
	
	static boolean canMoveLeft(int y, int x) {
		if (x - 1 >= 0 && arr[y][x-1] == 1) {
			return true;
		}
		
		return false;
	}
	
	static boolean canMoveRight(int y, int x) {
		if (x + 1 < 100 && arr[y][x+1] == 1) {
			return true;
		}
		
		return false;
	}

}
