package ssafy;

import java.util.*;
import java.io.*;

public class BJ_낚시왕_17143 {
	
	static StringBuilder sb = new StringBuilder();
	static int R, C, M, ans, x;
	static int[][] dt = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};	// 1:상, 2:하, 3:우, 4:좌
	static int[] ddd = {0, 2, 1, 4, 3};
	static S[][] input;
	static List<S> sl;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new S[R+1][C+1];
		sl = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int r, c, v, d, s;
			stk = new StringTokenizer(br.readLine());
			r = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			v = Integer.parseInt(stk.nextToken());
			d = Integer.parseInt(stk.nextToken());
			s = Integer.parseInt(stk.nextToken());
			
			input[r][c] = new S(r, c, v, d, s);
		}
		
		x = 0;
		
		for(int i=0; i<C; i++) {
			calc();
			move();
		}
		
		System.out.println(ans);
	}
	
	// 물고기 이동
	static void move() {
		sl.clear();
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if (input[i][j] != null) sl.add(input[i][j]); 
			}
		}
		
		S[][] next = new S[R+1][C+1];
		
		for(S fish : sl) {
			int ny = fish.y;
			int nx = fish.x;
			int nv = fish.v;
			int nd = fish.d;
			int ns = fish.s;
			
			int rv = 0;
			
			// 상하로 움직일 때
			if (nd == 1 || nd == 2) {
				rv = nv % (2*(R-1));
			} else {
				rv = nv % (2*(C-1));
			}
			
			if((ny==1 && nd==1) || (ny==R && nd==2) || (nx==C && nd==3) || (nx==1 && nd==4)) {
				nd = ddd[nd];
			}
			
			for(int i=0; i<rv; i++) {
				ny += dt[nd][0];
				nx += dt[nd][1];
				
				if((ny==1 && nd==1) || (ny==R && nd==2) || (nx==C && nd==3) || (nx==1 && nd==4)) {
					nd = ddd[nd];
				}
			}
			
			if (next[ny][nx] == null) next[ny][nx] = new S(ny, nx, nv, nd, ns);
			else {
				S cur = next[ny][nx];
				if (cur.s < ns) next[ny][nx] = new S(ny, nx, nv, nd, ns);
			}
		}
		
		input = next;
	}
	
	static void calc() {
		x++;
		
		for(int i=1; i<=R; i++) {
			if (input[i][x] != null) {
				ans += input[i][x].s;
				input[i][x] = null;
				return;
			}
		}
	}
	
	static class S {
		int y, x, v, d, s;
		
		S(int y, int x, int v, int d, int s) {
			this.y = y;
			this.x = x;
			this.v = v;
			this.d = d;
			this.s = s;
		}
	}
}