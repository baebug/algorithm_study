package ssafy.hw.step2;

import java.util.Scanner;

public class Q2028 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] price = new int[n];
		int[] score = new int[n];
		
		for(int i = 0; i < n; i++) {
			price[i] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i = 0; i < n; i++) {
			int cnt = 1;
			for(int p : price) {
				if (p > price[i]) {
					cnt++;
				}
			}
			score[i] = cnt;
		}
		
		for(int x : score) {
			System.out.print(x + " ");
		}

	}

}
