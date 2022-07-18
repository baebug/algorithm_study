package ssafy.hw.step2;

import java.util.Scanner;

public class Q2017 {

	public static void main(String[] args) {
		int[] arr = new int[] {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		
		System.out.println("-----원소 10개 출력-----");
		for(int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		System.out.println("-----원소 10개 중 짝수만 출력-----");
		for(int x : arr) {
			if ((x & 1) == 0) {
				System.out.print(x + " ");
			}
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("-----바꿀 위치 입력 : ");
		int idx = sc.nextInt();
		System.out.print("-----수 입력 : ");
		int num = sc.nextInt();
		
		sc.close();
		
		arr[idx] = num;
		
		System.out.println("-----원소 10개 출력-----");
		for(int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		

	}

}
