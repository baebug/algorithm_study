package ssafy.algorithm.incomplete;

import java.io.*;
import java.util.*;

public class BJ_이항계수_2_11051_2 {

	static int N, K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		K = Math.min(K, N-K);
		
		long n = 1;
		long d = 1;
		
		if (N == K) {
			sb.append(1);
		} else {
			for (int i = 0; i < K; i++) {
				n = n * N-i;
				d = d * K-i;
				long gcd = getGcd(n, d);
				n /= gcd;
				d /= gcd;
				System.out.println(n);
				System.out.println(d);
			}
		}
		int ans = (int) (n / d) % 10_007;
		System.out.println(ans);
		
	}
	
	static long getGcd(long N, long K) {
		long M = N;
		long m = K;
		
		while (true) {
			long tmp = M % m;
			
			if (tmp == 0) return m;
			
			M = m;
			m = tmp;
		}
	}

}
