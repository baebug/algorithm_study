package ssafy.algorithm.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_다리놓기_1010_basic {

	// 공 7개 중에서 4개를 뽑는다 (조합)
	// 공 한개를 선택한 경우의 수
	// 공 한개를 선택하지 않은 경우의 수
	
	// memoization --> 작은 수 > 큰 수로 확대해 나가는 방법 (DP)
	
	static int T, N, M, ans;
	static int[][] memoi;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer stk;
		
		for (int t = 1; t <= T; t++) {
			stk = new StringTokenizer(br.readLine());
			M = Integer.parseInt(stk.nextToken());
			N = Integer.parseInt(stk.nextToken());
			memoi = new int[N+1][M+1];
			
			sb.append(comb(N, M)).append('\n');
			
		}
		
		System.out.print(sb);
	}
	
	static int comb(int src, int tgt) {
		if (memoi[src][tgt] != 0) return memoi[src][tgt];
		if (src == tgt) return memoi[src][tgt] = 1;
		if (tgt == 1) return memoi[src][tgt] = src;
		
		return memoi[src][tgt] = comb(src-1, tgt) + comb(src-1, tgt-1);
	}

}
