package ssafy.hw.step6.Q2011;

public class BookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
	
	public void add(Book book) {
		if (this.size < MAX_SIZE) {
			books[this.size] = book;
			this.size++;
		} else {
			System.out.println("최대 도서 수 도달");
		}
	}
	
	// 순서를 보장안하는 기준으로, 특정 isbn 을 찾으면 맨 끝의 책으로 덮어버린다.
	public void remove(String isbn) {
		for (int i = 0; i < this.size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				books[i] = books[this.size - 1];
				books[this.size - 1] = null;
				this.size--;
			}
		}
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
	
	public Book[] searchByTitle(String title) {
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (books[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		
		Book[] tmpList = new Book[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (books[i].getTitle().contains(title)) {
				tmpList[idx++] = books[i];
			}
		}
		return tmpList;
	}
	
	public Magazine[] getMagazines() {
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (books[i] instanceof Magazine) {
				cnt++;
			}
		}
		
		Magazine[] tmpList = new Magazine[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (books[i] instanceof Magazine) {
				tmpList[idx++] = (Magazine) books[i];
			}
		}
		
		return tmpList;
	}
	
	public Book[] getBooks() {
		int cnt = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (!(books[i] instanceof Magazine)) {
				cnt++;
			}
		}
		
		Book[] tmpList = new Book[cnt];
		int idx = 0;
		
		for (int i = 0; i < this.size; i++) {
			if (!(books[i] instanceof Magazine)) {
				tmpList[idx++] = books[i];
			}
		}
		
		return tmpList;
	}
	
	public int getTotalPrice() {
		int total = 0;
		
		for (int i = 0; i < this.size; i++) {
			total += books[i].getPrice();
		}
		
		return total;
	}
	
	public double getPriceAvg() {
		return this.getTotalPrice() / this.size;
	}
	
}
