package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// 1, 1 에서 시작해서 파이프의 끝을 N, N 으로 이동시키는 방법의 수
// 파이프의 상태 1, 2, 3 --> 탐색하면서 dq.add 
//바로 옆 비어있으면 q.add(>>) 
// visited 는 찍어 줄 필요 X
public class BJ_파이프옮기기1_17070 {

	static StringBuilder sb = new StringBuilder();
	static int N, result;
	static int[][] input, dt = {{0, 1}, {1, 0}, {1, 1}};	// 우 하 대각
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1][N+1];
		dq = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				input[i][j] = Integer.parseInt(stk.nextToken());
		}
		
		solve();
		
		System.out.println(result);
	}
	
	// 가로1, 세로2, 대각3 
	static void solve() {
		dq.addLast(new int[] {1, 2, 1});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cy = cur[0];
			int cx = cur[1];
			int cd = cur[2];
			if (cy == N && cx == N) result++;
			
			// 대각에 대해 갈 수 있는지 체크 후 움직인다.
			for (int d = 0; d < 3; d++) {
				int ny = cy + dt[d][0];
				int nx = cx + dt[d][1];
				if (ny>N || nx>N || input[ny][nx] == 1) break;
				if (d==2) dq.addLast(new int[] {cy+1, cx+1, 3});
			}
			
			// 타입별 (가로-가로, 세로-세로, 대각-가로세로) 방향으로 갈 수 있는지 체크 후 움직인다.
			if (cd == 1 || cd == 3) {
				int ny = cy;
				int nx = cx + 1;
				if (!(ny>N || nx>N || input[ny][nx] == 1)) dq.addLast(new int[] {ny, nx, 1});
			}
			if (cd == 2 || cd == 3) {
				int ny = cy + 1;
				int nx = cx;
				if (!(ny>N || nx>N || input[ny][nx] == 1)) dq.addLast(new int[] {ny, nx, 2});
			}
		}
	}
	
}
