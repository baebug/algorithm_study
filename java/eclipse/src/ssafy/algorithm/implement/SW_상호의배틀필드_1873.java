package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_상호의배틀필드_1873 {
	
	static int T, H, W, N, y, x, d;
	static char[][] board;
	static char[] command;
	static final int[][] dt = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상 하 좌 우
	static final char[] tank = new char[] {'^', 'v', '<', '>'};	// 방향별 전차의 모양
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_bf.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			board = new char[H][];
			
			for (int i = 0; i < H; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			N = Integer.parseInt(br.readLine());
			command = br.readLine().toCharArray();
			
			// 우선 전차의 좌표와 바라보는 방향을 찾는다.
			y = 0;
			x = 0;
			d = 0;	// 상 하 좌 우
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (board[i][j] == '^') {
						y = i;
						x = j;
						d = 0;
						break;
					} else if (board[i][j] == 'v') {
						y = i;
						x = j;
						d = 1;
						break;
					} else if (board[i][j] == '<') {
						y = i;
						x = j;
						d = 2;
						break;
					} else if (board[i][j] == '>') {
						y = i;
						x = j;
						d = 3;
						break;
					}
				}
			}
			
			// 입력을 순회하며 동작한다.
			for(char c : command) {
				if (c == 'U') {
					go(0);
				} else if (c == 'D') {
					go(1);
				} else if (c == 'L') {
					go(2);
				} else if (c == 'R') {
					go(3);
				} else {
					fire();
				}
			}
			
			for(char[] r : board) {
				for(char c : r) {
					sb.append(c);
				}
				sb.append('\n');
			}
			
			System.out.print(sb);
		}
	}
	
	static void go(int k) {
		d = k;
		board[y][x] = tank[d];	// 못움직여도 방향은 바꾸고 끝내야 함
		
		int ny = y + dt[d][0];
		int nx = x + dt[d][1];
		
		if (ny < 0 || nx < 0 || ny >= H || nx >= W) return;
		
		// 평지면 기존의 자리를 평지로 바꾸고, 이동한다. (y, x) --> (ny, nx);
		if (board[ny][nx] == '.') {
			board[y][x] = '.';
			board[ny][nx] = tank[d];
			y = ny;
			x = nx;
		}
	}
	
	static void fire() {
		// 현재 탱크의 위치 (y, x) 에서 d 방향으로 탐색을 하며
		// 벽을 만나면 평지로 바꾸고, 범위를 벗어나거나 강철벽을 만나면 멈춘다.
		int ny = y;
		int nx = x;
		
		while (true) {
			ny += dt[d][0];
			nx += dt[d][1];
			
			if (ny < 0 || nx < 0 || ny >= H || nx >= W) return;
			
			if (board[ny][nx] == '#') {
				return;
			} else if (board[ny][nx] == '*') {
				board[ny][nx] = '.';
				return;
			}
		}
	}
}
