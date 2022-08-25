package ssafy;

import java.io.*;
import java.util.*;

public class BJ_행성터널_2887_fail {
	
	static StringBuilder sb = new StringBuilder();
	static int N, cnt;
	static long ans;
	static P[] input;
	static int[] p;
	static List<int[]> list;
	// 좌표 차 최대 20억 --> long
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		N = Integer.parseInt(br.readLine());
		input = new P[N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			input[i] = new P(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
		
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		
		list = new ArrayList<>();
		// i, j, val 을 다 만들어서 val 순으로 정렬하고 i-j 연결
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				list.add(new int[] {i, j, calc(input[i], input[j])});
			}
		}
		Collections.sort(list, (p1, p2) -> p1[2] - p2[2]);
		
		while(true) {
			int[] cur = list.remove(0);
			
			if (findset(cur[0]) != findset(cur[1])) {
				union(cur[0], cur[1]);
				ans += cur[2];
				cnt++;
			}
			
			if (cnt == N-1) break;
		}
		
		System.out.println(ans);
		
	}
	
	static int findset(int x) {
		if (p[x] == x) return x;
		return p[x] = findset(p[x]);
	}
	
	static void union(int x, int y) {
		p[y] = findset(x);
	}
	
	static int calc(P p1, P p2) {
		if (p1.z == p2.z) return 0;
		if (p1.y == p2.y) return 0;
		if (p1.x == p2.x) return 0;
		return Math.min(Math.min(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y)), Math.abs(p1.z - p2.z));
	}
	
	static class P {
		int z, y, x;
		
		P(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
