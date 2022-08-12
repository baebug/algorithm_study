package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// 알파 .55, 모래는 누적
// 격자의 밖으로 나간 모래를 구하여라. N 홀수, 가운데 0
// 격자의 밖으로 나간 모래의 양은 처음 - 현재
public class BJ_마법사상어와토네이도_20057 {

	static StringBuilder sb = new StringBuilder();
	static int N, prev, cur, total, in;
	static int[][] input;
	static int[][] dt0, dt1, dt2, dt3;
	static double[] sand;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		// 전1전2 직좌 직우 좌1좌2 우1우2 뒤좌 뒤우 
		dt0 = new int[][] {{0, -1}, {0, -2}, { 1, -1}, {-1, -1}, { 1,  0}, { 2,  0}, {-1,  0}, {-2,  0}, { 1,  1}, {-1,  1}};
		dt1 = new int[][] {{1,  0}, {2,  0}, { 1,  1}, { 1, -1}, { 0,  1}, { 0,  2}, { 0, -1}, { 0, -2}, {-1,  1}, {-1, -1}};
		dt2 = new int[][] {{0,  1}, {0,  2}, {-1,  1}, { 1,  1}, {-1,  0}, {-2,  0}, { 1,  0}, { 2,  0}, {-1, -1}, { 1, -1}};
		dt3 = new int[][] {{-1, 0}, {-2, 0}, {-1, -1}, {-1,  1}, { 0, -1}, { 0, -2}, { 0,  1}, { 0,  2}, { 1, -1}, { 1,  1}};
		sand = new double[] {0, .05, .1, .1, .07, .02, .07, .02, .01, .01};
		N = Integer.parseInt(br.readLine());
		input = new int[N+4][N+4];
		
		for (int i = 2; i < N+2; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 2; j < N+2; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
				prev += input[i][j];
			}
		}
		
		// 좌 하 이동하는 크기는 1, 3, .., N
		// 우 상 이동하는 크기는 2, 4, .., N-1
		int cnt = 1;
		int d = 0;
		int dr = -1;
		int nx, ny; nx = ny = N/2 + 2;	// 초기값
		exit:
		while (true) {
			
			// 좌, 우로 이동 --> x 값만 바뀐다.
			// 나갈 일 없음
			for (int i = 0; i < cnt; i++) {
				if (ny == 2 && nx == 2) break exit;
				nx += dr;
				
				tornado(ny, nx, d);
			}
			
			
			// 상, 하로 이동 --> y 값만 바뀐다.
			for (int i = 0; i < cnt; i++) {
				ny -= dr;
				
				tornado(ny, nx, d+1);
				
			}
			
			dr *= (-1);
			cnt++;
			d += 2;
			if (d == 4) d = 0;
		}
		
		check();
		
		System.out.println(total-in);
	}
	
	// // 전1전2 직좌 직우 좌1좌2 우1우2 뒤좌 뒤우 
	static void tornado(int y, int x, int d) {
		int tmp = input[y][x];
		int totalms = 0;
		
		switch (d) {
			case 0:
				for (int dd = 1; dd < 10; dd++) {
					int ny = y + dt0[dd][0];
					int nx = x + dt0[dd][1];
					int ms = (int) (tmp * sand[dd]);
					input[ny][nx] += ms;
					totalms += ms;
				}
				input[y+dt0[0][0]][x+dt0[0][1]] += tmp - totalms;
				break;
			case 1:
				for (int dd = 1; dd < 10; dd++) {
					int ny = y + dt1[dd][0];
					int nx = x + dt1[dd][1];
					int ms = (int) (tmp * sand[dd]);
					input[ny][nx] += ms;
					totalms += ms;
				}
				input[y+dt1[0][0]][x+dt1[0][1]] += tmp - totalms;
				break;
			case 2:
				for (int dd = 1; dd < 10; dd++) {
					int ny = y + dt2[dd][0];
					int nx = x + dt2[dd][1];
					int ms = (int) (tmp * sand[dd]);
					input[ny][nx] += ms;
					totalms += ms;
				}
				input[y+dt2[0][0]][x+dt2[0][1]] += tmp - totalms;
				break;
			case 3:
				for (int dd = 1; dd < 10; dd++) {
					int ny = y + dt3[dd][0];
					int nx = x + dt3[dd][1];
					int ms = (int) (tmp * sand[dd]);
					input[ny][nx] += ms;
					totalms += ms;
				}
				input[y+dt3[0][0]][x+dt3[0][1]] += tmp - totalms;
				break;
		}
		
		input[y][x] = 0;
	}
	
	static void check() {
		for (int i = 0; i < N+4; i++) {
			for (int j = 0; j < N+4; j++) {
				total += input[i][j];
			}
		}
		for (int i = 2; i < N+2; i++) {
			for (int j = 2; j < N+2; j++) {
				in += input[i][j];
			}
		}
	}

}
