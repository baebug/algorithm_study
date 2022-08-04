package hwalgo04_부울경_03반_배충현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Algorithm_04_1225 {

	static Deque<Integer> stack = new ArrayDeque<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#" + t + ' ');
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				stack.add(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 0;
			int tmp = 0;
			
			while (true) {
				tmp = (cnt % 5) + 1;
				int a = stack.poll();
				if (a - tmp <= 0) {
					stack.add(0);
					break;
				} else {
					stack.add(a - tmp);
				}
				cnt++;
			}
			
			for (int i = 0; i < 8; i++) {
				sb.append(stack.poll()).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
	}

}
