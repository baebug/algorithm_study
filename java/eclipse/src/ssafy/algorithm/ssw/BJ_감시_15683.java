package ssafy.algorithm.ssw;

import java.io.*;
import java.util.*;

// cctv 가 보고 있는 방향 그리는 메소드
// 1번 단방향 4
// 2번 양방향 2
// 3번 직각방향 4
// 4번 3방향 4
// 5번 4방향 1
// 조합 어떻게 돌리지? 방향잡고 while delta --> count
// cctv 대 수 만큼 배열을 만들고 1 ~ 4 순열만들어서 사용
public class BJ_감시_15683 {

	static StringBuilder sb = new StringBuilder();
	static int N, M, result = Integer.MAX_VALUE;
	static int[] perm, dl;
	static List<int[]> cctv;
	static int[][] input, demo, dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new int[N][M];
		cctv = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(stk.nextToken());
				input[i][j] = tmp;
				if (tmp != 0 && tmp != 6) cctv.add(new int[] {tmp, i, j});
			}
		}
		
		perm = new int[cctv.size()];
		
		solve(0);
		
		System.out.print(result);
		
	}
	
	// cctv 에서 하나씩 꺼내서 for 1~4 케이스로 돌린다?
	// 이러면 4방향 다 쏘는데
	static void solve(int idx) {
		if (idx == cctv.size()) {
			// 돌리기
			demo = copy();
			for (int i = 0; i < cctv.size(); i++) {
				see(cctv.get(i), perm[i]);
			}
			// 계산
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (demo[i][j] == 0) cnt++;
				}
			}
			// math.min
			result = Math.min(result, cnt);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			perm[idx] = i;
			solve(idx+1);
		}
		
	}
	
	static void see(int[] ct, int d) {	// d = 0, 1, 2, 3
		int k = ct[0];
		int y = ct[1];
		int x = ct[2];
		
		if (k == 1) dl = new int[] {d};
		else if (k == 2) dl = new int[] {d, (d+2)%4};
		else if (k == 3) dl = new int[] {d, (d+1)%4};
		else if (k == 4) dl = new int[] {d, (d+1)%4, (d+2)%4};
		else if (k == 5) dl = new int[] {d, (d+1)%4, (d+2)%4, (d+3)%4};
		
		for (int i = 0; i < dl.length; i++) {
			int ny = y;
			int nx = x;
			
			while (true) {
				ny += dt[dl[i]][0];
				nx += dt[dl[i]][1];
				
				if (ny<0 || nx<0 || ny>=N || nx>=M) break;
				if (demo[ny][nx] == 6) break;
				
				demo[ny][nx] = '#';
			}
		}
	}
	
	static int[][] copy() {
		int[][] tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tmp[i] = input[i].clone();
		}
		
		return tmp;
	}
}
