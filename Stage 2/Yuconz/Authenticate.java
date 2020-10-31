import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Authenticate extends JFrame {

    private static boolean loggedIn = false;
    private static int access = 0; 

    public Authenticate() 
    {
        AuthenticationServer server = new AuthenticationServer();
        UserInterface yuconz = new UserInterface();
    }

    public static boolean login(String username, String password, int accessLevel) 
    {
        loggedIn = AuthenticationServer.login(username, password,accessLevel);
        access = accessLevel;
        try{
            File log = new File("log.txt");
            BufferedReader br = new BufferedReader(new FileReader(log));
            String st;
            String logs = "";
            while ((st = br.readLine()) != null) 
            {
                logs = logs + "\n" + st;
            }
            logs = logs + "\n" + username + accessLevel + loggedIn;
            FileWriter fw = new FileWriter(log);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(logs);
            br.close();
            bw.close();
        } catch(IOException e){
            e.printStackTrace();

        }

        return loggedIn;		
    }

    public static boolean logout() 
    {

        if(loggedIn == true) 
        {
            loggedIn = false;
            access = 0;
            return true;
        } else {return false;}

    }

    public void makeFrame() 
    {

    }

    public static boolean checkLogin() 
    {
        return loggedIn;
    }

    public static int checkAccess () 
    {
        return access;
    }
}