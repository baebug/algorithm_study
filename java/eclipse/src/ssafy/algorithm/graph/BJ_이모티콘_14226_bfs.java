package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_이모티콘_14226_bfs {
	
	static StringBuilder sb = new StringBuilder();
	static int S, ub;
	static Deque<int[]> dq;
	static boolean[] copied;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		S = Integer.parseInt(br.readLine());
		ub = 2*S+2;
		copied = new boolean[ub];
		dq = new ArrayDeque<>();
		
		// 개수, 시간, 복사
		dq.addLast(new int[] {1, 0, 0});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.removeFirst();
			int cc = cur[0];
			int ct = cur[1];
			int cp = cur[2];
			
			if (cc == S) {
				System.out.println(ct);
				return;
			}
			
			// -1 이동
			int nc = cc-1;
			int nt = ct+1;
			// 어차피 덱에서 확인하는 애들은 균일한 시간순이기 때문에 나보다 비효율적인 애가 도착하는 것보다 해답에 도달하는게 더 빠르다. visited[nc] > nt 필요 없음?
			if (nc > 0) {
				dq.addLast(new int[] {nc, nt, cp});
			}
			
			// 복사
			if (!copied[cc]) {
				copied[cc] = true;
				dq.addLast(new int[] {cc, nt, cc});
			}
			
			// 붙여넣기
			nc = cc+cp;
			if (nc < ub) {
				dq.addLast(new int[] {nc, nt, cp});
			}
			
		}
		
	
	}
}
