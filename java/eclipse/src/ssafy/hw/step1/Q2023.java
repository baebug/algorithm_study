package ssafy.hw.step1;

import java.util.Scanner;

public class Q2023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int min = Math.abs(a - b);
		boolean btn = false; 
		
		for(int x : arr) {
			if (min > Math.abs(x - b)) {
				min = Math.abs(x - b);
				btn = true;
			}
		}
		
		if (btn) {
			min = min + 1;
		}
		
		if (min > 600) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

}
