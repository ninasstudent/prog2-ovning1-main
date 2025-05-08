package se.su.ovning1;

public class Book extends Item implements PriceableWithVAT6 {
    private static final double BOUND_EXTRA = 1.3;
    private final String author;
    private final double price;
    private final boolean bound;

    public Book(String author, String name, double price, boolean bound){
        super(name);
        this.author=author;
        this.price=price;
        this.bound=bound;
    }

    public double getPrice() {
        return bound ? price * BOUND_EXTRA : price;
    }

    public String getAuthor(){
        return author;
    }

    public String toString(){
        return String.format(
                "Book: name=%s, author=%s, bound=%b, price=%.2f, price+vat=%.2f",
                getName(), author, bound, getPrice(), getPriceWithVAT());
    }
}
