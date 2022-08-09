package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

public class BJ_알고리즘수업_너비우선탐색1_24444 {

	static int N, M, R, idx;
	static int[] node;		// 정점 집합
	static List<Integer>[] child;	// 간선 집합
	static int visited[];
	static Deque<Integer> dq;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		visited = new int[N+1];			// index 0 : dummy
		dq = new ArrayDeque<>();

		// 노드에 연결된 간선 정보를 저장하기 위해 동적자료구조(list) 를 넣어줌
		child = new ArrayList[N+1];		// index 0 : dummy
		for (int i = 0; i < N+1; i++) {
			child[i] = new ArrayList<>();
		}
		
		// 무방향그래프이므로 간선의 정보를 받으면 양쪽에 방문할 수 있는 노드를 넣어준다.
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			child[a].add(b);
			child[b].add(a);
		}
		
		// 간선의 집합 (child 에 들어있는 배열 정렬하기)
		for (int i = 1; i < N+1; i++) {
			Collections.sort(child[i]);
		}
		
		idx = 1;
		// 시작 정점을 dq 에 넣는다.
		dq.addLast(R);
		visited[R] = idx++;
		
		// dq 의 맨 앞에 있는 노드와 연결된 노드 중 방문하지 않은 노드를 차례로 dq 에 넣는다. --> dq 가 빌 때까지
		while (!dq.isEmpty()) {
			int cur = dq.peekFirst();
			for (int i : child[cur]) {
				if (visited[i] == 0) {
					dq.addLast(i);
					visited[i] = idx++;
				}
			}
			dq.removeFirst();
		}
		
		// R 에서 각 노드를 방문하는 순서를 출력, 방문할 수 없는 경우 0을 출력한다. 배열과 idx 를 들고가면서 찍어준다.
		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]).append('\n');
		}
		
		System.out.print(sb);
	}
	
}
