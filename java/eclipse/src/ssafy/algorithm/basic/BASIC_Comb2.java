package ssafy.algorithm.basic;

import java.util.Arrays;

public class BASIC_Comb2 {
	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	
	public static void main(String[] args) {
		comb(0, 0);	// 앞 src, 뒤 tgt
		System.out.println(COUNT);
	}
	
	static void comb(int srcIdx, int tgtIdx) {	// srcIdx 를 tgtIdx 에 넣는다, 안넣는다.
		
		// 기저조건
		if (tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		if (srcIdx == src.length) return;

		// 선택
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx+1, tgtIdx+1);	// 현재 선택을 만족, 다음 선택을 하러 재귀
		comb(srcIdx+1, tgtIdx);		// 현재 선택을 만족 X
		
	}
	

}
