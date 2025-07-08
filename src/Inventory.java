import java.util.*;

public class Inventory {
    private List<Book>booksInventory=new ArrayList<>();
    private HashMap<String, Integer> booksQuantity= new HashMap<>();
    public void addEBook(String ISBN,String title,int year,BookFormat bookFormat,double price,int quantity){
        EBook eBook=new EBook(ISBN,title,year,bookFormat,price);
        booksInventory.add(eBook);
        booksQuantity.put(ISBN,quantity);
    }
    public void addPaperBook(String ISBN,String title,int year,double price,int quantity){
       PaperBook paperBook=new PaperBook(ISBN, title, year, price);
        booksQuantity.put(ISBN,quantity);
        booksInventory.add(paperBook);
    }
    public void addDemoBook(String ISBN,String title,int year){
        DemoBook demoBook=new DemoBook(ISBN,title,year);
        booksInventory.add(demoBook);
    }
    public List<Book> removeOutdated(int limit){
        List<Book> removed = new ArrayList<>();
                    Iterator<Book> iterator = booksInventory.iterator();
                    while (iterator.hasNext()) {
                        Book book = iterator.next();
                        if (book.isOutdated(limit)) {
                            System.out.println("Removed outdated book " + book.getTitle());
                            removed.add(book);
                            iterator.remove();
                        }
                    }
                    return removed;
    }
private void buyPaperBook(String address){
ShippingService.shipBook(address);
}
private void buyEBook(String email){
MailService.sendEmail(email);
}
public double buyBook(String ISBN, int quantity,String email,String address){

    for (Book book:booksInventory) {
        if(book.getISBN().equals(ISBN)){
            if(book instanceof DemoBook){
                System.out.println("sorry we only have the demo book");
                return -1;
            }
            Integer cuurentQuantity = booksQuantity.get(ISBN);
           if(quantity>cuurentQuantity){
               throw new RuntimeException("there is not enough quantity for this book");
           }
           else{
               booksQuantity.put(ISBN,cuurentQuantity-quantity);
               if(book instanceof PaperBook){
                   buyPaperBook(address);
                   return ((PaperBook) book).getPrice()*quantity;
               }
               else if
                   (book instanceof EBook){
                   buyEBook(email);
                   return ((EBook) book).getPrice()*quantity;
               }



           }
        }
    }
        System.out.println("sorry could not find the book you are looking for");
        return -1;

}
}
