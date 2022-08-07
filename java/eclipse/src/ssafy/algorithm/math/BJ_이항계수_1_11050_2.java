package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class BJ_이항계수_1_11050_2 {

	static int N, K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		int ans = 1;
		
		if (N == K) {
			sb.append(1);
		} else {
			for (int i = 0; i < K; i++) {
				ans *= N-i;
			}
			for (int i = 0; i < K; i++) {
				ans /= K-i;
			}
			sb.append(ans);
			
		}
		
		System.out.println(sb);
		
	}

}
