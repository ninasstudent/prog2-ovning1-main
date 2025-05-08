package se.su.ovning1;

public interface Priceable {

     double getPrice();
     double getVAT();
     default double getPriceWithVAT(){

         return getPrice() + (getPrice() +getVAT());
     }

}
