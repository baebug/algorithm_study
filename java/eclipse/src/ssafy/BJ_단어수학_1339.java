package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_단어수학_1339 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, ans;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[30];
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0, size = tmp.length; j < size; j++) {
				dp[tmp[j]-'A'] += Math.pow(10, size-j-1);
			}
		}
		
		Arrays.sort(dp);
		
		int idx = 29;
		int mul = 9;
		while (dp[idx] != 0) {
			ans += dp[idx--] * mul--;
		}
		
		System.out.println(ans);
		
	}
	
}
