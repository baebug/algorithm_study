package ssafy;

import java.io.*;
import java.util.*;

public class SW_무선충전_5644 {

	static StringBuilder sb = new StringBuilder();
	static int T, M, A, ans, ay, ax, by, bx;
	static int[][] board, path, dt = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static BC[] bl;
	static List<BC> ca, cb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			stk = new StringTokenizer(br.readLine());
			M = Integer.parseInt(stk.nextToken());
			A = Integer.parseInt(stk.nextToken());
			path = new int[2][M+1];
			bl = new BC[A];
			board = new int[11][11];
			ax = ay = 1;
			bx = by = 10;
			ca = new ArrayList<>();
			cb = new ArrayList<>();
			ans = 0;
			
			for (int k = 0; k < 2; k++) {
				stk = new StringTokenizer(br.readLine());
				for (int i = 0; i < M; i++) {
					path[k][i] = Integer.parseInt(stk.nextToken());
				}
			}
			
			for (int i = 0; i < A; i++) {
				stk = new StringTokenizer(br.readLine());
				bl[i] = new BC(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
			}
			
			check();
			for (int s = 0; s < M; s++) {
				// 시간이 경과하면 이동한다.
				ay += dt[path[0][s]][0]; ax += dt[path[0][s]][1];
				by += dt[path[1][s]][0]; bx += dt[path[1][s]][1];
				
				check();
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	static void check() {
		ca.clear();
		cb.clear();
		// 현재 위치에서 최선의 배터리 조합을 찾는다 --> ans에 더해준다.
		for(int i = 0; i < A; i++) {
			// a 가 충전 가능한 배터리 리스트
			if (Math.abs(bl[i].l[0] - ay) + Math.abs(bl[i].l[1] - ax) <= bl[i].c) ca.add(bl[i]);
			// b 가 충전 가능한 배터리 리스트
			if (Math.abs(bl[i].l[0] - by) + Math.abs(bl[i].l[1] - bx) <= bl[i].c) cb.add(bl[i]);
		}
		
		int max = 0;
		if (ca.isEmpty()) ca.add(new BC(1, 1, 0, 0));
		if (cb.isEmpty()) cb.add(new BC(10, 10, 0, 0));
		for (int i = 0; i < ca.size(); i++) {
			for (int j = 0; j < cb.size(); j++) {
				int tmp = ca.get(i).p + cb.get(j).p;
				if (ca.get(i).l[0] == cb.get(j).l[0] && ca.get(i).l[1] == cb.get(j).l[1]) tmp /= 2;
				max = Math.max(max, tmp);
			}
		}
		
		ans += max;
	}
	
	
	static class BC {
		int[] l;
		int c;
		int p;
		
		public BC(int x, int y, int c, int p) {
			this.l = new int[] {y, x};
			this.c = c;
			this.p = p;
		}
	}

}
