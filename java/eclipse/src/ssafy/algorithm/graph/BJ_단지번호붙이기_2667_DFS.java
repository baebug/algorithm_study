package ssafy.algorithm.graph;

import java.io.*;
import java.util.*;

// 1 을 발견하면 붙어있는 모든 1 탐색&카운트
// 모든 지도에 대한 간선을 만드는 게 좋음. i, j 표기하기 어려우니 사방탐색 cnt 를 기록 후 cnt-- 하면서 남아있으면 재방문 가능하게?
// (visited & cnt == 0) 조건으로 cnt 있으면 방문은 가능하지만 visited 가 true 이므로 단지수는 추가 안하면? 그래도 고립될 수 있음
// 간선 데이터를 델타로 준다 --> (1, 2, 3, 4) 상 우 하 좌 순 ( 0은 dummy )
// 이차원 데이터를 일차원으로 표현? --> 행에 N 만큼 가중치를 준다. (N-queen 에서 쓰던데.. 가로, 세로, 대각선)
public class BJ_단지번호붙이기_2667_DFS {
	
	static int N, total, tmpCnt;
	static int[][] input;
	static List<Integer> result;
	static List<Integer>[] child;
	static boolean[] visited;
	static int[][] dt = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		child = new ArrayList[N*N+1];
		visited = new boolean[N*N+1];
		total = 0;
		result = new ArrayList<>();
		
		// 간선을 저장할 리스트 할당
		for (int i = 0; i < child.length; i++) {
			child[i] = new ArrayList<>();
		}
		
		// input 이차원배열 받아오기
		input = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();	// N 개의 0, 1 로 뜯어짐
			for (int j = 0; j < N; j++) {
				input[i][j] = row[j] - '0';
			}
		}
		
		// 배열을 순회하며 집(1)인 경우 간선데이터 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (input[i][j] == 1) search(i, j);
			}
		}
		
		// 탐색해야겠지? 집인데 방문 안 한 집을 탐색한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int idx = i * N + j;
				if (input[i][j] == 1 && !visited[idx]) {
					total++;	// 단지 수 +1
					tmpCnt = 0;
					visited[idx] = true;
					dfs(idx, 1);
					result.add(tmpCnt);
				}
			}
		}
		
		result.sort((o1, o2) -> o1 - o2);
		sb.append(total).append('\n');
		for (int i : result) {
			sb.append(i).append('\n');
		}
		System.out.println(sb);
		
	}
	
	// child[idx]의 간선 데이터를 탐색하는 데 다돌면 visited 찍고 탈출? 애초에 visited 가 의미가 있나
	// 전체 집 수를 카운트하는 파라미터
	static void dfs(int idx, int count) {
		boolean flag = true;
		for(int i : child[idx]) {	// i 에는 1, 2, 3, 4 가 들어있는데? --> index들을 넣어주자 --> 해결
			if (!visited[i]) flag = false;
		}
		if (flag) {
			visited[idx] = true;
			count++;
			tmpCnt = Math.max(count, tmpCnt);
			return;
		}
		
		for(int i : child[idx]) {
			if (visited[i]) continue;
			visited[idx] = true;
			dfs(i, count+1);
		}
		
	}
	
	static void search(int y, int x) {
		int idx = y * N + x;
		
		for (int d = 1; d <= 4; d++) {
			int ny = y + dt[d][0];
			int nx = x + dt[d][1];
			
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			
			if (input[ny][nx] == 1) {
				child[idx].add(getIndex(y, x, d));
			}
		}
	}
	
	// 내 좌표와 방향을 받아서 해당 index 를 반환하는 메소드 (d: 상 우 하 좌)
	static int getIndex(int y, int x, int d) {
		switch (d) {
			case 1: 
				return N * (y-1) + x;
			case 2:
				return N * y + x + 1;
			case 3:
				return N * (y+1) + x;
			case 4:
				return N * y + x - 1;
		}
		
		return 0;
	}
	
}
