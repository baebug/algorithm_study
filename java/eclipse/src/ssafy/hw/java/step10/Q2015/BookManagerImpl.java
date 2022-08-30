package ssafy.hw.step10.Q2015;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private List<Book> books = new ArrayList<>();
	
	private static IBookManager bookManager = new BookManagerImpl();
	
	private BookManagerImpl() {
		this.loadData();
	}
	
	private void loadData() {
		File file = new File("book.dat");
		
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				books = (List<Book>) ois.readObject();
			} catch (Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
		}
	}
	
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"))) {
			oos.writeObject(books);
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
	
	public static IBookManager getInstance() {
		return bookManager;
	}
	
	public void add(Book book) {
		books.add(book);
	}
	
	public void remove(String isbn) {
		books.removeIf(b -> b.getIsbn().equals(isbn));
	}
	
	public Book[] getList() throws NoBookException {
		if (books.size() == 0 || books == null) {
			throw new NoBookException();
		}
		
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

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		if (this.searchByIsbn(isbn) == null) {
			throw new ISBNNotFoundException(isbn);
		}
		Book book = this.searchByIsbn(isbn);
		int result = book.getQuantity() - quantity;
		
		if (result < 0) {
			throw new QuantityException();
		}
		
		book.setQuantity(result);
		
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		if (this.searchByIsbn(isbn) == null) {
			throw new ISBNNotFoundException(isbn);
		}
		
		Book book = this.searchByIsbn(isbn);
		book.setQuantity(book.getQuantity() + quantity);
		
	}
	
}
