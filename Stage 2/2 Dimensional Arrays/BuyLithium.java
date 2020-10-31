import java.util.*;
/**
 * The class BuyLithium offers a buyer the chance to enter a price and should show all the lithium that is
 * on offer at the buy's price or any price lower than what the buyer has stated.
 *
 * @author (Wai Shan (Karen) Yip)
 * @version (5/10/2019)
 */
public class BuyLithium
{
    //Counts the number of lithium available.
    int count;

    /**
     * Constructor for objects of class BuyLithium
     */
    public BuyLithium()
    {
    }

    /**
     * findBestClass shows all the lithium grades with their prices as well as indicate to the buyer 
     * the number of lithium grades available.
     */
    public void findBestPrice(double buyerPrice)
    {
        count = 0;
        for (Integer key: LithiumPricing.priceMap.keySet())
        {
            double price = LithiumPricing.priceMap.get(key);
            if (price <= buyerPrice)
            {
                count++;
                System.out.println(key + " = " + price);

            }
        }
        System.out.println("There are " + count + " available to you.");
    }

    /**
     * The buyer is able to enter a value for the quality they want to purchase.
     * There is a message that indicates how many sources/ grades of lithium were located.
     */
    public void findHighQuality(int quality)
    {
        count = 0;
        for (Integer grade: LithiumPricing.priceMap.keySet())
        {
            if (grade <= quality)
            {
                double value = LithiumPricing.priceMap.get(grade);
                count ++;
                System.out.println(grade + " = " + value);
            }
        }
        System.out.println("There are " + count + " available to you.");
    }

}
