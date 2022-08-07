package ssafy.algorithm.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PG_무지의먹방라이브_2 {
	
	static long l, t, prev;
	static int idx;

	public static int main(int[] food_times, long k) {
		int result = 0;
		
		long tmp_sum = 0;
		
		// 최소힙에 음식 정보를 넣었고, 시간이 적은 순으로 정렬된다.
		PriorityQueue<Tuple> pq = new PriorityQueue<>();
		for (int i = 0; i < food_times.length; i++) {
			tmp_sum += food_times[i];
			pq.add(new Tuple(i + 1, food_times[i]));
		}
		
		if (k >= tmp_sum) return -1;		// 중요한 포인트
		
		prev = 0;
		
		while (true) {
			// 가장 짧은 시간, 누적 시간, 음식 종류, 
			t = pq.peek().getTime() - prev;	// time 변수를 사용하면서 뭔가 문제가 있었음. 최대한 불필요한 변수를 줄여서 로직 연산 과정을 이해하도록
			l = pq.size();
			long tmp = t * l;
			
			if (k >= tmp) {
				k -= tmp;
				prev = pq.peek().getTime();
				pq.poll();
				
			} else {
				break;
			}
		}
		
		List<Tuple> tl = new ArrayList<>();
		while (!pq.isEmpty()) {
			tl.add(pq.poll());
		}
		
		Collections.sort(tl, (o1, o2) -> o1.getNumber() - o2.getNumber());
		
		idx = (int) (k % tl.size());
		
		result = tl.get(idx).getNumber();
		
		return result;

	}
	
	static class Tuple implements Comparable<Tuple> {
		private int number;
		private int time;
		
		public Tuple() {}
		
		public Tuple(int number, int time) {
			this.number = number;
			this.time = time;
		}
		
		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		@Override
		public int compareTo(Tuple o) {
			return this.time - o.time;
		}
		
		@Override
		public String toString() {
			return "Tuple [number=" + number + ", time=" + time + "]";
		}
	}

}
