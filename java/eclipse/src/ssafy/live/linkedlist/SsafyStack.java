package ssafy.live.linkedlist;

public class SsafyStack<E> implements IStack<E> {

	private Node<E> top;
	
	@Override
	public void push(E data) {
		top = new Node<E>(data, top);
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가능합니다.");
			return null;
		}
		
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가능합니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0;
		if (isEmpty()) {
			return cnt;
		}
		for (Node<E> tmp = top; tmp != null ; tmp = tmp.link) {
			++cnt;
		}
		
		return 0;
	}
	
}
