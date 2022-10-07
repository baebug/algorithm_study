package ssafy.algorithm.basic;

import java.util.Arrays;

// binarySearch 이전에 반드시 search 의 대상 Collection 이 정렬되어 있어야 한다.
public class BASIC_BinarySearch {

	public static void main(String[] args) {
		int[] input = {1, 5, 7, 10, 13};
		
		System.out.println(Arrays.binarySearch(input, 0, 3, 12));
		System.out.println(Arrays.binarySearch(input, 2, 4, 8));
		System.out.println(Arrays.binarySearch(input, 2, 4, 1));	// 앞에 안나온 값(from idx 때문에) 포함

		
		Node[] list = {new Node(1, 3), new Node(5, 2), new Node(3, 7), new Node(2, 4)};
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));
		
		System.out.println(Arrays.binarySearch(list, new Node(3, 4)));
		
		Arrays.sort(list, (n1, n2) -> n1.y - n2.y);
		System.out.println(Arrays.toString(list));
		System.out.println(Arrays.binarySearch(list, new Node(3, 4)));
	}
	
	static class Node implements Comparable<Node>{
		int y, x;
		
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.x - o.x;
		}
		
	}

}
