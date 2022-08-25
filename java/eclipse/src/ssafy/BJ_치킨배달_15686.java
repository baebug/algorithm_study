package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 도시의 치킨 거리 = 각 집의 치킨 거리의 총 합
// 1, 1 ~ N, N
// 집 : 1, 치킨집 : 2
public class BJ_치킨배달_15686 {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M, ans = Integer.MAX_VALUE;	// 도시의 크기 NN, 치킨집 M개 고르기
	static List<int[]> hl, cl;
	static int[][] ca;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		hl = new ArrayList<>();
		cl = new ArrayList<>();
		ca = new int[M][];
		
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int tmp = Integer.parseInt(stk.nextToken());
				if (tmp == 1) hl.add(new int[] {i, j});
				else if (tmp == 2) cl.add(new int[] {i, j});
			}
		}
		
		solve(0, 0);
		
		System.out.print(ans);
	}
	
	static void solve(int cnt, int st) {
		if (cnt == M) {
			int sum = 0;
			for(int[] home : hl) {
				int tmp = 987654321;
				for (int[] chicken : ca) {
					tmp = Math.min(tmp, dist(home[0], home[1], chicken[0], chicken[1]));
				}
				sum += tmp;
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = st; i < cl.size(); i++) {
			ca[cnt] = cl.get(i);
			solve(cnt+1, i+1);
		}
	}
	
	static int dist(int hy, int hx, int cy, int cx) {
		return Math.abs(hy-cy) + Math.abs(hx-cx);
	}
}
