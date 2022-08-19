package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오른쪽 위에 올라가 있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다.
public class SW_준환이의양팔저울_3234 {

//	static int N, total;
	static long result;
//	static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');
			
			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N];
			int total = 0;
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(stk.nextToken());
				total += input[i];
			}
			
			result = 0;
			solve(0, 0, 0, 0, N, total, input);
			
			sb.append(result).append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	static void solve(int cnt, int left, int right, int flag, int N, int total, int[] input) {
		if (cnt == N) {
			result++;
			return;
		}
		if (2*left >= total) {
			result += getC(N-cnt);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			solve(cnt+1, left+input[i], right, flag|1<<i, N, total, input);
			int tr = right + input[i];
			if (tr <= left) solve(cnt+1, left, tr, flag|1<<i, N, total, input);
		}
	}
	
	static long getC(int n) {
		long num = 1;
		for (int i = n; i > 0; i--) {
			num *= i;
		}
		
		num *= 1<<n;
		
		return num;
	}

}
