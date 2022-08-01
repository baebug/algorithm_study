package ssafy.algorithm.etc;

public class Hanoi_basic {

	static int hanoi(int n, int st, int ed) {
		if (n == 1) return 1;
		
		int tmp = 6 - st - ed;
		
		return hanoi(n-1, st, tmp) + 1 + hanoi(n-1, tmp, ed);
		
	}
	
	public static void main(String[] args) {
		// 하노이탑에 n개의 원판이 있을 때, 최소 이동 횟수를 출력하여라.
		System.out.println(hanoi(6, 1, 2));

	}

}
