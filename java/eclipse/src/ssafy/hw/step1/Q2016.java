package ssafy.hw.step1;

import java.util.Scanner;

public class Q2016 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		
		while (n != 0) {
			for(int i = 1; i < 10; i++) {
				System.out.println(n + " * " + i + " = " + n * i);
			}
			
			System.out.print("다음 숫자 입력 : ");
			n = sc.nextInt();
		}
		
		sc.close();
		System.out.println("프로그램 종료");
		
	}

}
