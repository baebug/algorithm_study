package ssafy.algorithm.codeplus;

import java.io.*;
import java.util.*;

// 1 부터 N 까지 이어쓰면 몇 자리 수인가?
public class BJ_수이어쓰기1_1748 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		String s = br.readLine();		// "5457"
		int digit = s.length();			// 4
		int N = Integer.parseInt(s);	// 5457
		int ans = 0;
		
		// 아래 자리수의 총 합
		for (int i = 1; i < digit; i++) {
			ans += i * 9 * Math.pow(10, i-1);
		}
		
		ans += (N - Math.pow(10, digit-1) + 1) * digit;
		
		System.out.println(ans);
		
	}
	
}
