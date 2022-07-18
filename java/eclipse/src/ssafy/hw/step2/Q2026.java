package ssafy.hw.step2;

import java.util.Scanner;

public class Q2026 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		sc.close();
		
		int max = -1;
		int last = nums[n-1];
		int tmp = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			max = Math.max(max, nums[i]);
		}
		for(int i = n-1; i >= 0; i--) {
			if (nums[i] < last) {
				tmp = nums[i];
				break;
			}
		}
		
		if (tmp == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(max - tmp);
		}
		
	}

}
