package se.su.ovning1;
import java.time.Year;

public class LongPlay extends Recording{


    public LongPlay(String name, String artist, int year, int condition, double price){
        super(name,artist, year, condition, price);
    }
    @Override
    public String getType(){
        return "LP";
    }
    @Override
    public double getPrice(){
        int thisYear = Year.now().getValue() ;
        return super.getPrice() + ((thisYear - getYear())*5) ;
    }
}