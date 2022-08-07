package ssafy.algorithm.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덩치 = 키 & 몸무게 = 등수
// 각 사람의 덩치를 계산하여라
public class BJ_덩치_7568 {

	static int N;
	static int[] rank;
	static Person[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		input = new Person[N];
		rank = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(stk.nextToken());
			int h = Integer.parseInt(stk.nextToken());
			
			input[i] = new Person(w, h);
			rank[i] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			int curW = input[i].w;
			int curH = input[i].h;
			for (int j = 0; j < N; j++) {
				if (input[j].w > curW && input[j].h > curH) {
					rank[i]++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(rank[i] + " ");
		}
		
		System.out.println(sb);
	}
	
	static class Person {
		int w; // weight
		int h; // height
		
		Person(int w, int h) {
			this.w = w;
			this.h = h;
		}
	}
	
}
