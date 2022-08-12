package ssafy;

import java.io.*;
import java.util.*;

public class BJ_치킨배달_15686 {
	
	static int N, M, min = Integer.MAX_VALUE;
	static List<int[]> house, src, tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		house = new ArrayList<>();
		src = new ArrayList<>();
		tgt = new ArrayList<>();
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(stk.nextToken());
				if (tmp == 1) house.add(new int[] {i, j});
				else if (tmp == 2) src.add(new int[] {i, j});
			}
		}
		
		comb(0, 0);
		
		System.out.println(min);
		
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			int sum = 0;
			for(int[] h : house) {
				int dist = Integer.MAX_VALUE;
				for(int[] c : tgt) {
					dist = Math.min(dist, Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]));
				}
				sum += dist;
			}
			
			min = Math.min(min, sum);
			return;
		}
		if (srcIdx == src.size()) return;
		
		tgt.add(src.get(srcIdx));
		comb(srcIdx+1, tgtIdx+1);
		tgt.remove(src.get(srcIdx));
		comb(srcIdx+1, tgtIdx);
	}
	
	

}
