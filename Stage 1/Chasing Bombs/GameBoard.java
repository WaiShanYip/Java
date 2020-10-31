import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * The aim of the game is for a player to click on a square, avoiding the hidden bomb.
 * For every square the player successfully clicks on without triggering the bomb, they gain one point.
 * The game continues until the square with the bomb is clicked.
 * The number of clicks required to win the game is dependent on the difficulty level chosen by the player as it
 * increases with the difficulty level.
 *
 * @author Wai Shan (Karen) Yip
 * @version (4/3/2019)
 */
public class GameBoard
{
    //Creates the frame for the GameBoard.
    private JFrame frame;
    //Panels are to be added to the contentPanel.
    private JPanel contentPanel;
    //Panel A has a yellow background to allow the change of backgrounds when the smaller panels are selected.
    private JPanel panelA;
    //The first panel on the first row.
    private JPanel panela1;
    //The second panel on the first row.
    private JPanel panela2;
    //The third panel on the first row.
    private JPanel panela3;
    //The fourth panel on the first row.
    private JPanel panela4;
    //The fifth panel on the first row.
    private JPanel panela5;
    //The first panel on the second row.
    private JPanel panela6;
    //The second panel on the second row.
    private JPanel panela7;
    //The third panel on the second row.
    private JPanel panela8;
    //The fourth panel on the second row.
    private JPanel panela9;
    //The fifth panel on the second row.
    private JPanel panela10;
    //Panel B has a blue background.
    private JPanel panelB;
    //Panel C has a green background.
    private JPanel panelC;
    //The location of the bomb.
    private int bomb;
    //The amount of moves the player has had.
    private int count = 0;
    /**
     * Creates the game board and creates a new location for the bomb.
     */
    public GameBoard()
    {
        bomb();
        makeFrame();
    }

