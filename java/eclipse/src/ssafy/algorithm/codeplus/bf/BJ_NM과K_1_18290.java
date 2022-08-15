package ssafy.algorithm.codeplus.bf;

import java.io.*;
import java.util.*;

// 칸 K 개를 골라 더한 수의 최댓값을 구할건데, 인접한 칸이면 안된다.
public class BJ_NM과K_1_18290 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, K, ans = Integer.MIN_VALUE;
	static List<P> list;
	static P[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		result = new P[K];
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list.add(new P(i, j, Integer.parseInt(stk.nextToken())));
			}
		}
		
		solve(0);
		
		System.out.println(ans);
	}
	
	static void solve(int cnt) {
		if (cnt == K) {
			int sum = 0;
			for(P p : result) {
				sum += p.val;
			}
			ans = Math.max(ans, sum);
			return;
		}
		
		for (P p : list) {
			boolean flag = false;
			if (cnt > 0) {
				for (int i = 0; i < cnt; i++) {
					if ((p.y == result[i].y && Math.abs(p.x - result[i].x) < 2) ||
							(p.x == result[i].x && Math.abs(p.y - result[i].y) < 2)) {
						flag = true;
						break;
					}
				}
			}
			if (flag) continue;
			else result[cnt] = p;
			solve(cnt+1);
		}
	}
	
	static class P {
		int y;
		int x;
		int val;
		
		P(int y, int x, int v) {
			this.y = y;
			this.x = x;
			this.val = v;
		}

		@Override
		public String toString() {
			return "P [y=" + y + ", x=" + x + ", val=" + val + "]";
		}
		
	}
	
}
