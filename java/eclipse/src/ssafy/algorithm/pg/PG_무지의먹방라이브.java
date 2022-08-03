package ssafy.algorithm.pg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PG_무지의먹방라이브 {

	static int l, time, t, idx, prev;
	
	public static void main(String[] args) {
		// int[] food_times, long k 주어진다.
		int[] food_times = {3, 1, 2};
		long k = 5;
		int result = 0;
		
		// 최소힙에 음식들을 담는다.
		PriorityQueue<Tuple> pq = new PriorityQueue<>();
		for (int i = 0; i < food_times.length; i++) {
			pq.add(new Tuple(i+1, food_times[i]));
		}
		
		// pq 에는 음식을 먹는데 걸리는 시간이 적은 순으로 정렬된다.
		// 남은 시간 >= 시간이 가장 조금 걸리는 음식의 시간 * 음식의 종류 --> 모든 음식 - 시간이 가장 조금 걸리는 음식의 시간 가능
		// 제일 시간이 조금 걸리는 음식을 제외하면서 누적 시간을 쌓는다.
		// 최종적으로 남은(누적시간보다 time 이 높은) 음식들을 List 로 만들고, 번호순으로 정렬한다.
		time = 0;
		l = pq.size();
		
		while (true) {
			t = pq.peek().getTime();
			long tmp = t - prev;
			
			if (l == 0) {
//				return -1;
				System.out.println(-1);
			}
			
			// 최소 시간 * 길이보다 시간이 많이 남았으면, 경과가 가능하다. -> 남은 애들의 시간은 t 보다 큼이 보장된다.
			if (k >= tmp * l) {
				k -= tmp * l;
				prev = time;		// prev : 이전까지의 누적 값
				time += tmp;		// t - prev : 이번 루프에서 짧은 시간, time : 총 누적
				l--;
				pq.poll();
			} else {
				break;
			}
		}
		
		List<Tuple> tl = new ArrayList<>();
		
		while (pq.size() > 0) {
			tl.add(pq.poll());
		}
		
//		for (int i = 0; i < tl.size(); i++) {
//			Tuple tp = tl.get(i);
//			tp.setTime(tp.getTime() - time);
//		}
		
		Collections.sort(tl, (o1, o2) -> o1.getNumber() - o2.getNumber());
		idx = (int) k % tl.size();
		
		result = tl.get(idx).getNumber();
		System.out.println(result);
//		return result;
	}

}
