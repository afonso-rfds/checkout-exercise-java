import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<CDiscount> promotions = new ArrayList<>();

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("Welcome to Checkout Kata");
        System.out.println();
        System.out.println("Prices are: ");
        System.out.println("Item        Unit Price (in pounds)         Special Price");
        System.out.println("A           0.5                            ");
        System.out.println("B           0.75                           2 for 1.25£");
        System.out.println("C           0.25                           Buy 3, get one free");
        System.out.println("D           1.50                           Buy D and E for 3£");
        System.out.println("E           2                              Buy D and E for 3£");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println();

        // ----- Change items properties here -----
        CItem itemA = new CItem('A', 0.5f);
        CItem itemB = new CItem('B', 0.75f);
        CItem itemC = new CItem('C', 0.25f);
        CItem itemD = new CItem('D', 1.5f);
        CItem itemE = new CItem('E', 2.0f);

        // ----- Change promotions here -----
        promotions.add(new CMultiPricedPromo('B', 2, 1.25f));
        promotions.add(new CBuyNGetOnePromo('C', 3));
        promotions.add(new CMealDealPromo(List.of('D', 'E'), 3.0f));

        CCheckout checkout = new CCheckout(promotions);

        // ----- Change scanned items here -----
        checkout.scanItem(itemB);
        checkout.scanItem(itemB);
        checkout.scanItem(itemD);
        checkout.scanItem(itemB);
        checkout.scanItem(itemE);
        checkout.scanItem(itemB);


        System.out.println("------------- Bill -------------");
        System.out.println("Price:     " + checkout.calculatePriceWithoutDiscount() + "£");
        System.out.println("Discount:  " + checkout.calculateDiscount() + "£");
        System.out.println("To Pay:    " + (checkout.calculatePriceWithoutDiscount() - checkout.calculateDiscount()) + "£");
        System.out.println();
        System.out.println();
    }
}
