package ssafy.hw.step1;

import java.util.Arrays;
import java.util.Scanner;

public class Q2022 {

	public static void main(String[] args) {
		String[] a = new String[] {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
		String[] b = new String[] {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
		String[] arr = new String[60];
		
		for (int i = 0; i < 60; i++) {
				arr[i] = a[Math.floorMod(i, 10)] + b[Math.floorMod(i, 12)];
		}
		
		Scanner sc = new Scanner(System.in);
		
		String input = "";
		
		while (!(Arrays.asList(arr).contains(input))) {
			System.out.print("60갑자를 입력하세요: ");
			input = sc.next();
			if (input.equals("종료")) {
				sc.close();
				return;
			}
		}
		
		sc.close();
		
		int t = 0;
		
		for(int idx = 0; idx < 60; idx++) {
			if (arr[idx].equals(input)) {
				t = 1444 + idx;
				break;
			}
		}
		
		for(int i = t; i <= 2100; i+= 60) {
			if (i >= 1800) {
				System.out.print(i + " ");
			}
		}
		
	}

}
