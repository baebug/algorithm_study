package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class BJ_최대공약수와최소공배수_2609 {

	static int A, B, gcd, lcm;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		
		int M = Math.max(A, B);
		int m = Math.min(A, B);

		while (true) {
			if (M % m == 0) {
				gcd = m;
				lcm = A * B / m;
				break;
			} else {
				int tmp = M % m;
				M = m;
				m = tmp;
			}
		}
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
}
