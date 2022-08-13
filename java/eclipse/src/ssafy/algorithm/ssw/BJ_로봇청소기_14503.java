package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

public class BJ_로봇청소기_14503 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, d, result;
	static int[][] input, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 북 동 남 서--> 나쁜놈들
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		visited = new boolean[N][M];
		
		stk = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken());
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// 1. 현재 위치 청소
		// 왼쪽방향부터 탐색 시작 
		// 청소하지않은공간(visited?)가 있으면 가서 청소(d = (d+1)%4)
		// 네 방향 모두 청소가 되어 있거나 벽이면 방향유지 + 후진(d 유지, (d+2)%4 방향으로 이동)
		// 청소or벽이면서 후진도 못하면 작동을 멈춘다.
		
		clean(y, x);
		
		System.out.println(result);
	}
	
	static void clean(int y, int x) {
		int cy = y;
		int cx = x;
		int flag = 0;
		
		while (true) {
			if (!visited[cy][cx]) result++;
			visited[cy][cx] = true;
			
			// 내 왼쪽부터 탐색
			int nd = (d+3)%4;
			int ny = cy + dt[nd][0];
			int nx = cx + dt[nd][1];
			
			// 어차피 벽으로 둘러져있어서 나가는 것 고려 X, 이미 청소했거나 벽이면 넘김
			if (visited[ny][nx] || input[ny][nx] == 1) {
				flag++;
				d = nd;
				// 4방향 다 못가면 지금 방향보고 뒤로 이동, 벽이면 종료
				if (flag == 4) {
					ny = cy - dt[d][0];
					nx = cx - dt[d][1];
					if (input[ny][nx] == 1) return;
					cy = ny;
					cx = nx;
					flag = 0;
					continue;
				} 
				continue;
			}
			
			// 이동 + 방향 전환
			d = nd;
			cy = ny;
			cx = nx;
			flag = 0;
		}
	}
}
