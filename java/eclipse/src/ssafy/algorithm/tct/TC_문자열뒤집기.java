package ssafy.algorithm.tct;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TC_문자열뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		char c;
		char tmp = ' ';
		int cnt1 = 0;
		int cnt0 = 0;
		
		for (int i = 0; i < S.length(); i++) {
			c = S.charAt(i);
			if (c != tmp) {
				if (c == '0') {
					cnt0++;
				} else if (c == '1') {
					cnt1++;
				}
				tmp = c;
			}
		}
		
		System.out.println(Math.min(cnt0, cnt1));
	}

}
