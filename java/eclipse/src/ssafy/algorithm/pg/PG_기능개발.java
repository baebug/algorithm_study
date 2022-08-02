package ssafy.algorithm.pg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG_기능개발 {

	public static void main(String[] args) {
		// 작업 진행도 배열 progresses
		// 작업속도 배열 speeds
		// Math.ceil((100 - prog)/speeds) 하면 작업완료 시점 나옴.
		// 5 4 1 6 4 1 10
		// 정답 List , 비교대상 tmp
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		int n = progresses.length;
		int[] ends = new int[n];
		
		for (int i = 0; i < n; i++) {
			ends[i] = (int) Math.ceil(1.0 * (100 - progresses[i]) / speeds[i]);
		}
		
		List<Integer> result = new ArrayList<>();
		int tmp = ends[0];
		
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if (tmp < ends[i]) {
				result.add(cnt);
				cnt = 1;
			} else {
				cnt++;
			}
		}
		
		result.add(cnt);
		
		
		int[] answer =  new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		System.out.println(Arrays.toString(answer));
		System.out.println(Arrays.toString(progresses));
		System.out.println(Arrays.toString(speeds));
		System.out.println(Arrays.toString(ends));
//		return answer;
	}

}
