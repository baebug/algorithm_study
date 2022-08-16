package hwalgo12_부울경_3반_배충현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm_12_1828 {
	
	static int N, ans;
	static C[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		input = new C[N];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			input[i] = new C(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
		Arrays.sort(input);
		
		int M = -271;
		int result = 0;
		
		for (int i = 0, size = input.length; i < size; i++) {
			if (input[i].min > M) {
				result++;
				M = input[i].Max;
			}
		}
		
		System.out.println(result);
		
	}
	
	static class C implements Comparable<C>{
		int min;
		int Max;
		
		C(int m, int M) {
			this.min = m;
			this.Max = M;
		}
		
		public int compareTo(C o) {
			return this.Max == o.Max ? this.min - o.min : this.Max - o.Max;
		}
	}
}
