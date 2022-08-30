package ssafy;

import java.io.*;
import java.util.*;

public class BJ_가르침_1062 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, K, ans;
	static List<Integer> input = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		int flag = 0;
		
		if (K < 5) {
			System.out.println(0);
			return;
		}
		if (K == 26) {
			System.out.println(N);
			return;
		}
		
		char[] c = {'a', 'i', 'n', 't', 'c'};
		for (int i = 0; i < 5; i++) {
			flag |= 1<<(c[i]-'a');
		}
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int tmp = 0;
			for (int j=4, size=s.length()-4; j < size; j++) {
				tmp |= 1<<(s.charAt(j)-'a');
			}
			if (Integer.bitCount(flag|tmp) <= K) input.add(tmp);
		}
		
		N = input.size();
		
		solve(0, 0, 0, flag);
		
		System.out.println(ans);
	}
	
	static void solve(int idx, int st, int cnt, int flag) {
		ans = Math.max(ans, cnt);
		
		for (int i = st; i < N; i++) {
			int tmp = flag|input.get(i);
			if ((Integer.bitCount(tmp) > K)) continue;
			solve(idx+1, i+1, cnt+1, tmp);
		}
	}
}
