package algorithm_2.dp;

import java.util.*;
import java.io.*;

public class BJ_1로만들기_1463 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, INF = 987654321;
    static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
        dp = new int[3000005];
        Arrays.fill(dp, INF);
        N = Integer.parseInt(br.readLine());
        dp[1] = 0;
        
        // 3. 1을 뺀다
        for(int i=1; i<=1000000; i++) {
        	dp[i] = Math.min(dp[i], dp[i-1] + 1);
        	dp[2*i] = Math.min(dp[2*i], dp[i]+1);
        	dp[3*i] = Math.min(dp[3*i], dp[i]+1);
        }
        
        System.out.println(dp[N]);
	}
}