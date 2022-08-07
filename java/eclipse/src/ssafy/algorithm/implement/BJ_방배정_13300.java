package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1~6학년 남남 여여 
// 방 최대 인원수 K
// N, K
// for N
// 성별S 학년Y
public class BJ_방배정_13300 {

	static int N, K, ans, S, Y;
	static int[] boy, girl;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		boy = new int[7];
		girl = new int[7];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			S = Integer.parseInt(stk.nextToken());
			Y = Integer.parseInt(stk.nextToken());
			
			if (S == 1) {
				boy[Y]++;
			} else {
				girl[Y]++;
			}
		}
		
		for (int i = 1; i <= 6; i++) {
			ans += Math.ceil((double)boy[i] / K);
			ans += Math.ceil((double)girl[i] / K);
		}
		
		System.out.println(ans);
	}

}
