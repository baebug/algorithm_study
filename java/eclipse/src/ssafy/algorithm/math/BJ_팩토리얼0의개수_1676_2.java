package ssafy.algorithm.math;

import java.io.*;
import java.util.*;

public class BJ_팩토리얼0의개수_1676_2 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int cnt2 = getCnt2(N);
		int cnt5 = getCnt5(N);
		
		System.out.println(Math.min(cnt2, cnt5));
		
		
	}
	
	static int getCnt2(int num) {
		int cnt = 0;
		long tmp = 2;
		while (tmp <= num) {
			cnt += (int) num / tmp;
			tmp *= 2;
		}
		
		return cnt;
	}
	
	static int getCnt5(int num) {
		int cnt = 0;
		long tmp = 5;
		while (tmp <= num) {
			cnt += (int) num / tmp;
			tmp *= 5;
		}
		
		return cnt;
	}

}
