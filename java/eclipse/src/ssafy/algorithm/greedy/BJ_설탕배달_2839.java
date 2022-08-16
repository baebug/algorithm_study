package ssafy.algorithm.greedy;

import java.io.*;
import java.util.*;

public class BJ_설탕배달_2839 {
	
	static int N, cnt;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		
		cnt = 0;
		while (true) {
			if (N < 0 || cnt > 6) {
				System.out.println(-1);
				break;
			}
			if (N % 5 == 0) {
				System.out.println(N/5 + cnt);
				break;
			} else {
				cnt++;
				N -= 3;
			}
		}
		
	}
	
}
