package ssafy.algorithm.array2d;

import java.io.*;
import java.util.*;

// NxN 으로 늘어선 방
// 상하좌우 방이 있고, 이동하려는 방에 적힌 숫자가 현재 방의 숫자보다 정확히 1이 크다면 이동 가능
// 가장 많이 이동할 수 있는 경우의 초기 방 번호 n, 최대 이동 수 m 을 출력하여라. (m 이 같다면 n 이 작은 수)
public class SW_정사각형방_1861 {

	static int T, N, n, m;
	static int[][] input;
	static int[][] dt = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			N = Integer.parseInt(br.readLine());
			
			// 배열 만들고 받기
			input = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			// 초기화
			m = 0;
			n = Integer.MAX_VALUE;
			
			// i, j 시점에서 dt 탐색하면서 있으면 이동하고 카운트 올려주는 메서드, 최소값도 저장해야한다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					solve(i, j);
				}
			}
			
			sb.append(n).append(' ').append(m).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solve(int y, int x) {
		int ry = y;
		int rx = x;
		int cnt = 1;
		while (true) {
			int f = 0;
			int cur = input[ry][rx];
			
			for (int d = 0; d < 4; d++) {
				int ny = ry + dt[d][0];
				int nx = rx + dt[d][1];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					f++;
					continue;
				}
				
				if (input[ny][nx] == cur + 1) {
					ry = ny;
					rx = nx;
					cnt++;
					break;
				} else {
					f++;
				}
			}
			if (f == 4) break;
		}
		if (cnt > m) {
			m = cnt;
			n = input[y][x];
		} else if (cnt == m) {
			m = cnt;
			n = Math.min(input[y][x], n);
		}
		
	}
	
	
}
