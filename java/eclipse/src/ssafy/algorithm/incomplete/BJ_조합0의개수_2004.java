package ssafy.algorithm.incomplete;

import java.io.*;
import java.util.*;

// 0 <= m <= n <= 20억
// 연속된 수니까 2는 그냥 많음. 5만 세자 --> X
public class BJ_조합0의개수_2004 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		int a = getNumCount(N, N-M);
		int b = getNumCount(M, 0);
		
		int ans = a - b;
		System.out.println(ans);
		
		
	}
	
	static int getNumCount(int from, int to) {
		int cnt5 = 0;
		for (int i = from; i > to; i--) {
			int tmp = i;
			while (true) {
				if (tmp % 5 == 0) {
					tmp /= 5;
					cnt5++;
				} else {
					break;
				}
			}
			
		}
		
		return cnt5;
	}

}