    /**
     * Creates the components of the frame.
     */
    public void makeFrame()
    {
        frame = new JFrame ("Evade The Bomb");

        contentPanel = new JPanel(new GridLayout (1,2));
        panelA = new JPanel();
        panelA.setLayout(new GridLayout(2, 5 , 0 ,0)); //Grid layout of 2 rows and 5 columns.
        panelA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panelA.setBackground(Color.YELLOW);

        panela1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panela1.setBackground(Color.RED);
        panela1.setBorder(BorderFactory.createLineBorder(Color.WHITE)); //White border lines for all panels in A.

        panela2 = new JPanel();
        panela2.setBackground(Color.RED);
        panela2.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        panela3 = new JPanel();
        panela3.setBackground(Color.RED);
        panela3.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        panela4 = new JPanel();
        panela4.setBackground(Color.RED);
        panela4.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        panela5 = new JPanel();
        panela5.setBackground(Color.RED);
        panela5.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        panela6 = new JPanel();
        panela6.setBackground(Color.RED);
        panela6.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        panela7 = new JPanel();
        panela7.setBackground(Color.RED);
        panela7.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        panela8 = new JPanel();
        panela8.setBackground(Color.RED);
        panela8.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        panela9 = new JPanel();
        panela9.setBackground(Color.RED);
        panela9.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        panela10 = new JPanel();
        panela10.setBackground(Color.RED);
        panela10.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        Font buttonFont = new Font ("Arial", Font.BOLD, 20); //Styling for the text inside of the buttons.
        Font statusFont = new Font("Arial", Font.BOLD, 45);

        panelB = new JPanel();
        panelB.setBackground(Color.BLUE); //Blue background for PanelB
        
        JLabel scoreText = new JLabel("Score"); // Label to accompany the score
        scoreText.setFont(buttonFont); 
        scoreText.setForeground(Color.WHITE); //White text
        JLabel status = new JLabel(""); //Tells the player if they have won or lost
        status.setFont(statusFont);
        status.setForeground(Color.WHITE); //White text

        panelC = new JPanel();
        panelC.setBackground(Color.GREEN); //PanelC is green

        JButton playAGame = new JButton ("Play a game"); 
        JButton exit = new JButton ("Exit");
        
        JButton easy = new JButton ("Easy"); //Buttons for the difficulty levels
        JButton intermediate = new JButton ("Intermediate");
        JButton difficult = new JButton ("Difficult");

        playAGame.setFont(buttonFont);
        exit.setFont(buttonFont);
        easy.setFont(buttonFont);
        intermediate.setFont(buttonFont);
        difficult.setFont(buttonFont);

        panelA.add(panela1, BorderLayout.WEST);
        panela1.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the first panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 1;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);
                    }
                    else {

                        panela1.setVisible(false);
                        count ++;
                        scoreText.setText("Score: " +count);
                    }
                    
                }
            });

        panelA.add(panela2, BorderLayout.WEST);
        panela2.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the second panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 2;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);

                    }
                    else {

                        panela2.setVisible(false);
                        count ++;
                        scoreText.setText("Score: " + count);
                    }
                }
            });

        panelA.add(panela3, BorderLayout.WEST);
        panela3.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the third panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 3;
                    if (value == bomb)
                    {

                        status.setText("You lost: Points won: " + count);

                    }
                    else {

                        panela3.setVisible(false);
                        count ++;
                        scoreText.setText("Score: " +count);
                    }
                }
            });

        panelA.add(panela4, BorderLayout.WEST);
        panela4.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the fourth panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 4;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);

                    }
                    else {
                        
                        panela4.setVisible(false);
                        count ++;
                        scoreText.setText("Score: " +count);
                    }
                }
            });

        panelA.add(panela5, BorderLayout.WEST);
        panela5.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the fifth panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 5;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);

                    }
                    else {
                        
                        panela5.setVisible(false);
                        count ++;
                        scoreText.setText("Score: " +count);
                    }
                }
            });
        panelA.add(panela6, BorderLayout.WEST);
        panela6.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the sixth panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 6;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);

                    }
                    else {
                        
                        panela6.setVisible(false);
                        count ++;
                        scoreText.setText("Score: " +count);
                    }
                }
            });

        panelA.add(panela7, BorderLayout.WEST);
        panela7.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the seventh panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 7;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);

                    }
                    else {
                        
                        panela7.setVisible(false);
                        count ++;
                        scoreText.setText("Score: " +count);
                    }
                }
            });

        panelA.add(panela8, BorderLayout.WEST);
        panela8.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the eighth panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 8;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);

                    }
                    else {
                        
                        panela8.setVisible(false);
                        count ++;
                        scoreText.setText("Score: " +count);
                    }
                }
            });

        panelA.add(panela9, BorderLayout.WEST);
        panela9.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the ninth panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 9;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);

                    }
                    else {
                        count ++;
                        panela9.setVisible(false);
                        scoreText.setText("Score: " +count);
                    }
                }
            });

        panelA.add(panela10, BorderLayout.WEST);
        panela10.addMouseListener (new MouseAdapter()
        /**
         * A mouse listener event that is triggered when the user clicks on the tenth panel in A.
         * If this panel contains the bomb, an error message notifies the player that they have lost.
         * If the the panel does not contain the bomb, the number of moves the player has had increases by 1.
         */
            {
                public void mousePressed(MouseEvent me) 
                {
                    int value = 10;
                    if (value == bomb)
                    {
                        status.setText("You lost: Points won: " + count);

                    }
                    else {
                        count ++;
                        panela10.setVisible(false);
                        scoreText.setText("Score: " +count);
                    }
                }
            });

        contentPanel.add(panelA, BorderLayout.WEST);
        
        contentPanel.add(panelB, BorderLayout.CENTER);
        
        contentPanel.add(panelC, BorderLayout.EAST);
        
        panelB.add(playAGame);
        playAGame.addActionListener(new ActionListener()
        /**
         * The playAGame button has an action listener which means when it is pressed, 
         * the bomb positioning is updated
         * and any of the planels that were made invisible before, become visible again to create the illusion
         * of a new board.
         * The win status of the player is also updated so they can play again.
         */
            {
                public void actionPerformed(ActionEvent a) 
                {
                    bomb();
                    panela1.setVisible(true);
                    panela2.setVisible(true);
                    panela3.setVisible(true);
                    panela4.setVisible(true);
                    panela5.setVisible(true);
                    panela6.setVisible(true);
                    panela7.setVisible(true);
                    panela8.setVisible(true);
                    panela9.setVisible(true);
                    panela10.setVisible(true);
                    status.setVisible(false);
                    count = 0;
                    
                }
            });

        panelB.add(Box.createVerticalStrut(100));
        panelB.add(exit);
        exit.addActionListener (new ActionListener()
        /**
         * The exit button has an action listener so when pressed, the application is quit.
         */
            {
                public void actionPerformed(ActionEvent b)
                {
                    System.exit(0);
                }
            });

        panelB.add(scoreText);
        panelB.add(Box.createVerticalStrut(100));
        panelB.add(status);

        panelC.add(easy, BorderLayout.CENTER);
        panelC.add(Box.createVerticalStrut(100));
        easy.addActionListener (new ActionListener()
        /**
         * The easy button is an action listener so when pressed, if the number of moves the player has made
         * is equal to 5 and they have not hit a bomb yet, they win.
         */
            {
                public void actionPerformed(ActionEvent c) 
                {
                    if (count == 5)
                    {
                        status.setText("You Win");
                    }
                }
            });

        panelC.add(intermediate, BorderLayout.CENTER); 
        panelC.add(Box.createVerticalStrut(100));
        intermediate.addActionListener (new ActionListener()
        /**
         * The intermediate button is an action listener so when pressed, if the number of moves the player has
         * made is equal to 7 and they have not hit a bomb yet, they win.
         */
            {
                public void actionPerformed(ActionEvent d)
                {
                    if (count == 7)
                    {
                        status.setText("You win");
                    }
                }
            });

        panelC.add(difficult, BorderLayout.CENTER);
        difficult.addActionListener (new ActionListener()
        /**
         * The difficult button is an action listener so when pressed, if the player is able to click all 9 
         * panels without hitting the bomb, they win.
         */
        {
            public void actionPerformed(ActionEvent s)
            {
                if (count ==9)
                {
                    status.setText("You win");
                }
            }
        });

        frame.setContentPane(contentPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * The location of the bomb will be chosen at random, 
     * Each of the panels in PanelA has their own unique value.
     * The value of the bomb can only go up to 10 and its location will change every time the game is loaded.
     */
    public void bomb()
    {
        Random rand = new Random();
        bomb = rand.nextInt(10)+1;

    }


}

