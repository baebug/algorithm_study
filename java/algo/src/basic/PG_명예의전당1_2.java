package basic;

import java.util.PriorityQueue;

public class PG_명예의전당1_2 {
    public int[] solution(int k, int[] score) {
        int size = score.length;
        int[] answer = new int[size];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<size; i++) {
            pq.add(score[i]);
            if (pq.size() > k) pq.remove();

            answer[i] = pq.peek();
        }

        return answer;
    }
}
