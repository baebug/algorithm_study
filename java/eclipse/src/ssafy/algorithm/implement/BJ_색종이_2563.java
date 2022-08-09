package ssafy.algorithm.implement;

import java.io.*;
import java.util.*;

// 100 100 인 영역에 10 10 인 색종이를 붙인다.
// 100 100 크기의 이차원 boolean 배열로 처리하면 안되나?
// 왼쪽변 사이의 거리 x, 아래쪽 변 사이의 거리 y
public class BJ_색종이_2563 {

	static int N, x, y;
	static boolean[][] board;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new boolean[101][101];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			paper(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
		
		int cnt = 0;
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (board[i][j]) cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	// 3, 7 이 들어오면
	// i 는 8 9 10 11 12 13 14 15 16 17 이 까만색
	// j 는 4 5  6  7  8  9 10 11 12 13 이 까만색
	static void paper(int x, int y) {
		int sx = x+1;
		int sy = y+1;
		int ey = Math.min(100, y+10);
		int ex = Math.min(100, x+10);
		
		for (int i = sy; i <= ey; i++) {
			for (int j = sx; j <= ex; j++) {
				board[i][j] = true;
			}
		}
	}
	
}
