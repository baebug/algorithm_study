package ssafy.algorithm.basic;

import java.util.Arrays;

public class BASIC_Perm {
	
	static int COUNT = 0;
	static int[] src = { 1, 2, 3, 4, 5 };
	static int[] tgt = new int[3];
	
	// 중복을 허용하지 않는 순열
	// 포인트 : tgt 에 중복이 생기지 않도록 (이미 뽑은 index(수)는 다시 뽑지 않는다.)
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		perm(0);	//
		System.out.println(COUNT);
	}
	
	static void perm(int tgtIdx) {
		// 순열이 완성 (기저조건)
		// 현재 호출 전까지 이미 마무리
		if (tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		// tgt 는 현재 tgtIdx 에, src 모든 수를 고려한다. ( 0 ~ src.length-1 )
		for (int i = 0; i < src.length; i++) {
			// 이미 이전 tgt 에 선택된 인덱스(수)는 제외
			if(select[i]) continue;
			
			// 선택
			tgt[tgtIdx] = src[i];
			select[i] = true;
			
			// 다음 자리 tgt 를 채우기
			perm(tgtIdx + 1);	// 이 재귀호출이 끝나면 for 문의 다음 i 로 이동한다.
			
			// 다음 i 의 src 를 고려하기 위해
			select[i] = false;
		}
	}

}
