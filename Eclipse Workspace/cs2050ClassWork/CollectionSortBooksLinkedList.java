import java.util.*;

/**
 * 
 */
public class CollectionSortBooksLinkedList
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		// Step 1: Create a LinkedList (dynamic)
		LinkedList<Book> bookInventory = new LinkedList<>();
		

		bookInventory.add(new Book("Unmasking AI", "Dr. Joy Buolamwini", 2023));
		bookInventory.add(new Book("Hello World", "Hannah Fry", 2018));
		bookInventory.add(new Book("The Mathematics of Love", "Hannah Fry", 2015));
		bookInventory.add(new Book("Weapons of Math Destruction", "Cathy O’Neil", 2016));
		bookInventory.add(new Book("Race After Technology", "Ruha Benjamin", 2019));
		
		Book book1 = new Book("Unmasking AI", "John Doe", 2025); //add book1 to try to add a book with the same title to the hashmap

		System.out.println("Original LinkedList of books:");
		for (Book currentBook : bookInventory)
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 2: Convert to ArrayList for sorting
		List<Book> books = new ArrayList<>(bookInventory); //always convert your linked list to an array list for sorting!

		// Step 3: Sort by Title
		System.out.println("Books sorted by title:");
		books.sort(Comparator.comparing(Book::getTitle));
		for (Book currentBook : books)
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 4: Sort by year (newest to oldest)
		// add code
		System.out.println("Books sorted by year (newest to oldest):");
		books.sort(Comparator.comparing(Book::getYear).reversed());
		for (Book currentBook : books)
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 5: Sort by author then title
		// add code
		System.out.println("Books sorted by Author and then Title:");
		books.sort(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle));
		for (Book currentBook : books)
		{
			System.out.println(currentBook);
		}
		
		System.out.println();
		
		// Step 6: Add Queue for signing out books
        Queue<Book> signOutQueue = new LinkedList<>();

        // Simulate students requesting to sign out books
        signOutQueue.add(bookInventory.get(0)); // Unmasking AI
        signOutQueue.add(bookInventory.get(2)); // Weapons of Math Destruction
        
        System.out.println(); 
        
        System.out.println("Sign-out queue:");
        for (Book currentBook : signOutQueue) {
            System.out.println(currentBook);
        }

        System.out.println();

        // Step 7: Process the sign-out queue
        System.out.println("Processing sign-outs:");
        // add code
        while (!signOutQueue.isEmpty()) {
        	Book bookTosignOut = signOutQueue.remove();
        	System.out.println("Signed Out: "+ bookTosignOut);
        }
        
        
        
        //Step 8: Search by author
        System.out.println("\nSearching for books by Hannah Fry:");
        List<Book> searchBooksResult = findBooksByAuthor(bookInventory, "Hannah Fry");
        printBooks(searchBooksResult, "Hannah Fry", -1);
        
        //Step 9: search books by author and year
        //create a method that
        List<Book> foundBooks = findBooks(bookInventory, "Hannah Fry", 2018);
        printBooks(foundBooks, "Hannah Fry", 2018);
        
        //Step 10: Use a hash map to organize books by title
        System.out.println("\nStep 10 HashMap of books by title:");
        Map<String,Book> bookMapByTitle = new HashMap<>();
        //using a for loop to create hash map quickly for book titles
        //remember title must be unique
        for (Book book : bookInventory) {
        	bookMapByTitle.put(book.getTitle(), book); //key = title, value = book
        }
        
        //add a book with the same title
        bookMapByTitle.put(book1.getTitle(), book1);
        
        //add a hashmap with a list within for each author
        Map<String, List<Book>> booksByAuthor = new HashMap<>();
        for (Book book : bookInventory) {
        	booksByAuthor.putIfAbsent(book.getAuthor(), new ArrayList<>());
        	booksByAuthor.get(book.getAuthor()).add(book);
        }

        
        //try getting book by title
        String searchTitle = "Hello World";
        //contains Key Returns true if the key exists
        if (bookMapByTitle.containsKey(searchTitle)) {
        	System.out.println("Found book: "+bookMapByTitle.get(searchTitle));
        }
        else {
        	System.out.println("Book not found: "+searchTitle);
        }
        
        //Step 11 Allow user to enter a book title author and year
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a book title: ");
        String title = keyboard.next();
        System.out.println("Enter the author: ");
        String author = keyboard.next();
        System.out.println("Enter the year: ");
        int year = keyboard.nextInt();
        
        //add book to linked list
        bookInventory.add(new Book(title, author, year));
        //add book to hash map
        Book book = new Book(title, author, year);
        bookMapByTitle.put(book.getTitle(), book); //key = title, value = book
        
        //let the user search for the book by title
        System.out.println("Enter the title to search for a book: ");
        String searchTitle2 = keyboard.next();
        //contains Key Returns true if the key exists
        if (bookMapByTitle.containsKey(searchTitle2)) {
        	System.out.println("Found book: "+bookMapByTitle.get(searchTitle2));
        }
        else {
        	System.out.println("Book not found: "+searchTitle2);
        }
        
    }
	public static List<Book> findBooksByAuthor(List<Book> inventory, String author) {
	    List<Book> results = new ArrayList<>();
	    for (Book currentBook : inventory) {
	        if (currentBook.getAuthor().equalsIgnoreCase(author)) {
	            results.add(currentBook);
	        }
	    }
	    return results;
	}
	
	public static List<Book> findBooks(List<Book> inventory, String author, int year) {
	    List<Book> results = new ArrayList<>();
	    for (Book currentBook : inventory) {
	        if (currentBook.getAuthor().equalsIgnoreCase(author) && currentBook.getYear() == year)  {
	            results.add(currentBook);
	        }
	    }
	    results.sort(Comparator.comparing(Book::getTitle));
	    return results;
	}
	
	
	
	public static void printBooks(List<Book> books, String author, int year) {
	    String label;
	    if (year != -1) {
	        label = " in " + year;
	    } else {
	        label = "";
	    }

	    if (books.isEmpty()) {
	        System.out.println("\nNo books found by " + author + label + ".");
	    } else {
	        System.out.println("\nBooks by " + author + label + ":");
	        for (Book currentBook : books) {
	            System.out.println(currentBook);
	        }
	    }
	}


	
	
}

class Book
{
	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year)
	{
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle()
	{
		return title;
	}

	public String getAuthor()
	{
		return author;
	}

	public int getYear()
	{
		return year;
	}

	public String toString()
	{
		return title + " by " + author + " (" + year + ")";
	}
}
