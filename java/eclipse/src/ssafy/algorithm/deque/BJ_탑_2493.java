package ssafy.algorithm.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_탑_2493 {

	static int N;
	static Deque<Tower> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	static Tower cur, prev;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			cur = new Tower(i, Integer.parseInt(stk.nextToken()));

			// 먼저, 비거나 나 이상의 높이가 나올 때 까지 뽑는다.
			while (!dq.isEmpty()) {
				prev = dq.peekLast();
				
				if (prev.height < cur.height) {
					dq.removeLast();
				} else {
					break;
				}
			}
			
			// 비어있으면 0 입력하고 넣기
			if (dq.isEmpty()) {
				sb.append(0 + " ");
				dq.addLast(cur);
			} else {
			// 아니면 이전 타워의 idx 입력하고 넣기
				sb.append(prev.idx + " ");
				dq.addLast(cur);
			}
		}
		
		System.out.print(sb);
	}
	
	static class Tower {
		int idx;
		int height;
		
		public Tower(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}

}
