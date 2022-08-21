package ssafy.algorithm.implement;

import java.io.*;
import java.util.*;

public class BJ_캐슬디펜스_17135_d {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, D, tD, turn, tcnt, cnt, ans, tans;
	static int[][] input, demo, board;
	static int[] hunters;	// 헌터들의 x 좌표 조합
	static PriorityQueue<E> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(stk.nextToken());
				if (input[i][j] == 1) cnt++;
			}
		}
		
		ans = 0;
		hunters = new int[3];
		pq = new PriorityQueue<>();
		solve(0, 0, 0);
		
		System.out.println(ans);
		
	}
	
	static void solve(int st, int h, int flag) {
		if (h == 3) {
			// 매 판 초기화
			demo = copy(input);
			tcnt = cnt; tD = D; turn = 0; tans = 0;
			while (tcnt>0) {
				shot();
				turn++;
				clear();
				tD++;
			}
			ans = Math.max(ans, tans);
			return;
		}
		if (st == M) return;
		
		for (int i = st; i < M; i++) {
			if ((flag & 1<<i) != 0) continue;
			hunters[h] = i;
			solve(i+1, h+1, flag|1<<i);
		}
	}
	
	static void shot() {
		board = copy(demo);
		for (int h = 0; h < 3; h++) {
			pq.clear();
			int x = hunters[h];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int d = N-i + Math.abs(x - j);
					if (board[i][j] == 1 && d <= tD) {
						pq.add(new E(i, j, d));
					}
				}
			}
			if (!pq.isEmpty()) {
				E cur = pq.poll();
				if (demo[cur.y][cur.x] == 1) {
					demo[cur.y][cur.x] = 0;
					tcnt--; tans++;
				}
			}
		}
	}
	
	static void clear() {
		for (int j = 0; j < M; j++) {
			if (turn > N) break;
			if (demo[N-turn][j] == 1) {
				demo[N-turn][j] = 0;
				tcnt--;
			}
		}
	}
	
	static int[][] copy(int[][] arr) {
		int[][] tmp = new int[N][];
		for (int i = 0; i < N; i++) {
			tmp[i] = arr[i].clone();
		}
		return tmp;
	}
	
	static class E implements Comparable<E> {
		int y, x, d;
		
		E(int y, int x, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		public int compareTo(E o) {
			return this.d == o.d ? this.x - o.x : this.d - o.d;
		}
	}
}
