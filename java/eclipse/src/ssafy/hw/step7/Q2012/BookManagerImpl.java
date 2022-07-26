package ssafy.hw.step7.Q2012;

import java.util.Arrays;

public class BookManagerImpl implements IBookManager {
	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;
	
	private static IBookManager bookManager = new BookManagerImpl();
	
	private BookManagerImpl() {}
	
	public static IBookManager getInstance() {
		return bookManager;
	}
	
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
		return Arrays.copyOfRange(books, 0, size);
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
