package ssafy.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] dt, board;
	static int cnt, rx, ry;
	
	public static void main(String[] args) throws Exception{
		dt = new int[][] {{0, 1}, {1, 1}, {1, 0}, {-1, 1}};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[19][19];
		
		for (int y = 0; y < 19; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < 19; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int y = 0; y < 19; y++) {
			for (int x = 0; x < 19; x++) {
				if (board[y][x] != 0) {
					int color = board[y][x];
					
					for (int d = 0; d < 4; d++) {
						cnt = 1;
						
						int ny = y;
						int nx = x;

						while (true) {
							ny += dt[d][0];
							nx += dt[d][1];
							
							if (ny < 0 || nx < 0 || ny >= 19 || nx >= 19) break;
							
							if (board[ny][nx] == color) {
								cnt++;
                                if (cnt == 6) break;
								
							} else {
								break;
							}
							
						}
						
						if (cnt == 5) {
							System.out.println(color);
							System.out.printf("%d %d", y+1, x+1);
							return;
						}
						
					}
					
				}
			}
		}
		System.out.println(0);
	}

}
