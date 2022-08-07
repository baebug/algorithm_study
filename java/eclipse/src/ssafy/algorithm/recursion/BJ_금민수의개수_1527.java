package ssafy.algorithm.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A, B 최대 10억
public class BJ_금민수의개수_1527 {

	static int A, B, cnt;
	static int[] arr = new int[] {4, 7};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		int digitA = (int) Math.log10(A-1) + 1;
		int digitB = (int) Math.log10(B) + 1;
		
		cnt = 0;
		kms(0, 0, B, digitB);
		int tmp1 = cnt;

		cnt = 0;
		kms(0, 0L, A-1, digitA);
		int tmp2 = cnt;
		
		System.out.println(tmp1 - tmp2);
		
	}
	
	static void kms(int idx, long sum, int max, int digit) {
		if (sum > max) return;
		if (idx == digit) return;
		
		for (int i = 0; i < 2; i++) {
			long tmp = sum;
			tmp = 10 * tmp + arr[i];
			
			if (tmp <= max) {
				cnt++;
				kms(idx+1, tmp, max, digit);
			}
			
		}
	}
	
}
