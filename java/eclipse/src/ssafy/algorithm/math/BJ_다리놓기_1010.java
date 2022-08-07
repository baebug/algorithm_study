package ssafy.algorithm.math;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BJ_다리놓기_1010 {

	static int T, N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			
			BigInteger ans = new BigInteger("1");
			
			if (N == M) {
				sb.append(1 + "\n");
				continue;
			} else {
				for (int i = M; i > N; i--) {
					ans = ans.multiply(BigInteger.valueOf(i));
				}
				for (int i = M-N; i > 0; i--) {
					ans = ans.divide(BigInteger.valueOf(i));
				}
			}
			
			sb.append(ans.toString() + "\n");
			
		}
		
		System.out.print(sb);
		
	}

}
