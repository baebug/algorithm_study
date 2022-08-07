package ssafy.algorithm.set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수가 적혀있는 카드 N개
// 정수 M개에 대해 각 카드를 몇장 가지고 있는지
// 크기가 정해져있으면 배열이 좋지만, 이런 상황에서는 Map 을 사용
// 숫자 카드에 적혀 있는 수는 -천만  ~ + 천만 --> 배열 생성 가능
public class BJ_숫자카드2_10816_2 {

	static int N, M;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[20_000_001];
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(stk.nextToken());
			input[num + 10_000_000]++;
		}
		
		M = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(stk.nextToken());
			sb.append(input[num + 10_000_000] + " ");
		}
		
		System.out.println(sb);
		
	}
	
}
