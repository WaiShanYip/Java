import java.io.*;
import java.util.Scanner;

public class PersonalDetails {

    private static String output = "";

    public PersonalDetails () 
    {

    }

    public static String read(String username) 
    {
        try{
            File file = new	File("PD-" + username +".txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) 
            {
                output = output + st + "\n";

            }

            br.close();
            return output;
        } catch(IOException e){
            e.printStackTrace();
            return "File not found";
        }
    }

    public static boolean modifyPersonalDetails(String username)
    {
        if(Authenticate.checkLogin() == true && Authenticate.checkAccess() == 2) {

            try{
                File file = new	File("PD-" + username+".txt");

                String updatedPD = "";
                Scanner scanner = new Scanner(System.in);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                System.out.println("Enter the changes you would like to make for each line, or enter if you don't wish to make changes to that line");
                while ((st = br.readLine()) != null) 
                {
                    System.out.println(st);
                    String input = scanner.nextLine();
                    if(input == null) {
                        updatedPD = updatedPD + st + "\n";
                    }
                    else {
                        updatedPD = updatedPD + input + "\n";
                    }
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(updatedPD);
                bw.close();
                br.close();
                scanner.close();
                return true;
            } catch(IOException e){
                e.printStackTrace();
                return false;
            }} else return false;
    }

    public static boolean createPersonalDetails (String username, String contents)
    {
        if(Authenticate.checkLogin() == true && Authenticate.checkAccess() == 2) {
            try{
                File file = new File("PD-" + username + ".txt");
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Personal Details.");
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