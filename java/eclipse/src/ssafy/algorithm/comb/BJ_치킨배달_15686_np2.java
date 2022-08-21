package ssafy.algorithm.comb;

import java.io.*;
import java.util.*;

// NP + Comb + Memoization
public class BJ_치킨배달_15686_np2 {
	
	static int N, M, min = Integer.MAX_VALUE;
	static List<int[]> house, src;
	
	static int[] index;		// np() 에 의해 가장 작은 값 --> 가장 큰 값으로 갱신되어가는 배열, src 에서 어느 인덱스가 선택되었는지 표현
	static int[][] memoi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		house = new ArrayList<>();
		src = new ArrayList<>();
		
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		// input 처리를 하면서 house, chicken 집의 번호를 구한다.
		int houseNo = 0;
		int chickenNo = 0;
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(stk.nextToken());
				if (tmp == 1) house.add(new int[] {houseNo++, i, j});
				else if (tmp == 2) src.add(new int[] {chickenNo++, i, j});
			}
		}
		
		// houseNo, chickenNo --> 집과 치킨집의 수
		memoi = new int[houseNo][chickenNo];
		
		for (int i = 0; i < houseNo; i++) {
			for (int j = 0; j < chickenNo; j++) {
				memoi[i][j] = Math.abs(house.get(i)[1]-src.get(j)[1]) + Math.abs(house.get(i)[2]-src.get(j)[2]); 
			}
		}
		
		// np + comb 위한 index 배열 생성
		int srcSize = src.size();
		index = new int[srcSize];
		for (int i = srcSize - M; i < srcSize; i++) {
			index[i] = 1;
		}
		
		while (true) {
			
			int sum = 0;
			for(int[] h : house) {
				int dist = Integer.MAX_VALUE;
				for (int i = 0; i < index.length; i++) {
					if (index[i] == 1) {
						dist = Math.min(dist, memoi[h[0]][src.get(i)[0]]);
					}
				}
				sum += dist;
			}
			
			min = Math.min(min, sum);
			
			
			if (!np()) break;
		}
		
		
		System.out.println(min);
		
	}
	
	static boolean np() {
		int[] src = index;
		int i = src.length - 1;
		
		while(i>0 && src[i-1] >= src[i]) --i;
		
		if (i == 0) return false;
		
		int j = src.length - 1;
		while(i>0 && src[i-1] >= src[j]) --j;
		
		swap(src[i-1], src[j]);
		
		int k = index.length;
		
		while(i<k) {
			swap(src[i], src[k]);
			i++;
			k--;
		}
		
		return true;
	}
	
	static void swap(int i, int j) {
		int tmp = j;
		j = i;
		i = tmp;
	}

}
