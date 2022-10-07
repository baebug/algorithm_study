package ssafy;

import java.util.*;
import java.io.*;

public class BJ_연구소_14502_bfs {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, eSize, ans;
	static int[][] input, dt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static List<int[]> empty, virus;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		empty = new ArrayList<>();
		virus = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int tmp = Integer.parseInt(stk.nextToken());
				input[i][j] = tmp;
				if (tmp == 0) empty.add(new int[] {i, j});
				else if (tmp == 2) virus.add(new int[] {i, j});
			}
		}
		
		eSize = empty.size();
		ans=0;
		
		comb(0, 0);
		
		System.out.println(ans);
	}
	
	// 세 개의 연구소 선정
	static void comb(int st, int cnt) {
		if (cnt == 3) {
			int[][] demo = copy();
			solve(demo);
			return;
		}
		
		for(int i=st; i<eSize; i++) {
			input[empty.get(i)[0]][empty.get(i)[1]] = 1;
			comb(i+1, cnt+1);
			input[empty.get(i)[0]][empty.get(i)[1]] = 0;
		}
		
	}
	
	// 바이러스 퍼뜨리기
	static void solve(int[][] board) {
		// 바이러스가 퍼지고
		dq = new ArrayDeque<>();
		for(int[] v : virus) {
			dq.addLast(v);
		}
		
		while (!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			
			for(int d=0; d<4; d++) {
				int ny = cur[0] + dt[d][0];
				int nx = cur[1] + dt[d][1];
				
				if (ny<0 || ny>=N || nx<0 || nx>=M) continue;
				
				if (board[ny][nx] == 0) {
					board[ny][nx] = 2;
					dq.addLast(new int[] {ny, nx});
				}
				
			}
		}
		
		int cnt = 0;
		// 안전영역 카운트
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (board[i][j] == 0) cnt++;
			}
		}
		
		ans = Math.max(ans, cnt);
	}
	
	// demo
	static int[][] copy() {
		int[][] demo = new int[N][];
		
		for(int i=0; i<N; i++) {
			demo[i] = input[i].clone();
		}
		
		return demo;
	}
	
}