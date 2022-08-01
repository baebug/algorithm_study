package ssafy.algorithm.etc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OverAvg {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i] = tmp;
				sum += tmp;
			}
			
			double avg = (double) sum / n;
			
			long cnt = Arrays.stream(arr).filter(x -> x > avg).count();
			
			System.out.printf("#%d %.3f%%%n", t, (double) cnt / n * 100);
			
			
		}

	}

}
