package ssafy.algorithm.math;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BJ_이항계수_2_11051 {

	static int N, K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		K = Math.max(K, N-K);
		
		BigInteger ans = new BigInteger("1");
		
		if (N == K) {
			sb.append(1);
		} else {
			for (int i = N; i > K; i--) {
				ans = ans.multiply(BigInteger.valueOf(i));
			}
			for (int i = N-K; i > 0; i--) {
				ans = ans.divide(BigInteger.valueOf(i));
			}
			ans = ans.remainder(BigInteger.valueOf(10007));
		}
		
		System.out.println(ans);
		
	}

}
