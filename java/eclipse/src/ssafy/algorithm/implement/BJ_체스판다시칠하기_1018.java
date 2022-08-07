package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// B, W 로 칠해져있다.
// 다시 칠해야 하는 정사각형의 최소 개수
public class BJ_체스판다시칠하기_1018 {

	static int N, M, ans;	// 세로 가로
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		board = new char[N][];
		ans = 64;
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				checkBoard('W', i, j);
				checkBoard('B', i, j);
			}
		}
		
		System.out.println(ans);
		
	}
	
	static void checkBoard(char c, int y, int x) {
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (((i+j)&1) == 0) {
					if (board[y+j][x+i] != c) cnt++;
				} else {
					if (board[y+j][x+i] == c) cnt++;
				}
			}
		}
		
		ans = Math.min(ans, cnt);
	}
	
}
