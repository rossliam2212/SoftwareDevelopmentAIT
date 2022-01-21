public class Book implements Comparable<Book> {
    private String title;
    private String publisher;
    private String author;
    private double price;

    public static int sortingMethod = 1;

    public Book(String title, String publisher, String author, double price) {
        this.title = (String)validate(title);
        this.publisher = (String)validate(publisher);
        this.author = (String)validate(author);
        this.price = (Double)validate(price);
    }

    /**
     * This method is used to validate the values passed into the constructor of this class.
     * @param input The value to validate.
     * @return The input if it has been validated, else an IllegalArgumentException is thrown.
     */
    private Object validate(Object input) {
        if (input.getClass() == Double.class) {
            if ((double) input < 0) {
                throw new IllegalArgumentException("Double cannot be less than 0!");
            }
        }
        if (input.getClass() == String.class) {
            if (((String) input).length() == 0) {
                throw new IllegalArgumentException("String cannot be null!");
            }
        }
        return input;
    }

    /**
     * This method sets the sorting method to be used for comparing.
     * @param number The sorting method. 1 - Title, 2 - Publisher, 3 - Author, 4 - Price
     */
    public void setSortingMethod(int number) {
        sortingMethod = number;
    }

    /**
     * @return A String representation of the Book.
     */
    public String toString() {
        return "Title: " + this.title +
                "\nPublisher: " + this.publisher +
                "\nAuthor: " + this.author +
                "\nPrice: " + this.price + "\n";
    }

    @Override
    public int compareTo(Book book) {
        if (sortingMethod == 1) {
            if (this.title.compareTo(book.title) < 0) {
                return 1;
            }
        } else if (sortingMethod == 2) {
            if (this.publisher.compareTo(book.publisher) < 0) {
                return 1;
            }
        } else if (sortingMethod == 3) {
            if (this.author.compareTo(book.author) < 0) {
                return 1;
            }
        } else {
            if (this.price < book.price) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * This method takes in an array of Book and sorts them depending on the sorting method that is set.
     * Depending on the sorting method that is set, the corresponding instance variables on all Books in the array are compared and
     * are sorted accordingly.
     * @param books The array of Books to be sorted.
     */
    public static void sortBooks(Book[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            int leastIndex = i;
            for (int j = i + 1; j < books.length; j++) {
                if (books[j].compareTo(books[leastIndex]) == 1) {
                    leastIndex = j;
                }
            }
            if (leastIndex != i) {
                swap(books, i, leastIndex);
            }
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * This method is used to swap two indexes in an array.
     * @param books The array.
     * @param firstIndex The first index to be swapped.
     * @param secondIndex The second index to be swapped.
     */
    private static void swap(Book[] books, int firstIndex, int secondIndex) {
        Book temp = books[firstIndex];
        books[firstIndex] = books[secondIndex];
        books[secondIndex] = temp;
    }

    /* Main Method to text the Book class */
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "Charles Scribner's Sons", "F. Scott Fitzgerald", 15.0);
        Book book2 = new Book("Nineteen Eighty-Four", "Secker & Warburg", "George Orwell", 10.0);
        Book book3 = new Book("Don Quixote", "Francisco de Robles", "Miguel de Cervantes", 30.0);
        Book book4 = new Book("To Kill a Mockingbird", "J. B. Lippincott & Co.", "Harper Lee", 25.0);

        Book[] bookArray = {book1, book2, book3, book4};
        book1.setSortingMethod(2);
        sortBooks(bookArray);
    }
}
