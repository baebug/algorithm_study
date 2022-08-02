package ssafy.algorithm.sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// ArrayList 사용 - 시간이 더 걸리지만, 유틸성이 좋다.
public class SW_Flatten_1208_4 {

	static int N, minIdx, maxIdx;
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long start = System.nanoTime();
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			maxIdx = 0;
			minIdx = 0;
			
			while (N > 0) {
				reset();
				
				if (arr.get(maxIdx) - arr.get(minIdx) < 2) break;
				
				arr.set(maxIdx, arr.get(maxIdx)-1);
				arr.set(minIdx, arr.get(minIdx)+1);
				
				N--;
				
			}
			
			reset();
			System.out.printf("#%d %d%n", t, arr.get(maxIdx)-arr.get(minIdx));
			
		}
		
		long end = System.nanoTime();
		System.out.println((end - start) / 1_000_000_000.0);
	}
	
	static void reset() {
		for (int i = 0; i < 100; i++) {
			if (arr.get(i) < arr.get(minIdx)) minIdx = i;
			if (arr.get(i) > arr.get(maxIdx)) maxIdx = i;
		}
	}

}
