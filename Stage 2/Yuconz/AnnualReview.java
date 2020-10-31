import java.io.*;
import java.util.Scanner;
public class AnnualReview {

    private static String output = "";

    public AnnualReview ()
    {

    }

    public static String read(String username) 
    {
        try{
            File file = new	File("AR-" + username+".txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) 
            {
                output += st +"\n";

            }

            br.close();
            return output;
        } catch(IOException e){
            e.printStackTrace();
            return output;
        }
    }

    public static boolean modifyAnnualReview(String username)
    {
        if(Authenticate.checkLogin() == true && Authenticate.checkAccess() == 4) {

            try{
                File file = new	File("AR-" + username+".txt");

                String updatedAR = "";
                Scanner scanner = new Scanner(System.in);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                System.out.println("Enter the changes you would like to make for each line, or enter if you don't wish to make changes to that line");
                while ((st = br.readLine()) != null) 
                {
                    System.out.println(st);
                    String input = scanner.nextLine();
                    if(input == null) {
                        updatedAR = updatedAR + st + "\n";
                    }
                    else {
                        updatedAR = updatedAR + input + "\n";
                    }
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(updatedAR);
                bw.close();
                br.close();
                scanner.close();
                return true;
            } catch(IOException e){
                e.printStackTrace();
                return false;
            }} else return false;
    }

    public static boolean createAnnualReview (String username, String contents)
    {
        if(Authenticate.checkLogin() == true && Authenticate.checkAccess() == 4) {
            try{
                File file = new File("AR-" + username + ".txt");
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Annual Review.");
                bw.newLine();
                bw.write(contents);
                bw.flush();
                bw.close();
                return true;
            } catch(IOException e){
                e.printStackTrace();
                return false;
            }

        } else {return false;}

    }

}