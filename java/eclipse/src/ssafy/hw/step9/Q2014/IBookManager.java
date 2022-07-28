package ssafy.hw.step9.Q2014;

public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	Book[] getList();
	Book searchByIsbn(String isbn);
	Book[] searchByTitle(String title);
	Magazine[] getMagazines();
	Book[] getBooks();
	int getTotalPrice();
	double getPriceAvg();
	
	void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
}
