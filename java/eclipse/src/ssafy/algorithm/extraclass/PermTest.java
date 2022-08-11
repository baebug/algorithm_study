package ssafy.algorithm.extraclass;

import java.util.Arrays;

// nPr
public class PermTest {

	static int[] p = {1, 2, 3, 4, 5};
	static int N = p.length;
	static int R;
	static int count;
	static int[] nums;
	static boolean[] visited;
	
	// dfs + 저장 <--대칭--> 원위치+가지치기prunning => backtracking
	public static void main(String[] args) {
		R = 3;
		nums = new int[R];
		visited = new boolean[N];
		npr(0);
		System.out.println(count);

	}

	private static void npr(int cnt) {
		if (cnt == R) {
			count++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			nums[cnt] = p[i];
			npr(cnt+1);	// 순열은 기본적으로 dfs --> 끝까지 간다.
			nums[cnt] = 0;
			visited[i] = false;
		}
		
	}
	

}
