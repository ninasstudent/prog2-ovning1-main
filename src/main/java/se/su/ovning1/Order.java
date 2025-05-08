package se.su.ovning1;
import java.util.*;
public class Order {
    private static long current_Order = 0;
    private final List<Item> items;
    private final long orderNumber;
    public Order(Item... items) {
        this.items=List.of(items);
        orderNumber = current_Order++;
    }
    public double getTotalValuePlusVAT(){
        double value = 0;
        for (Item item : items){
            value += item.getPriceWithVAT();
        }
        return value;
    }
    public double getTotalValue(){
        double value = 0;
        for (Item item : items) {
            value += item.getPrice();
        }
        return value;
    }

    public String getReceipt(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format( "Receipt for order #%d\n", orderNumber));
        sb.append("-----------\n");
        for(Item item : items ){
            sb.append(item.toString()).append("\n");
        }
        String total= String.format("Total excl.VAT : %f\n", getTotalValue());
        String totalVAT = String.format("Total incl . VAT : %f", getTotalValuePlusVAT());
        sb.append(total).append(totalVAT);
        return sb.toString();
    }
}