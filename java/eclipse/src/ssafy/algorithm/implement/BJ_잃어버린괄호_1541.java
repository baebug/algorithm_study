package ssafy.algorithm.implement;

import java.io.*;
import java.util.*;

// 무조건 더하기 먼저하면 최소?
public class BJ_잃어버린괄호_1541 {
	
	static StringBuilder sb = new StringBuilder();
	static List<Integer> nums;
	static List<Character> ops;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		nums = new ArrayList<>();
		ops = new ArrayList<>();
		
		String s = br.readLine();
		
		int st = 0;
		for (int i = 0, size = s.length(); i < size; i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				nums.add(Integer.parseInt(s.substring(st, i)));
				ops.add(s.charAt(i));
				st = i+1;
			}
		}
		nums.add(Integer.parseInt(s.substring(st, s.length())));
		
		calcPlus();
		calcMinus();
		System.out.println(nums.get(0));
		
	}
	
	static void calcMinus() {
		int idx = 0;
		while (nums.size() > 1) {
			ops.remove(idx);
			int a = nums.remove(idx+1);
			nums.set(idx, nums.get(idx)-a);
		}
	}
	
	static void calcPlus() {
		int idx = ops.size()-1;
		while (idx >= 0) {
			if (ops.get(idx) == '+') {
				ops.remove(idx);
				int a = nums.remove(idx+1);
				nums.set(idx, nums.get(idx)+a);
				idx--;
			} else if (ops.get(idx) == '-') {
				idx--;
			}
		}
	}				
}
