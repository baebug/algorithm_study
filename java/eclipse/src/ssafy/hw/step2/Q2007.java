package ssafy.hw.step2;

import java.util.Scanner;

public class Q2007 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			for(int idx = a; idx <= n+1; idx += a) {
				if (arr[idx] == 0) {
					arr[idx] = 1;
				} else {
					arr[idx] = 0;
				}
			}
			
		}
		
		sc.close();
		
		for(int i = 1; i < n+1; i++) {
			System.out.print(arr[i] + " ");
		}
		

	}

}

