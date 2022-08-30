package ssafy.hw.step3;

import java.util.Scanner;

public class Q2033 {

	public static void main(String[] args) {
		
		int[][] dt = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			// 킹 가로 세로, 퀸 가로 세로
			int[] king = {sc.nextInt(), sc.nextInt()};
			int[] queen = {sc.nextInt(), sc.nextInt()};
			boolean isCatch = false;
			
			for (int i = 0; i < 8; i++) {
				int nx = queen[0];
				int ny = queen[1];
				
				while (true) {
					nx += dt[i][0];
					ny += dt[i][1];
					
					if (nx < 1 || ny < 1 || nx > N || ny > N) break;
					
					if (nx == king[0] && ny == king[1]) {
						isCatch = true;
						break;
					}
				}
				if (isCatch) break;
			}
			
			if (isCatch) {
				System.out.println("#" + t + " " + 1);
			} else {
				System.out.println("#" + t + " " + 0);
			}
		}
		
		sc.close();

	}

}
