package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

// 0 <= m <= n <= 20억
// 연속된 수니까 2는 그냥 많음. 5만 세자 --> X
// 특정 수 보다 작은 배수의 수를 센다? --> 몫 계산
public class BJ_조합0의개수_2004 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		int cnt5 = getNumCount5(N) - getNumCount5(M) - getNumCount5(N-M);
		int cnt2 = getNumCount2(N) - getNumCount2(M) - getNumCount2(N-M);
		
		int ans = Math.min(cnt5, cnt2);
		System.out.println(ans);
		
	}
	
	static int getNumCount5(int num) {
		int cnt5 = 0;
		long tmp = 5;	// int 범위 벗어나면 0 으로 바뀌는 것 주의!!
		while (tmp <= num) {
			cnt5 += (int) num / tmp;
			tmp *= 5;
		}
		return cnt5;
	}
	
	static int getNumCount2(int num) {
		int cnt2 = 0;
		long tmp = 2;
		while (tmp <= num) {
			cnt2 += (int) num / tmp;
			tmp *= 2;
		}
		return cnt2;
	}

}
