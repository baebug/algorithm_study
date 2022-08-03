package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Flatten_1208_3 {

	static int N, minIdx, maxIdx;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime();
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[100];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			maxIdx = 0;
			minIdx = 0;
			
			while (N > 0) {
				reset();
				
				if (arr[maxIdx] - arr[minIdx] < 2) break;
				
				arr[maxIdx]--;
				arr[minIdx]++;
				
				N--;
				
			}
			
			reset();
			System.out.printf("#%d %d%n", t, arr[maxIdx]-arr[minIdx]);
			
		}
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0);
	}
	
	static void reset() {
		for (int i = 0; i < 100; i++) {
			if (arr[i] < arr[minIdx]) minIdx = i;
			if (arr[i] > arr[maxIdx]) maxIdx = i;
		}
	}

}
