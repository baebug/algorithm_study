package ssafy.algorithm.deque;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SW_괄호짝짓기_1218_2 {

//	static Stack<Character> stack = new Stack<>();
	static Deque<Character> stack = new ArrayDeque<>();
	static final Map<Character, Character> brackets = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		
		brackets.put('(', ')');
		brackets.put('{', '}');
		brackets.put('[', ']');
		brackets.put('<', '>');
		
		System.setIn(new FileInputStream("data/input_bracket.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			stack.clear();
			int N = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				char c = input[i];
				if (brackets.containsKey(c)) {
					stack.push(c);
				} else {
					if (stack.isEmpty()) {
						stack.push(c);	// 이거 없으면 처음에 닫는 괄호 나오는 거 못잡는다.
						break; 
					}
					char tmp = stack.pop();
					if (c != brackets.get(tmp)) break;
				}
			}
			
			if (stack.isEmpty()) result = 1;
			
			System.out.println("#" + t + " " + result);
			
		}
	}
}
