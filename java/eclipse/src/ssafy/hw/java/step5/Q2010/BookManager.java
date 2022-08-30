package ssafy.hw.step5.Q2010;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
	
	public void add(Book book) {
		if (this.size < MAX_SIZE) {
			books[this.size] = book;
			this.size++;
		} else {
			System.out.println("최대 도서 수 도");
		}
	}
	
	public void remove(String isbn) {
		Book[] newList = new Book[MAX_SIZE];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (!(books[i].getIsbn().equals(isbn))) {
				newList[idx] = books[i];
				idx++;
			}
		}
		
		this.books = newList;
		this.size--;
	}
	
	public Book[] getList() {
		
		Book[] tmpList = new Book[this.size];
		
		for (int i = 0; i < this.size; i++) {
			tmpList[i] = books[i];
		}
		
		return tmpList;
	}
	
	public Book searchByIsbn(String isbn) {
		
		for (int i = 0; i < this.size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		
		return null;
	}
}
