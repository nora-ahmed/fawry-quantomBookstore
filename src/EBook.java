 enum BookFormat{
    PDF,DOC,TXT
}
public class EBook extends Book{
    private BookFormat bookType;
    private double price;

    EBook(String ISBN, String title, int year,BookFormat bookType,double price) {
        super(ISBN, title, year);
        this.bookType=bookType;
        this.price=price;

    }

    public double getPrice() {
        return price;
    }
}
