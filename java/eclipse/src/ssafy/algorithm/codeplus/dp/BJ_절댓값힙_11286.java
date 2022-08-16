package ssafy.algorithm.codeplus.dp;

import java.io.*;
import java.util.*;

public class BJ_절댓값힙_11286 {
	
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Math.abs(i1) == Math.abs(i2) ? i1 - i2 : Math.abs(i1) - Math.abs(i2));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) { // 꺼내서 출력, 없으면 null 0 출력
				Integer min = pq.poll();
				System.out.println(min == null ? 0 : min);
				
			} else pq.offer(num);
		}
	}

}
