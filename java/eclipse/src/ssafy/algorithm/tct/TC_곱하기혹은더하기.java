package ssafy.algorithm.tct;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TC_곱하기혹은더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int sum = input[0] - '0';
		
		for (int i = 1; i < input.length; i++) {
			int tmp = input[i] - '0';
			
			if (sum != 0 && tmp != 0) {
				sum *= tmp;
			} else {
				sum += tmp;
			}
		}
		
		System.out.println(sum);
	}

}
