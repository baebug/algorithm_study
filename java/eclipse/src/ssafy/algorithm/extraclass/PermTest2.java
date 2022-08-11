package ssafy.algorithm.extraclass;

import java.util.Arrays;

// nPr
public class PermTest2 {

	static int[] p = {1, 2, 3, 4, 5};
	static int N = p.length;
	static int R;
	static int count;
	static int[] nums;
	
	// dfs + 저장 <--대칭--> 원위치+가지치기prunning => backtracking
	public static void main(String[] args) {
		R = 3;
		nums = new int[R];
		npr(0, 0);
		System.out.println(count);

	}

	// + bit dp
	private static void npr(int cnt, int flag) {
		if (cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & 1<<i) != 0) continue;
			
			nums[cnt] = p[i];
			npr(cnt+1, flag | 1<<i);	// 순열은 기본적으로 dfs --> 끝까지 간다.
			nums[cnt] = 0;
		}
		
	}
	

}
