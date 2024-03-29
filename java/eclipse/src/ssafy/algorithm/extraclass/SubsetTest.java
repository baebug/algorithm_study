package ssafy.algorithm.extraclass;

public class SubsetTest {

	static int[] p = {1, 2, 3, 4, 5};
	static int N = p.length;
	static int count;
	static boolean[] visited;
	
	public static void main(String[] args) {
		visited = new boolean[N];
		npr(0, 0);
		System.out.println(count);

	}

	private static void npr(int cnt, int tot) {
		if (cnt == N) {
			count++;
			for (int i = 0; i < N; i++) {
				if(visited[i]) System.out.print(p[i] + " ");
			}
			System.out.println();
			System.out.println("--->" + tot);
			return;
		}
		
			visited[cnt] = true;
			npr(cnt+1, tot+p[cnt]);	// 순열은 기본적으로 dfs --> 끝까지 간다.
			visited[cnt] = false;
			npr(cnt+1, tot);
		
	}
	

}
