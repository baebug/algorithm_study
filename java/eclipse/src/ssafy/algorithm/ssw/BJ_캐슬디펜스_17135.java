package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// 거리가 D 이하인 적 중 가장 왼쪽을 공격한다. 궁수의 공격이 끝나면, 적이 이동한다. (아래로 한 칸)
// 다 죽이거나 성에 꼬라박으면 게임이 끝난다. 최대한 많은 잡을 수 있는 적의 수를 출력
public class BJ_캐슬디펜스_17135 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, D, eCnt, kill, result = Integer.MIN_VALUE;
	static int[][] input, board, demo, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;
	static int[] hunters;
	static PriorityQueue<E> pq;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		
		input = new int[N+1][M];
		hunters = new int[3];
		dq = new ArrayDeque<>();
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				input[i][j] = Integer.parseInt(stk.nextToken());
		}
		
		comb(0, 0);
		
		System.out.println(result);
	
	}
	
	// 궁수의 조합이 나와야 적과의 거리가 나옴
	// 세 명의 궁수가 공격할 적이 정해진 뒤 0 으로 바꿔야 함
	// 궁수 bfs 한다음 하나 제거 (x 가 작은 순으로 정렬되는 pq)
	static void solve(int x) {
		dq.clear();
		pq.clear();
		visited = new boolean[N+1][M];
		visited[N][x] = true;
		dq.addLast(new int[] {N, x, 0});
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int d = Math.abs(N-i)+Math.abs(x-j);
				if (demo[i][j] == 1 && d <= D) pq.add(new E(i, j, d)); 
			}
		}
		
		// 순회 돌면서 pq 에 공격 가능한 적을 다 넣었다.
//		while (!dq.isEmpty()) {
//			int[] cur = dq.removeFirst();
//			if (cur[2] == D) break;
//			
//			for (int d = 0; d < 4; d++) {
//				int ny = cur[0] + dt[d][0];
//				int nx = cur[1] + dt[d][1];
//				int nd = cur[2] + 1;
//				
//				if (ny<0 || nx<0 || ny>=N || nx>=M) continue;
//				if (visited[ny][nx]) continue;
//				if (demo[ny][nx] == 1) pq.add(new E(ny, nx, nd));
//				
//				dq.addLast(new int[] {ny, nx, nd});
//			}
//		}
		
		// pq 제일 앞에 있는 애를 쏜다. (input 을 바꾸는 데 보는건 demo 를 봐야함. solve 밖에서 demo 만들어주기)
		if (!pq.isEmpty()) {
			E tmp = pq.poll();
			if (board[tmp.y][tmp.x] == 1) {
				board[tmp.y][tmp.x] = 0;
				kill++;
			}
		}
	}
	
	static int turn() {
		int cnt = 0;
		for (int i = N-1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					if (i == N-1) board[i][j] = 0;
					else {
						board[i+1][j] = board[i][j];
						board[i][j] = 0;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	
	static void comb(int st, int idx) {
		if (idx == 3) {
			board = copy(input);
			kill = 0;
			while (true) {
				demo = copy(board);
				for(int h : hunters) {
					solve(h);
				}
				if (turn() == 0) break;
			}
			result = Math.max(result, kill);
			return;
		}
		
		for (int i = st; i < M; i++) {
			hunters[idx] = i;
			comb(i+1, idx+1);
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
		int y;
		int x;
		int d;
		
		public E(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
		public int compareTo(E o) {
			return this.d == o.d ? this.x - o.x : this.d - o.d;
		}
	}
}
