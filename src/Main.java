import java.util.List;
class test{
    public static void testing(){
        Inventory store = new Inventory();
        //adding the books
        store.addPaperBook("111", "Java in Depth", 2020, 50.0,2);
        store.addEBook("222", "Learn Node.js", 2020, BookFormat.PDF, 50,4);
        store.addEBook("444", "Learn Node.js", 2010, BookFormat.PDF, 50,4);
        store.addDemoBook("333", "Preview Only", 2020);
        //buying a normal EBook
        double total1 = store.buyBook("222", 1, "nora@example.com", "");
        System.out.println("Paid: $" + total1);
//buying a normal Paperbook
        double total2 = store.buyBook("111", 2, "buyer@example.com", "123 Main St");
        System.out.println("Paid: $" + total2);
//removing the outdated 444 book and trying to buy it
        List<Book> removed=store.removeOutdated( 7);
        System.out.println("the removed books are");
        for (Book book:removed) {
            System.out.println("book: "+book.getTitle());
        }
        double total3 = store.buyBook("444", 2, "buyer@example.com", "123 Main St");
//trying to buy a demobook
        double total4 = store.buyBook("333", 2, "buyer@example.com", "123 Main St");

//trying to buy a book that is unavailable
        try {
            store.buyBook("111", 1, "test@example.com", "");
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }

    }
}
public class Main {
    public static void main(String[] args) {
        test.testing();
    }}
