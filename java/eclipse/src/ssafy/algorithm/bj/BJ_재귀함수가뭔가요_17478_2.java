package ssafy.algorithm.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_재귀함수가뭔가요_17478_2 {

	static int n;
	static String[] MSG_ARRAY = 
		{
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
		};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		
		print(0);
		
		System.out.println(sb);
		
	}
	
	static void print(int depth) {
		if (depth == n) {
			for (int i = 0; i < depth; i++) sb.append("____");
			sb.append("\"재귀함수가 뭔가요?\"\n");
			
			for (int i = 0; i < depth; i++) sb.append("____");
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			
			for (int i = 0; i < depth; i++) sb.append("____");
			sb.append("라고 답변하였지.\n");
			
			return;
		}
		
		for (int i = 0; i < depth; i++) sb.append("____");
		sb.append("\"재귀함수가 뭔가요?\"\n");
		
		for (int k = 0; k < MSG_ARRAY.length; k++) {
			for (int i = 0; i < depth; i++) sb.append("____");
			sb.append(MSG_ARRAY[k] + "\n");
		}
		
		print(depth + 1);
		
		for (int i = 0; i < depth; i++) sb.append("____");
		sb.append("라고 답변하였지.\n");
		
	}

}
