package ssafy.algorithm.codeplus;

import java.io.*;
import java.util.*;

public class BJ_날짜계산_1476 {
	
	static StringBuilder sb = new StringBuilder();
	static int E, S, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		E = Integer.parseInt(stk.nextToken());
		S = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		// E 가 a --> n%15 = a
		// S 가 b --> n%28 = b
		// M 이 C --> n%19 = c
		
		int y = E;
		
		while (true) {
			if (y%28 == S%28 && y%19 == M%19) {
				System.out.println(y);
				return;
			}
			
			y += 15;
		}
		
	}
	
}
