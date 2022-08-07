package ssafy.algorithm.incomplete;

import java.io.*;
import java.util.*;

// 숫자 N 개를 M 으로 나누었을 때, 나머지가 같게 되는 M 을 찾으려 한다. (M > 1)
// N 이 주어지면, 가능한 M 을 모두 찾아라. (N 최대 10억)
public class BJ_검문_2981 {

	static int N;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);
		
		// M 은 제일 작은 수 보다 클 수 없다?
		for (int m = 2; m <= input[N-1]; m++) {
			int tmp = input[0] % m;
			for (int i = 0; i < N; i++) {
				if (input[i] % m != tmp) break;
				if (i == N-1) sb.append(m + " ");
			}
		}
		
		System.out.println(sb);
	}
}
