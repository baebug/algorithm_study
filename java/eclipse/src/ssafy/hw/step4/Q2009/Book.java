package ssafy.hw.step4.Q2009;

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	
	public Book() {}
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return this.isbn + "\t| " + this.title + "\t| " + this.author + "\t| " + this.publisher + "\t| " + this.price + "\t| " + this.desc;
	}
	
	
}
