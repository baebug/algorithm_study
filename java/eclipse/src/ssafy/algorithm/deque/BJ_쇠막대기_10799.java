package ssafy.algorithm.deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 괄호가 닫힐 때 레이저 몇 방 맞은지 계산 가능
// 레이저 맞았을 때 size --> 잘리는 수?
// 근데 레이저를 제거하면 레이저인지 닫괄인지 구분이 안된다.
// 레이저를 카운트해서 size 에서 빼준다. size - (2 * 레이저 수 + 1)
public class BJ_쇠막대기_10799 {

	static Deque<Character> dq = new ArrayDeque<>();
	static char[] input;
	static char c;
	static int pipe, laser, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		pipe = 0;
		laser = 0;
		result = 0;
		
		for (int i = 0; i < input.length; i++) {
			c = input[i];
			if (c == '(') {
				pipe++;
			} else {
				// 레이저 맞음
				if(dq.peekLast() == '(') {
					laser++; pipe--;
					result += pipe;
				} else {
					// 파이프 끝
					pipe--;
					result++;
				}
			}
			dq.addLast(c);
		}
		
		System.out.println(result);

	}

}
