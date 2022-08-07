package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

// 최소 공배수 구하는 프로그램
public class BJ_최소공배수_1934 {

	static int T, A, B, gcd, lcm;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			A = Integer.parseInt(stk.nextToken());
			B = Integer.parseInt(stk.nextToken());
			
			int M = Math.max(A, B);
			int m = Math.min(A, B);
			while (true) {
				if (M % m == 0) {
					gcd = m;
					break;
				} else {
					int tmp = M % m;
					M = m;
					m = tmp;
				}
			}
			lcm = A * B / gcd;
			 
			sb.append(lcm + "\n");
		}
		
		System.out.print(sb);
		
	}
}
