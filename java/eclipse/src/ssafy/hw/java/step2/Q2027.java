package ssafy.hw.step2;

import java.util.Scanner;

public class Q2027 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] spd = new int[n];
		int[] height = new int[n];
		
		for(int i = 0; i < n; i++) {
			spd[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			height[i] = sc.nextInt();
		}
		
		sc.close();
		
		double dV = 0;
		double dH = 0;
		
		for(int i = 0; i < n-4; i++) {
			dH = height[i] - height[i+4];
			dV = (spd[i] + spd[i+1] + spd[i+2] + spd[i+3]) / 4;
			
			if (dH >= 4000 && dV >= 900) {
				System.out.println(i + 5);
				return;
			}
		}
		
		for(int i = 0; i < n-3; i++) {
			dH = height[i] - height[i+3];
			dV = (spd[i] + spd[i+1] + spd[i+2]) / 3;
			
			if (dH >= 3000 && dV >= 1000) {
				System.out.println(i + 4);
				return;
			}
		}
		
		for(int i = 0; i < n-2; i++) {
			dH = height[i] - height[i+2];
			dV = (spd[i] + spd[i+1]) / 2;
			
			if (dH >= 2000 && dV >= 1100) {
				System.out.println(i + 3);
				return;
			}
		}
		
		System.out.println(-1);
	}

}

