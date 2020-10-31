import java.util.*;
/**
 * The class LithiumGrading makes use of the tray of lithium generated in the GenerateLithium class so that
 * lithium can be graded as it is important for customers to buy highly graded lithium.
 *
 * @author (Wai Shan (Karen) Yip)
 * @version (5/10/2019)
 */
public class LithiumGrading
{
    //ArrayList to store elements that fit in the Low Grade category.
    public static ArrayList<Integer> lowGrade = new ArrayList<Integer>();

    //ArrayList to store elements that fit in the High Grade category.
    public static ArrayList <Integer> highGrade = new ArrayList<Integer>();
    private int a=0;
    /**
     * Constructor for objects of class LithiumGrading
     */
    public LithiumGrading()
    {
        generateGrades(GenerateLithium.tray);
    }

    /**
     * Accepts the lithium tray as a parameter and must look at each lithium grade and determine
     * whether it is of high quality or not.
     * Any lithium that is above a value of 25 is considered to be a high grade.
     * Aims to generate a list that contains all the low grade lithium and 
     * another list that contains the high graded lithium.
     */
    public void generateGrades(int tray[][])
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (tray[i][j] > 25)
                {
                    highGrade.add(tray[i][j]);
                }
                else
                {
                    lowGrade.add(tray[i][j]);
                }
            }

        }
    }

    /**
     * Makes use of the bubble sort to sort the low graded as well as the high graded lithium
     * in ascending order
     */
    public void sortingLithium()
    {
        for (int lst=lowGrade.size()-1; lst>0; lst--)
        {
            for (int i=0; i<lst; i++)
            {
                if(lowGrade.get(i) > lowGrade.get(i+1))
                {
                    a=lowGrade.get(i);
                    lowGrade.set(i, lowGrade.get(i+1));
                    lowGrade.set(i+1,a);
                }
            }
        }
        for (int x = 0; x < lowGrade.size() - 1; x++)
            System.out.println(lowGrade.get(x));

        for (int lst=highGrade.size()-1; lst>0; lst--)
        {
            for (int i=0; i<lst; i++)
            {
                if(highGrade.get(i) > highGrade.get(i+1))
                {
                    a=highGrade.get(i);
                    highGrade.set(i, highGrade.get(i+1));
                    highGrade.set(i+1,a);
                }
            }
        }
        for (int x = 0; x < highGrade.size() - 1; x++)
            System.out.println(highGrade.get(x));
    }

}
