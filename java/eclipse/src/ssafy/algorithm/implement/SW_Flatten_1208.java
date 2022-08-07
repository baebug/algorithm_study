package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_Flatten_1208 {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			while (N > 0) {
				Arrays.sort(arr);
				if (arr[99] - arr[0] > 1) {
					arr[99]--;
					arr[0]++;
				} else {
					break;
				}
				
				N--;
			}
			
			Arrays.sort(arr);
			System.out.printf("#%d %d%n", t, arr[99]-arr[0]);
			
		}
	}

}
