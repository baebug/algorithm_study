package ssafy.algorithm.etc;

import java.util.Arrays;

public class Average {

	public static void main(String[] args) {
		int[] su = {45, 80, 68, 19, 34, 55, 27, 60, 27, 18};
		
		double avg = Arrays.stream(su).average().getAsDouble();
		int max = Arrays.stream(su).max().getAsInt();
		System.out.printf("%.1f %d", avg, max);

	}

}
