package ssafy.algorithm.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 1번 카드가 제일 위, N번 카드가 제일 아래
// 제일 위를 버리고, 제일 위를 제일 아래에 넣는다.
// 1 2 3 4 --> 2 3 4 --> 3 4 2
// 마지막에 남는 카드의 번호
public class BJ_카드2_2164 {

	static Deque<Integer> dq = new ArrayDeque<>();
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}
		
		while (true) {
			if (dq.size() == 1) {
				System.out.println(dq.pop());
				return;
			}
			
			dq.removeFirst();
			dq.addLast(dq.removeFirst());
		}
		
	}

}
