package ssafy.algorithm.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 오큰수 --> 오른쪽에 있으면서 큰 수 중 가장 왼쪽에 있는 수 = 가장 먼저 만나는 큰 수, 없으면 -1
public class BJ_오큰수_17298 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	static Deque<int[]> dq = new ArrayDeque<>();
	static int[] result;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = new int[N+1];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int[] cur = new int[] {i, Integer.parseInt(stk.nextToken())};
			int[] prev = null;
			
			// 나보다 작은 애가 있다면 내 번호 쓰면서 나가라고 한다.
			while (!dq.isEmpty()) {
				prev = dq.peekLast();
				
				if (prev[1] < cur[1]) {
					result[prev[0]] = cur[1]; 
					dq.removeLast();
				} else {
					break;
				}
			}
			
			dq.addLast(cur);
			
		}
		
		// 다 넣었는데 남은 애들은 오큰수가 없다.
		while (!dq.isEmpty()) {
			int[] tmp = dq.removeLast();
			result[tmp[0]] = -1;
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(result[i] + " ");
		}
		
		System.out.print(sb);
		
	}

}
