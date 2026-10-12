public class Book {
  private int id;
  private String title;
  private String author;
  private String isbn;
  private int pages;

    // Default constructor
    public Book() {
     this.id = 0;
     this.title = "";
     this.author = "";
     this.isbn = "";
     this.pages = 0;
    }

    // Parameterized constructor
    public Book(int id, String title,
                String author, String isbn,
                int pages ) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

//get ID
public int getId() {
    return id;
}
//setID
public void setId(int id) {
    this.id = id;
}
//get title
public String getTitle() {
    return title;
}
//set title
public void setTitle(String title) {
    this.title = title;
}
//get author
public String getAuthor() {
    return author;
}
//set author
public void setAuthor(String author) {
    this.author = author;
}
//get isbn
public String getIsbn() {
    return isbn;
}
//set isbn
public void setIsbn(String isbn) {
    this.isbn = isbn;
}
//get pages
public int getPages() {
    return pages;
}
//set pages
public void setPages(int pages) {
    this.pages = pages;
}

// Print book information
    public void printBookInfo() {
        System.out.println("\n--- BOOK INFORMATION ---");
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Number of Pages: " + pages);
    }
}