import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class UserInterface extends JFrame implements ActionListener, MouseListener
{
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JButton login;
    private JTextField username, level, user, contents;
    private JPasswordField password;
    private JLabel namelabel, passlabel, accesslabel, PDcontents, ARcontents;
    private JLabel success = new JLabel("Login successful");
    private JLabel title = new JLabel("Yuconz");
    private JButton logout = new JButton("Logout");
    private JButton pd = new JButton("PD File");
    private JButton ar = new JButton("AR File");
    private JButton create = new JButton("Create new File");
    private JButton modify = new JButton("Modify File");
    private JButton readContents = new JButton("Read");
    private JButton readAR = new JButton("Read");
    private JButton createAR = new JButton("Create new File");
    private JButton modifyAR = new JButton("Modify File");

    public UserInterface() 
    {
        super("Yuconz System");
        setSize(800,600);
        setVisible(true);
        makeFrame();
    }

    public void makePD() 
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());
        panel2.setLayout(new FlowLayout());

        user = new JTextField(25);
        contents = new JTextField(50);
        JLabel userLabel = new JLabel("Username");
        JLabel content = new JLabel("Conetents");

        add(panel2);
        panel2.add(logout);
        panel2.add(userLabel);
        panel2.add(user);
        panel2.add(contents);
        panel2.add(content);
        panel2.add(readContents);
        panel2.add(create);
        panel2.add(modify);

        create.addActionListener(this);
        modify.addActionListener(this);
        readContents.addActionListener(this);

        setVisible(true);
    }

    public void makeAR() 
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());
        panel3.setLayout(new FlowLayout());

        user = new JTextField(25);
        contents = new JTextField(50);
        JLabel userLabel = new JLabel("Username");
        JLabel content = new JLabel("Conetents");

        add(panel3);
        panel3.add(logout);
        panel3.add(userLabel);
        panel3.add(user);
        panel3.add(contents);
        panel3.add(content);
        panel3.add(readAR);
        panel3.add(createAR);
        panel3.add(modifyAR);

        readAR.addActionListener(this);
        modifyAR.addActionListener(this);
        createAR.addActionListener(this);

        setVisible(true);
    }

    public void makeFrame() 
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());
        panel1.setLayout(new FlowLayout());

        Font titleFont = new Font("Arial", Font.BOLD, 36);

        login = new JButton("Login");
        username = new JTextField(25);
        level = new JTextField(5); 
        password = new JPasswordField(25);
        JLabel namelabel = new JLabel("Username");
        JLabel passlabel = new JLabel("Password");
        JLabel accesslabel = new JLabel("Access Level");

        title.setFont(titleFont);
        add(panel1);
        panel1.add(Box.createHorizontalStrut(300));
        panel1.add(title);
        panel1.add(Box.createHorizontalStrut(300));
        panel1.add(Box.createVerticalStrut(100));
        panel1.add(namelabel);
        panel1.add(username);
        panel1.add(passlabel);
        panel1.add(password);
        panel1.add(accesslabel);
        panel1.add(level);
        panel1.add(login);

        login.addActionListener(this);
        username.addActionListener(this);
        password.addActionListener(this);
        level.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();

        if (source == login) {
            String user = username.getText();
            String pass = String.valueOf(password.getPassword());
            Integer accessLevel = Integer.parseInt(level.getText());
            if(Authenticate.login(user, pass, accessLevel)) {
                panel1.add(success);
                panel1.add(pd);
                panel1.add(ar);
                panel1.add(logout);
                logout.addActionListener(this);
                ar.addActionListener(this);
                pd.addActionListener(this);
                setVisible(true);
            }
        }

        if (source == logout) {
            Authenticate.logout();
            super.dispose();
        }

        if (source == pd) {
            remove(panel1);
            makePD();
        }

        if(source == ar) {
            remove(panel1);
            makeAR();
        }

        if (source == readContents) {
            String username = user.getText();
            String cont = PersonalDetails.read(username);
            PDcontents = new JLabel(cont);
            panel2.add(PDcontents);
            setVisible(true);
        }

        if (source == create) {
            String username = user.getText();
            String content = contents.getText();
            boolean worked = PersonalDetails.createPersonalDetails(username, content);
            PDcontents = new JLabel(Boolean.toString(worked));
            setVisible(true);
        }

        if(source == modify) {
            String username = user.getText();
            boolean worked = PersonalDetails.modifyPersonalDetails(username);
            PDcontents = new JLabel(Boolean.toString(worked));
            setVisible(true);
        }

        if(source == readAR) {
            String username = user.getText();
            String cont = AnnualReview.read(username);
            ARcontents = new JLabel(cont);
            panel3.add(ARcontents);
            setVisible(true);
        }

        if(source == createAR){
            String username = user.getText();
            String content = contents.getText();
            boolean worked = AnnualReview.createAnnualReview(username, content);
            ARcontents = new JLabel(Boolean.toString(worked));
            setVisible(true);
        }

        if(source == modifyAR){
            String username = user.getText();
            boolean worked = AnnualReview.modifyAnnualReview(username);
            ARcontents = new JLabel(Boolean.toString(worked));
            setVisible(true);
        }
    }

    @Override 
    public void mouseExited(MouseEvent e){}

    @Override 
    public void mouseEntered(MouseEvent en){} 

    @Override 
    public void mouseReleased(MouseEvent r){}

    @Override 
    public void mousePressed(MouseEvent p){
    }

    @Override
    public void mouseClicked(MouseEvent m){
    }

}