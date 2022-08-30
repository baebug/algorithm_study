package ssafy.hw.step1;

import java.util.Scanner;

public class Q2020 {

	public static void main(String[] args) {
		
		int[] arr = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("월과 일을 입력하세요.");
		int m = sc.nextInt();
		int d = sc.nextInt();
		
		sc.close();
		
		int date = 0;
		
		for(int i = 0; i < m; i++) {
			date += arr[i];
		}
		date += d;
		
		System.out.println(m + "월 " + d + "일은 " + date + "번째 날입니다.");
	}

}
