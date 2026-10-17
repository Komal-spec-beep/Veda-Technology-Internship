package day16.librarymanagement;

public class Book {

	int bookID;
	String bookName;
	String authorName;
	boolean isBookAvailable;
	
	Book(int bookID, String bookName, String authorName, boolean isBookAvailable) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.authorName = authorName;
		this.isBookAvailable = isBookAvailable;
	}
}
