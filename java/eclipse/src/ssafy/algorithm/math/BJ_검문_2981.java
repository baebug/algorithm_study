package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

// 숫자 N 개를 M 으로 나누었을 때, 나머지가 같게 되는 M 을 찾으려 한다. (M > 1)
// N 이 주어지면, 가능한 M 을 모두 찾아라. (N 최대 10억)
// 1 ~ 10억의 수 100개
// 
public class BJ_검문_2981 {

	static int N;
	static int[] input, result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);
		
		List<Integer> tl = new ArrayList<>();
		// 모든 수에서 이전 수를 뺀다 --> 1이 아니라면 tl 에 넣은 뒤 정렬한다.
		for (int i = 1; i < N; i++) {
			int tmp = input[i] - input[i-1];
			if (tmp != 1) tl.add(tmp);
		}
		Collections.sort(tl);
		
		
		int gcd = tl.get(0);
		for (int i = 1; i < tl.size(); i++) {
			gcd = getGcd(gcd, tl.get(i));
		}
		
		// 구한 최대 공약수의 모든 약수를 구해서 sb 에 넣는다.
		for (int i = 2; i*i <= gcd; i++) {
			if (gcd % i == 0) sb.append(i + " ");
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
