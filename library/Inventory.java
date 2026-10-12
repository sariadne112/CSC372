import java.util.ArrayList;
public class Inventory {
  private ArrayList<Book> mainInventory;
    private ArrayList<Book> lendingInventory;

    // Default constructor
    public Inventory() {
        mainInventory = new ArrayList<>();
        lendingInventory = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {

    if (bookIdExists(book.getId())) {
        System.out.println("Book ID already exists.");
        return;
    }

    mainInventory.add(book);
    System.out.println("Book added to the library.");
}

    // Borrow a book using its ID
    public void borrowBook(int id) {

        for (int i = 0; i < mainInventory.size(); i++) {

            Book book = mainInventory.get(i);

            if (book.getId() == id) {
                // Move book to lending inventory
                mainInventory.remove(i);
                lendingInventory.add(book);

                System.out.println("Book successfully borrowed.");
                System.out.println("Remaining available copies: "
                        + getAvailableQuantity(book.getIsbn()));
                return;
            }
        }
        System.out.println("Book not found or already borrowed.");
    }

    // Return a borrowed book
    public void returnBook(int id) {

        for (int i = 0; i < lendingInventory.size(); i++) {
            Book book = lendingInventory.get(i);

            if (book.getId() == id) {
                // Move book back to main inventory
                lendingInventory.remove(i);
                mainInventory.add(book);

                System.out.println("Book successfully returned.");
                System.out.println("Available copies: "
                        + getAvailableQuantity(book.getIsbn()));
                return;
            }
        }
        System.out.println("Book is not in the lending inventory.");
    }

    // Search for books by title
    public ArrayList<Book> searchByTitle(String title) {

        ArrayList<Book> results = new ArrayList<>();

        // Prevent an empty search
        if (title == null || title.trim().isEmpty()) {
            return results;
        }

        for (Book book : mainInventory) {
            if (book.getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                results.add(book);
            }
        }

        return results;
    }

    // Print all available books
    public void printAll() {
        if (mainInventory.isEmpty()) {
            System.out.println("No books are currently available.");
            return;
        }

        for (Book book : mainInventory) {
            book.printBookInfo();
            System.out.println("Available copies of this ISBN: " + getAvailableQuantity(book.getIsbn()));
        }
    }

    // Count all available books
    public int getMainInventoryCount() {
        return mainInventory.size();
    }

    // Count available copies with the same ISBN
    public int getAvailableQuantity(String isbn) {

        int count = 0;

        for (Book book : mainInventory) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                count++;
            }
        }
        return count;
    }
    // Check if Book ID already exists
public boolean bookIdExists(int id) {

    // Check main inventory
    for (Book book : mainInventory) {
        if (book.getId() == id) {
            return true;
        }
    }

    // Check lending inventory
    for (Book book : lendingInventory) {
        if (book.getId() == id) {
            return true;
        }
    }

    return false;
}
}
