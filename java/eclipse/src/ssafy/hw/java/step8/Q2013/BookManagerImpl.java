package ssafy.hw.step8.Q2013;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private List<Book> books = new ArrayList<>();
	
	private static IBookManager bookManager = new BookManagerImpl();
	
	private BookManagerImpl() {}
	
	public static IBookManager getInstance() {
		return bookManager;
	}
	
	public void add(Book book) {
		books.add(book);
	}
	
	public void remove(String isbn) {
		books.removeIf(b -> b.getIsbn().equals(isbn));
	}
	
	public Book[] getList() {
		Book[] tmpList = new Book[books.size()];
		books.toArray(tmpList);
		return tmpList;
	}
	
	public Book searchByIsbn(String isbn) {
		
		for (Book b : books) {
			if (b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		
		return null;
	}
	
	public Book[] searchByTitle(String title) {
		List<Book> tmpList = new ArrayList<>();
		
		for (Book b : books) {
			if (b.getTitle().contains(title)) {
				tmpList.add(b);
			}
		}
		
		Book[] result = new Book[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public Magazine[] getMagazines() {
		List<Magazine> tmpList = new ArrayList<>();
		
		for (Book b : books) {
			if (b instanceof Magazine) {
				tmpList.add((Magazine) b);
			}
		}
		
		Magazine[] result = new Magazine[tmpList.size()];
		tmpList.toArray(result);
		
		return result;
	}
	
	public Book[] getBooks() {
		List<Book> tmpList = new ArrayList<>();
		
		for (Book b : books) {
			if (!(b instanceof Magazine)) {
				tmpList.add(b);
			}
		}
		
		Book[] result = new Book[tmpList.size()];
		tmpList.toArray(result);
		return result;
	}
	
	public int getTotalPrice() {
		int total = 0;
		
		for (Book b : books) {
			total += b.getPrice();
		}
		
		return total;
	}
	
	public double getPriceAvg() {
		return this.getTotalPrice() / books.size();
	}
	
}
