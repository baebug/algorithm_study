package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class BJ_배수와약수_5086 {

	static int A, B;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			A = Integer.parseInt(stk.nextToken());
			B = Integer.parseInt(stk.nextToken());
			
			if (A == 0 && B == 0) break;
			
			if (B % A == 0) {
				System.out.println("factor");
			} else if (A % B == 0) {
				System.out.println("multiple");
			} else {
				System.out.println("neither");
			}
			
		}
	}
}
