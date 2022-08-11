package ssafy.algorithm.extraclass;

import java.util.Arrays;

// nCr
public class CombiTest {

	static int[] p = {1, 2, 3, 4, 5};
	static int N = p.length;
	static int R;
	static int count;
	static int[] nums;
	
	// dfs + 저장 <--대칭--> 원위치+가지치기prunning => backtracking
	public static void main(String[] args) {
		R = 3;
		nums = new int[R];
		ncr(0, 0);
		System.out.println(count);

	}

	private static void ncr(int start, int cnt) {
		if (cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = start; i < N; i++) {
			
			nums[cnt] = p[i];
			ncr(i+1, cnt+1);	// 순열은 기본적으로 dfs --> 끝까지 간다.
			// nums[cnt] = 0;
		}
		
	}
	

}
