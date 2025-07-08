public class PaperBook extends Book{
    private double price;


    PaperBook(String ISBN, String title, int year,double price) {
        super(ISBN, title, year);
        this.price=price;

    }

    public double getPrice() {
        return price;
    }
}
