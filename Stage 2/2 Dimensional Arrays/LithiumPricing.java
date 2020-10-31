import java.util.*;
/**
 * The class LithiumPricing is responsible for ensuring that each lithium sample is given a price
 *
 * @author (Wai Shan (Karen) Yip)
 * @version (5/10/2019)
 */
public class LithiumPricing
{
    //A hashmap used to set the pricing of the lithium.
    public static HashMap<Integer, Double> priceMap = new HashMap<>();

    //Initialising the grade variable.
    private int grade;

    //Initialising the price variable.
    private double price;
    /**
     * Constructor for objects of class LithiumPricing
     */
    public LithiumPricing()
    {
        setPrice (LithiumGrading.lowGrade, LithiumGrading.highGrade);
    }

    /**
     * Performs the calculations associated with ensuring that each sample of lithium in the tray is 
     * given a price accordingly.
     */
    public void setPrice(ArrayList l, ArrayList h)
    {
        for (int i=0; i<l.size(); i++)
        {
            grade = (int) l.get(i);
            if (grade > 0 && grade <=9)
            {
                price = 300.00;
                priceMap.put(grade, price);
            }
            if(grade >=10 && grade <=19)
            {
                price = 600.00;
                priceMap.put(grade, price);
            }
            if(grade >=20 && grade <=29)
            {
                price = 900.00;
                priceMap.put(grade, price);
            }
        }

        for (int i=0; i<h.size(); i++) 
        {
            grade = (int) h.get(i);
            if (grade >=20 && grade<=29)
            {
                price = 900.00;
                priceMap.put(grade, price);
            }
            if(grade >=30)
            {
                price = 1250.00;
                priceMap.put(grade, price);
            }
        }
    }

    /**
     * Prints all the prices of the lithium.
     * Shows all the lithium found in the tray together with their prices.
     */
    public void printPrice()
    {
        for(Integer grade: priceMap.keySet())
        {
            String key = grade.toString();
            String value = priceMap.get(grade).toString();
            System.out.println(key + " = " + value);
        }

    }
}

