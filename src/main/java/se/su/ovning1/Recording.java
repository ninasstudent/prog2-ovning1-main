package se.su.ovning1;

public abstract class Recording extends Item implements PriceableWithVAT25 {

    private final String artist;
    private final int year;
    private final int condition;
    private final double price;

    protected Recording(String name, String artist, int year, int condition, double price){
        super(name);
        this.artist=artist;
        this.year=year;
        this.price=price;
        this.condition=Math.clamp(condition, 0, 10);

    }

    public String getArtist(){
        return artist;
    }
    public int getYear(){
        return year;
    }
    public int getCondition(){
        return condition;
    }

    protected double getOriginalPrice(){
        return price;
    }

    public abstract String getType();

    @Override
    public double getPrice(){
        return Math.min(10, price * (condition*0.1));
    }
    @Override
    public String toString(){
        return String.format(
                "%s: name=%s, artist=%s, year=%d, condition=%d ,original price=%f,price =%f, price + vat =%f",
                getType(),
                getName(),
                getArtist(),
                getYear(),
                getCondition(),
                getOriginalPrice(),
                getPrice(),
                getPriceWithVAT());

    }
}