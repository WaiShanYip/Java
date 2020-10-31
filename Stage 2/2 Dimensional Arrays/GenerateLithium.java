import java.util.*;
/**
 * The class GenerateLithium is responsible for generating a tray of Lithium
 *
 * @author (Wai Shan (Karen) Yip)
 * @version (5/10/2019)
 */
public class GenerateLithium
{
    // Generates a tray of lithium using a 2 dimensional array.
    public static int tray [][] = new int [5][3];

    //The start of the random tray of lithium generated is set to 0.
    private int grading = 0;

    //Generates a random tray.
    private Random randomGenerator;

    /**
     * Constructor for objects of class GenerateLithium.
     */
    public GenerateLithium()
    {
        randomGenerator = new Random();
    }

    /**
     * Generates a tray of lithium using a 2 dimensional array.
     */
    public void generateSample()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                grading = randomGenerator.nextInt(50);
                tray[i][j] = grading;
            }
        }
    }

    /**
     * Prints the generated lithium from generateSample() method.
     */
    public void printTray()
    {
        for (int i = 0; i <5; i++) 
        {
            for (int j = 0; j <3; j++)
            {
                System.out.print(tray[i][j] + " || ");
            }
            System.out.println();
        }

    }
}