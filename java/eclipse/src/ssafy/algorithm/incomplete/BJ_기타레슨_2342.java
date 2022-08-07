package ssafy.algorithm.incomplete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블루레이 N개의 강의 --> 순서가 바뀌면 안된다.
// 블루레이 M개 일 때, 최소 크기
public class BJ_기타레슨_2342 {

	static int N, M, result;
	static int[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		input = new int[N];
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(stk.nextToken());
		}
		result = Integer.MAX_VALUE;
		
		System.out.println(result);
	}
	
	
}
