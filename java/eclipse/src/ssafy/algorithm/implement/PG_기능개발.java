package ssafy.algorithm.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG_기능개발 {

	public static void main(String[] args) {
		// 테스트용 데이터
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};

		
		// Math.ceil((100 - prog)/speeds) 으로 각 작업의 완료 시점을 구해준다.
		int n = progresses.length;
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			ends[i] = (int) Math.ceil(1.0 * (100 - progresses[i]) / speeds[i]);
		}
		
		// 작업 완료 시점을 비교할 변수, 결과를 저장할 List 생성
		List<Integer> result = new ArrayList<>();
		int tmp = ends[0];
		int cnt = 0;
		
		/**
		 *  현재 가지고 있는 작업 완료 시점보다 큰 값을 발견하기 전까지는 모두 한 번에 배포할 수 있다.
		 *  cnt 를 늘려나가다가, 큰 값을 발견하면 List 에 저장
		 */
		for (int i = 0; i < n; i++) {
			if (tmp < ends[i]) {
				result.add(cnt);
				tmp = ends[i];
				cnt = 1;
			} else {
				cnt++;
			}
		}
		
		// 마지막 작업에 대한 cnt 추가
		result.add(cnt);
		
		// return 할 배열 생성, List 의 타입은 Integer 라 toArray() 사용 불가
		int[] answer =  new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		// stream 을 이용해 int[] 로 바꾸는 방법
		// int[] answer = result.stream().mapToInt(i -> i).toArray();
		
		System.out.println(Arrays.toString(answer));
		System.out.println(Arrays.toString(progresses));
		System.out.println(Arrays.toString(speeds));
		System.out.println(Arrays.toString(ends));
		// return answer;
	}

}
