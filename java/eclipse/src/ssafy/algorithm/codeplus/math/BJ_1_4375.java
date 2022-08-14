package ssafy.algorithm.codeplus.math;

import java.io.*;
import java.util.*;

// x mod N = (x mod N) mod N
public class BJ_1_4375 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		String s = " ";
	
		while ((s = br.readLine()) != null) {
			
			int n = Integer.parseInt(s);
			int k = 1;
			int cnt = 1;
			
			while (true) {
				if (k % n == 0) {
					break;
				}
				else  {
					cnt++;
					k = 10 * k + 1;
					k %= n;
				}
				
			}
			System.out.println(cnt);
			
		}
		
	}

}
