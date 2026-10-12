import java.util.ArrayList;
import java.util.Scanner;
public class LibraryMain {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Inventory inventory = new Inventory();
    String choice = "";
    try {
      do {
        System.out.printf("%50s%n", "--- LIBRARY SYSTEM MENU ---");

        System.out.printf("%-30s %-30s %-30s%n",
        "1. Add Book", "3. Return Book", "5. Print All Books");

        System.out.printf("%-30s %-30s %-30s%n",
        "2. Borrow Book", "4. Search by Title", "6. Exit");

        System.out.print("\nEnter your choice: ");

        choice = scnr.nextLine().trim();
        switch (choice) {
          case "1":
            System.out.println("\n--- ADD NEW BOOK ---");
            int id = readInteger(scnr,"Enter Book ID: ");
            // Check for duplicate ID
            if (inventory.bookIdExists(id)) {
                System.out.println("Book ID already exists.");
                break;
            }
            System.out.print("Enter Book Title: ");
            String title = scnr.nextLine();
            System.out.print("Enter Author: ");
            String author = scnr.nextLine();
            System.out.print("Enter ISBN Number: ");
            String isbn = scnr.nextLine();
            int pages = readInteger(scnr, "Enter Number of Pages: ");
// Create a new Book object
            Book newBook = new Book(id, title, author, isbn, pages);
            inventory.addBook(newBook);
            break;
        
            case "2":
                System.out.println("\n--- BORROW BOOK ---");
                if (inventory.getMainInventoryCount() == 0) {
                    System.out.println("No books are currently available.");
                    break;
                }
                int borrowId = readInteger(scnr,"Enter Book ID to borrow: ");
                inventory.borrowBook(borrowId);
                    break;
        
            case "3":
                System.out.println("\n--- RETURN BOOK ---");
                int returnId = readInteger(scnr,"Enter Book ID to return: ");
                inventory.returnBook(returnId);
                break;
            
            case "4":
                System.out.println("\n--- SEARCH BY TITLE ---");
                System.out.print("Enter book title: ");
                String searchTitle = scnr.nextLine();
                
                ArrayList<Book> results = inventory.searchByTitle(searchTitle);

                if (results.isEmpty()) {
                    System.out.println("No matching book found.");
                } else { 
                    System.out.println("Matching books:");
                    for (Book book : results) {
                        book.printBookInfo();
                    }
                }
                break;
       
            case "5":
                System.out.println("\n--- ALL AVAILABLE BOOKS ---");
                inventory.printAll();
                break;
       
            case "6":
                System.out.println( "Exiting the program. Goodbye!");
                break;

            default:
                System.out.println( "Invalid option. Please try again.");
            }
        }
        while (!choice.equals("6"));
        } catch (Exception exception) {
            System.out.println("Program error: " + exception.getMessage());
        } finally {
            scnr.close();
        }
    }
    // Validate numerical input
    public static int readInteger(Scanner scnr, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scnr.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid entry. Enter numbers only.");
            }
        }
    }

}
