package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_원재의메모리복구하기_1289 {

	static int T, cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			char[] arr = br.readLine().toCharArray();
			char[] tmp = new char[arr.length];
			
			Arrays.fill(tmp, '0');
			
			cnt = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != tmp[i]) {
					if (tmp[i] == '0') {
						for (int j = i; j < tmp.length; j++) {
							tmp[j] = '1';
						}
					} else {
						for (int j = i; j < tmp.length; j++) {
							tmp[j] = '0';
						}
					}
					cnt++;
				}
			}
			
			System.out.printf("#%d %d%n", t, cnt);
		}

	}

}
