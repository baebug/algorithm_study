package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_Flatten_1208_2 {

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
			
			Arrays.sort(arr);
			
			while (N > 0) {
				if (arr[99] - arr[0] < 2) break;
				
				arr[99]--;
				arr[0]++;
				
				for (int i = 0; i < 99; i++) {
					if (arr[i] > arr[i+1]) {
						int tmp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = tmp;
					}
				}
				
				for (int i = 98; i >= 0; i--) {
					if (arr[i] > arr[i+1]) {
						int tmp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = tmp;
					}
				}
				
				N--;
				
			}
			
			System.out.printf("#%d %d%n", t, arr[99]-arr[0]);
			
		}
	}

}
