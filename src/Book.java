abstract public class Book {
   private String ISBN;
    private String title;
   private  int year;

    Book(String ISBN,String title, int year) {
        this.ISBN=ISBN;
        this.title=title;
        this.year=year;
    }

    public String getTitle() {
        return title;
    }

    public Boolean isOutdated(int limit){
        if(2025-year>limit)
            return true;
        else
            return false;
    }

    public String getISBN() {
        return ISBN;
    }

}
