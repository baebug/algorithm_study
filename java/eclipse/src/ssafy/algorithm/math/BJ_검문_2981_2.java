package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

// 숫자 N 개를 M 으로 나누었을 때, 나머지가 같게 되는 M 을 찾으려 한다. (M > 1)
// N 이 주어지면, 가능한 M 을 모두 찾아라. (N 최대 10억)
// 1 ~ 10억의 수 100개
// 
public class BJ_검문_2981_2 {

	static int N;
	static int[] input, ta, result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		ta = new int[N-1];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);
		
		// 모든 수에서 이전 수를 뺀다 --> 1이 아니라면 tl 에 넣은 뒤 정렬한다.
		for (int i = 0; i < N-1; i++) {
			int tmp = input[i+1] - input[i];
			if (tmp != 1) ta[i] = tmp;
		}
		Arrays.sort(ta);
		
		
		int gcd = ta[0];
		for (int i = 1; i < ta.length; i++) {
			gcd = getGcd(gcd, ta[i]);
		}
		
		List<Integer> tl = new ArrayList<>();
		
		// 구한 최대 공약수의 모든 약수를 구해서 sb 에 넣는다.
		// 약수 구할 때 제곱근 까지만 고려하면 된다. *******************
		for (int i = 1; i*i <= gcd; i++) {
			if (gcd % i == 0) {
				tl.add(i);
				if (i != gcd/i) {
					tl.add(gcd/i);
				}
			}
		}
		Collections.sort(tl);
		
		for (int i = 1; i < tl.size(); i++) {
			sb.append(tl.get(i) + " ");
		}
		
		System.out.println(sb);
	}
	
	static int getGcd(int a, int b) {
		int M = Math.max(a, b);
		int m = Math.min(a, b);
		
		while (true) {
			int tmp = M % m;
			
			if (tmp == 0) {
				return m;
			} else {
				M = m;
				m = tmp;
			}
		}
	}
}
