package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_도영이가만든맛있는음식_2961 {

	static int N, result = Integer.MAX_VALUE;
	static M[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new M[N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			input[i] = new M(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
			
		}
		
		solve(0, 0, 1, 0);
		
		System.out.println(result);

	}
	
	static void solve(int idx, int cnt, int sScore, int bScore) {
		if (idx == N) {
			if (cnt > 0) result = Math.min(result, Math.abs(sScore - bScore));
			return;
		}
		
		if (cnt > 0) result = Math.min(result, Math.abs(sScore - bScore));
		solve(idx+1, cnt, sScore, bScore);
		solve(idx+1, cnt+1, sScore*input[idx].s, bScore+input[idx].b);
			
	}
	
	static class M {
		int s;
		int b;
		
		public M(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}

}
