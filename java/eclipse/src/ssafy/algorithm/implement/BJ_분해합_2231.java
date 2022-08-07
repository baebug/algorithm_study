package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_분해합_2231 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < N; i++) {
			if (foo(i) == N) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
		
	}
	
	static int foo(int num) {
		char[] digits = Integer.toString(num).toCharArray();
		
		for (int i = 0; i < digits.length; i++) {
			num += digits[i] - '0';
		}
		
		return num;
	}
	
}
