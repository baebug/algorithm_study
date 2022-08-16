package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

// 0 부터 N 까지의 정수 K 개를 더해서 합이 N 이 되는 경우의 수
// 같은 수를 여러 번 사용 가능
public class BJ_합분해_2225 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, K, cnt;
	static long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		dp = new long[N+1][K+1];
		for (int i = 0; i <= N; i++) dp[i][1] = 1;	// 1개를 써서 i 를 만듦
		
		// 2개를 써서 ~~ 3개를 써서 ~~
		for (int k = 2; k <= K; k++) {
			// k 개를 써서 i + j 를 만든다  = k-1 개를 써서 j 를 만든 경우 + k 번째에 j 를 사용 
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= N; j++) {
					if (i+j <= N) dp[i+j][k] += dp[j][k-1] % 1000000000;
				}
			}
		}
		
		System.out.println(dp[N][K] % 1000000000);
		
	}
}
