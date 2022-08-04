package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW_괄호짝짓기_1218 {

	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input_bracket.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int t = 1; t <= 10; t++) {
			stack.clear();
			int N = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				char c = input[i];
				if (c == '(' || c == '{'  || c == '['  || c == '<') {
					stack.add(c);
				} else {
					if (stack.isEmpty()) break; 
					else {
						char tmp = stack.pop();
						if (c == ')' && tmp != '(') {
							break;
						} else if (c == '}' && tmp != '{') {
							break;
						} else if (c == ']' && tmp != '[') {
							break;
						} else if (c == '>' && tmp != '<') {
							break;
						}
					}
				}
			}
			
			if (stack.isEmpty()) result = 1;
			
			System.out.println("#" + t + " " + result);
			
		}

	}

}
