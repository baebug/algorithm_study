package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
public class BJ_영화감독숌_1436 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int num = 665;
		
		while (cnt != N) {
			num++;
			
			if (isValid(num)) cnt++;
			
		}
		
		System.out.println(num);
		
	}
	
	static boolean isValid(int num) {
		char[] digits = Integer.toString(num).toCharArray();
		
		for (int i = 0; i < digits.length-2; i++) {
			for (int j = 0; j < 3; j++) {
				if (digits[i+j] != '6') break;
				if (j == 2) return true;
			}
		}
		
		return false;
	}
	
	
}
