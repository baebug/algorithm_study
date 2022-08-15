package ssafy;

import java.util.ArrayList;
import java.util.List;

public class Test {

	static List<List<Integer>> child1;
	static List<Integer>[] child2;
	
	public static void main(String[] args) {
		child1 = new ArrayList<List<Integer>>();
		for (int i = 0; i < 5; i++) {
			child1.add(new ArrayList<>());
		}
		child1.get(2).add(3);
		child1.get(2).add(4);
		
		child2 = new ArrayList[5];
		
		for (int i = 0; i < 5; i++) {
			child2[i] = new ArrayList<>();
		}
		child2[2].add(3);
		child2[2].add(4);
		
		System.out.println(child1.get(2));
		System.out.println(child2[2]);
		
		System.out.println((1<<3) - 1);
	}

}
