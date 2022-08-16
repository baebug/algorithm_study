package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

// 1. 가장 긴 증가하는 부분 수열의 길이를 출력한다.
// 2. 가장 긴 증가하는 부분 수열을 출력한다.
public class BJ_가장긴증가하는부분수열_4_14002 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, prev, ans;
	static int[] input, dp;
	static Deque<Integer> dq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+1];
		dp = new int[N+1];
		Arrays.fill(dp, 1);
		dq = new ArrayDeque<>();
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		
		ans = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (input[i] > input[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					ans = Math.max(ans, dp[i]);
				}
			}
		}
		
		int tmp = ans;
		int idx = N;
		while (tmp > 0) {
			if (dp[idx] == tmp) {
				dq.addFirst(input[idx]);
				tmp--;
			}
			idx--;
		}
		
		sb.append(ans).append('\n');
		while (!dq.isEmpty()) {
			sb.append(dq.removeFirst()).append(' ');
		}
		
		System.out.println(sb);
		
	}
}
