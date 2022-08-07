package ssafy.algorithm.set;

import java.io.*;
import java.util.*;

// 원소의 개수 20만, 값 1억 이하
// A-B 합 B-A
public class BJ_대칭차집합_1269 {

	static int A, B, cnt;
	static int[] arrA, arrB;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		
		Set<Integer> set = new HashSet<>();
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			set.add(Integer.parseInt(stk.nextToken()));
		}
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			set.add(Integer.parseInt(stk.nextToken()));
		}
		
		// A합B - A교B = 2(A합B) - A - B
		System.out.println(2 * set.size() - A - B);
		
	}
}
