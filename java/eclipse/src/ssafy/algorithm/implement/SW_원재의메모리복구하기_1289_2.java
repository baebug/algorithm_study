package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_원재의메모리복구하기_1289_2 {

	static int T, cnt;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			arr = br.readLine().toCharArray();
			char tmp = '0';
			
			cnt = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != tmp) {
					tmp = arr[i];
					cnt++;
				}
			}
			
			System.out.printf("#%d %d%n", t, cnt);
		}

	}

}
