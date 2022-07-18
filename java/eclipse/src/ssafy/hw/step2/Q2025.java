package ssafy.hw.step2;

import java.util.Scanner;

public class Q2025 {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		
		for(int x : arr) {
			System.out.print(x);
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] foods = new String[n];
		
		for(int i = 0; i < n; i++) {
			foods[i] = sc.next(); 
		}
		
		sc.close();
		
		for(String x : foods) {
			System.out.println(x);
		}

	}

}
