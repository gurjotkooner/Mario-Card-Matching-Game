//Mario Card Game Screens Created by Gurjot Kooner

//Importing the essentials....
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon.*;
import javax.swing.Icon.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class MarioCardGame extends JPanel implements ActionListener
{   
    //Global Variables

    JLabel background;
    JPanel card1;
    JPanel card2;
    static JFrame window;
    Timer test;
    JLabel play;
    JLabel instructions;
    JLabel settings;
    JLabel scoreboard;
    JLabel credits;
    JLabel title;
    JLabel top;
    JLabel triesLabel;
    JLabel timer;
    JLabel exit;
    JLabel mute;
    JLabel unmute;
    JLabel mutelabel;
    JLabel unmutelabel;
    Clip bgMusic;
    Clip test12345;
    Clip buttonSound;
    JLabel easteregg;
    JLabel gurman1;
    JLabel jatt;
    Clip test1234;
    JLabel jatty;
    JLabel sfxmute;
    JLabel sfxunmute;
    JLabel sfxmutelabel;
    JLabel sfxunmutelabel;
    ImageIcon play123;
    boolean isMuted = false;
    JButton background1;
    JButton background2;
    JButton background3;
    JButton background4;
    int bg;
    JLabel changebg;
    int sfxm;
    int m;
    JLabel scoreboardbgg;
    JLabel scoreboardtop;
    String name;

    JLabel[] text;
    int rows = 4, columns = 4;

    JButton a[][] = new JButton [rows][columns];
    int b[][] = new int [rows][columns];
    JLabel status = new JLabel();
    JLabel test123;
    JPanel g2;
    JPanel g;
    int score;
    int lastx = 1000;
    int lasty = 1000;
    int tries ;
    int points;
    JButton restart;
    JButton gamesize4x4;
    JButton gamesize6x6;
    int gs;
    JLabel scoreboard1;
    JLabel scoreboard2;
    JLabel scoreboard3;
    int temp1;
    int temp2 ;
    int temp3;
    int bah1=0;
    int bah2=0;
    int bah3=0;
    
    public static void main (String args[])
    {
        // Main window screen creation
        window = new JFrame("Mario Card Game! "); 
        window.setSize(530,450); 
        MarioCardGame content = new MarioCardGame();
        window.setContentPane(content);
        window.setLocation(300,300);
        window.setVisible(true);
        //closes the whole game on exit (turns off music)
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public MarioCardGame()
    {
        // runs the screen 1 class and begins music
        screen1();
        music(); 
        temp1 = 0;
        temp2=0;
        temp3=0;
        int points = 1000 - 10 * tries;

    }

    public void screen1() {
        // For this game I decided to manually change the background, frames and JLabels because during my testing phase I realized that the screens would sometimes flicker when switching from screen to screen
        // As a result I decided although, much harder and time consuming I would manually adjust the bounds of each JLabel and remove/ add them when moving between screens
        // using null layout allowed me to customize the exact locations of where I wanted everything
        sfxm = 0;
        m = 0;
        gs = 4;
        JPanel card1 = new JPanel();  
        background = new JLabel( createImageIcon ("StartingScreen.gif"));
        add (background);
        card1.setVisible(true);  

        // Creating the background
     
        Timer test = new Timer(4700, new ActionListener()
                {

                    public void actionPerformed(ActionEvent e)
                    {
                        window.setSize(550,500); 
                        background.setIcon(new ImageIcon("clicktocontinue.gif"));
                        background.addMouseListener(new MouseAdapter() 
                            { 
                                public void mouseClicked(MouseEvent e) {
                                    mainmenu();
                                    background.removeMouseListener(this);
                                }

                            });
                    }

                }
            );
        test.start();
        test.setRepeats(false);

        // This timer plays the first starting gif, then after 4700 milliseconds it will change the gif to the click to start gif where on mouseclicked it will begin the main menu screen and remove the gif from the background

    }

    public void mainmenu(){  
        //This is the main menu setup screen, this basically is a bunch of JLabels put together and added onto the background, when moving to another screen it will simply remove the original JLabels, change the background and add the new JLabels specific to the screen (E.g if click play it will remove the main menu screen and show the playing screen)
        // much of this does not need an explanation as it is simply adding/removing jlabels on action listeners
        window.setSize(1440,810);
        background.setIcon(new ImageIcon("mainmenu1.jpg"));
        background.setBounds(0,0,1440,810);

        play = new JLabel("");
        play.setIcon(new ImageIcon("PlayButton.png"));
        play.setBounds(600,150,400,200);

        play.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    playmenu();    
                    buttonSound();
                    background.remove(easteregg);
                    actualgame();

                }
            }
        );

        instructions = new JLabel("");
        instructions.setIcon(new ImageIcon("InstructionsButton.png"));
        instructions.setBounds(600,450,400,200);

        instructions.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    instructionmenu();         
                    buttonSound();
                    background.remove(easteregg);
                }
            }
        );

        settings = new JLabel("");
        settings.setIcon(new ImageIcon("SettingsButton.png"));
        settings.setBounds(600,300,400,200);

        settings.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    settingsmenu();          
                    buttonSound();
                    background.remove(easteregg);
                }
            }
        );

        easteregg = new JLabel("");
        easteregg.setIcon(new ImageIcon("easteregg.png"));
        easteregg.setBounds(1000,500,200,200);

        easteregg.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    eastereggmenu();     
                    buttonSound();
                    easterSound();
                    bgMusic.stop();
                    background.remove(easteregg);
                }
            }
        );

        scoreboard = new JLabel("");
        scoreboard.setIcon(new ImageIcon("ScoreBoard.png"));
        scoreboard.setBounds(600,600,400,200);

        scoreboard.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    scoreboardmenu();
                    buttonSound();
                    background.remove(easteregg);    
                    bah2 = 1000 - 10 * bah1;
                    //used for the scoreboard, when clicking on scoreboard button it will automatically update the stats
                       if (points > temp1)
                    {
                        temp1 = points;
                        scoreboard1.setText("#1                "+name+"                                       "+temp1);
                    }
                    else if(points > temp2)
                    {
                        temp2 = points;
                        scoreboard2.setText("#2                 "+name+"                                       "+temp2);               
                    }
                    else if (points > temp3)
                    {
                        temp3 = points;
                        scoreboard3.setText("#3                 "+name+"                                       "+temp3);     
                    }
                   
                }
            }
        );

        credits = new JLabel("Created by: Gurjot Kooner");
        credits.setFont (new Font ("Arial", Font.BOLD, 30));
        credits.setForeground (Color.black);
        credits.setBounds(10,-80,500,200);

        title = new JLabel("");
        title.setIcon(new ImageIcon("titleimg.gif"));
        title.setBounds(525,0,500,200);
        //adding to background
        background.add(play);
        background.add(instructions);
        background.add(settings);
        background.add(scoreboard);
        background.add(credits);
        background.add(title);
        background.add(easteregg);

        //Each button has (button sound) to add a clicking noise to each button
    }

    public void eastereggmenu(){
        window.setSize(1440,900); 
        background.setIcon(new ImageIcon("playbg.jpg"));

        background.remove(play);
        background.remove(instructions);
        background.remove(settings);
        background.remove(scoreboard);
        background.remove(credits);
        background.remove(title);

        gurman1 = new JLabel("");
        gurman1.setIcon(new ImageIcon("Gurman.gif"));
        gurman1.setBounds(0,0,640,1140);

        jatt = new JLabel("");
        jatt.setIcon(new ImageIcon("jattgif.gif"));
        jatt.setBounds(700,300,611,80);

        exit = new JLabel("");
        exit.setIcon(new ImageIcon("exit.png"));
        exit.setBounds(1287,-189,500,450);

        jatty = new JLabel("");
        jatty.setIcon(new ImageIcon("jattdamuqabala.gif"));
        jatty.setBounds(700,600,444,250);

        exit.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    mainmenu(); 
                    background.remove(gurman1);
                    background.remove(exit);
                    background.remove(jatt);
                    background.remove(jatty);
                    test1234.stop();
                    bgMusic.start();
                    bgMusic.loop(Clip.LOOP_CONTINUOUSLY);
                    buttonSound();
                }
            }
        );

        background.add(gurman1);
        background.add(exit);
        background.add(jatt);
        background.add(jatty);
    }

    // Everything is very straight forward, just a bunch of JLabels
    public void playmenu(){
        window.setSize(1440,900); 
        play123 = (new ImageIcon("playbg2.jpg"));
        // changing the size to fit the new background
        //this is for the settings theme changer, a bunch of if statments for background while the JButtons changes the bg value
        if(bg == 1)
        {
            play123 = (new ImageIcon("playbg.jpg"));
        }
        else if (bg == 2)
        {
            play123 = (new ImageIcon("playbg2.jpg"));
        }
        else if (bg == 3)
        {
            play123 = (new ImageIcon("playbg3.jpg"));
        }
        else if (bg ==4)
        {
            play123 = (new ImageIcon("playbg4.jpg"));
        }
        background.setIcon(play123);
        background.remove(play);
        background.remove(instructions);
        background.remove(settings);
        background.remove(scoreboard);
        background.remove(credits);
        background.remove(title);
        // self explanatory, removing /adding new jlabels
        score=0;

        top = new JLabel("Cards Matched:" + score);
        top.setFont (new Font ("Arial", Font.BOLD, 30));
        top.setForeground (Color.blue);
        top.setBounds(1000,100,500,200);

        triesLabel = new JLabel("Tries Taken:" + tries);
        triesLabel.setFont (new Font ("Arial", Font.BOLD, 30));
        triesLabel.setForeground (Color.blue);
        triesLabel.setBounds(1000,200,500,200);

        exit = new JLabel("");
        exit.setIcon(new ImageIcon("exit.png"));
        exit.setBounds(1287,-189,500,450);

        exit.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    mainmenu(); 
                    background.remove(top);
                    background.remove(exit);  
                    background.remove(g);
                    background.remove(g2);
                    background.remove(triesLabel);
                    background.remove(restart);
                    tries =0;
                    buttonSound();
                    
                    
                }
            }
        );

        background.add(exit);
        background.add(top);
        background.add(triesLabel);
    }

    public void scoreboardmenu(){
        // scoreboard creation menu
        // adds many pictures to the background
        
        window.setSize(1440,810);
        background.setIcon(new ImageIcon("highscore.jpg"));
        background.remove(play);
        background.remove(instructions);
        background.remove(settings);
        background.remove(scoreboard);
        background.remove(credits);
        background.remove(title);

        exit = new JLabel("");
        exit.setIcon(new ImageIcon("exit.png"));
        exit.setBounds(1287,-189,500,450);

        scoreboardbgg = new JLabel("");
        scoreboardbgg.setIcon(new ImageIcon("scoreboardbg.png"));
        scoreboardbgg.setBounds(0,0,1440,810);

        scoreboardtop = new JLabel("");
        scoreboardtop.setIcon(new ImageIcon("scoreboardheadtop.png"));
        scoreboardtop.setBounds(0,0,1440,810);

        scoreboard1 = new JLabel("#1                 --                                       --");
        scoreboard1.setBounds(350,200,800,200);
        scoreboard1.setFont (new Font ("Arial", Font.BOLD, 30));
        scoreboard1.setForeground(Color.BLACK);
        background.add(scoreboard1);

        scoreboard2 = new JLabel("#2                 --                                       --");
        scoreboard2.setBounds(350,250,800,200);
        scoreboard2.setFont (new Font ("Arial", Font.BOLD, 30));
        scoreboard2.setForeground(Color.BLACK);
        background.add(scoreboard2);

        scoreboard3 = new JLabel("#3                 --                                       --");
        scoreboard3.setBounds(350,300,800,200);
        scoreboard3.setFont (new Font ("Arial", Font.BOLD, 30));
        scoreboard3.setForeground(Color.BLACK);
        background.add(scoreboard3);

                
        exit.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    mainmenu(); 

                    background.remove(exit);
                    background.remove(scoreboardbgg);
                    background.remove(scoreboardtop);
                    background.remove(scoreboard1);
                    background.remove(scoreboard2);
                    background.remove(scoreboard3);
                    //mouse listener for exit button, removes all the JLabels/buttons on exit click
                    buttonSound();
                }
            }
        );

        background.add(exit);

        background.add(scoreboardbgg);
        background.add(scoreboardtop);
    }

    public void settingsmenu(){
        window.setSize(1440,850); 
        background.remove(play);
        background.remove(instructions);
        background.remove(settings);
        background.remove(scoreboard);
        background.remove(credits);
        background.remove(title);

        top = new JLabel("");
        top.setIcon(new ImageIcon("settingslogo.png"));
        top.setBounds(500,50,504,129);

        unmute = new JLabel("");
        unmute.setIcon(new ImageIcon("unmute.png"));
        unmute.setBounds(738,550,256,256);

        mute = new JLabel("");
        mute.setIcon(new ImageIcon("mute.png"));
        mute.setBounds(1000,550,256,256);

        mutelabel = new JLabel("");
        mutelabel.setIcon(new ImageIcon("mutelabel.png"));
        mutelabel.setBounds(1075,370,300,300);

        background4 = new JButton("Freaky Mario");
        background4.setOpaque(true);
        background4.setBackground(Color.black);
        background4.setForeground(Color.white);
        background4.setFont (new Font ("Arial", Font.BOLD, 30));
        background4.setFocusPainted(false);
        background4.setBounds(400,450,250,100);

        background1 = new JButton("Retro Mario");
        background1.setOpaque(true);
        background1.setBackground(Color.black);
        background1.setForeground(Color.white);
        background1.setFont (new Font ("Arial", Font.BOLD, 30));
        background1.setFocusPainted(false);
        background1.setBounds(150,350,250,100);

        background3 = new JButton("Textured Mario");
        background3.setOpaque(true);
        background3.setBackground(Color.black);
        background3.setForeground(Color.white);
        background3.setFont (new Font ("Arial", Font.BOLD, 30));
        background3.setFocusPainted(false);
        background3.setBounds(150,450,250,100);

        background2 = new JButton("HD Mario");
        background2.setOpaque(true);
        background2.setBackground(Color.black);
        background2.setForeground(Color.white);
        background2.setFont (new Font ("Arial", Font.BOLD, 30));
        background2.setFocusPainted(false);
        background2.setBounds(400,350,250,100);
        // JButtons for changing backgrounds
        gamesize4x4 = new JButton("4 X 4");
        gamesize4x4.setOpaque(true);
        gamesize4x4.setBackground(Color.black);
        gamesize4x4.setForeground(Color.white);
        gamesize4x4.setFont (new Font ("Arial", Font.BOLD, 30));
        gamesize4x4.setFocusPainted(false);
        gamesize4x4.setBounds(250,675,150,100);

        gamesize6x6 = new JButton("6 X 6");
        gamesize6x6.setOpaque(true);
        gamesize6x6.setBackground(Color.black);
        gamesize6x6.setForeground(Color.white);
        gamesize6x6.setFont (new Font ("Arial", Font.BOLD, 30));
        gamesize6x6.setFocusPainted(false);
        gamesize6x6.setBounds(400,675,150,100);
        // attempted to add new game modes
        background1.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e ) {
                    bg = 1;

                }
            }
        );

        background2.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e ) {
                    bg = 2;

                }
            }
        );

        background3.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e ) {
                    bg = 3;

                }
            }
        );

        background4.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e ) {
                    bg = 4;

                }
            }
        );

        gamesize4x4.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e ) {
                    gs = 4;

                }
            }
        );

        gamesize6x6.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e ) {
                    gs =6;

                }
            }
        );

        mute.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e ) {
                    if (m == 0){
                        m = 1;
                        bgMusic.close();
                        mute.setVisible(false);
                        unmute.setVisible(true);
                    }
                    //mute button, this is to make the widget dissapear when you click on it, preventing double clicking
                }
            }
        );

        changebg = new JLabel("");
        changebg.setIcon(new ImageIcon("changebackgroundtext.png"));
        changebg.setBounds(120,-150,700,800);

        unmutelabel = new JLabel("");
        unmutelabel.setIcon(new ImageIcon("unmutelabel.png"));
        unmutelabel.setBounds(813,400,300,300);

        unmute.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    if (m == 1){
                        m = 0;
                        music();
                        mute.setVisible(true);
                        unmute.setVisible(false);
                        //same as mute button, unmutes music and makes it invisible after click
                    }
                }
            }
        );

        sfxmute = new JLabel("");
        sfxmute.setIcon(new ImageIcon("ringermute.png"));
        sfxmute.setBounds(1030,150,500,450);

        sfxmutelabel = new JLabel("");
        sfxmutelabel.setIcon(new ImageIcon("mutesfxlabel.png"));
        sfxmutelabel.setBounds(1090,80,300,300);

        sfxmute.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e ) {
                    if (sfxm == 0){
                        sfxm = 1;
                        isMuted = true;
                        sfxmute.setVisible(false);
                        sfxunmute.setVisible(true);
                    }
                }
            }
        );

        sfxunmute = new JLabel("");
        sfxunmute.setIcon(new ImageIcon("ringerunmute.png"));
        sfxunmute.setBounds(753,150,500,450);

        sfxunmutelabel = new JLabel("");
        sfxunmutelabel.setIcon(new ImageIcon("unmutesfxlabel.png"));
        sfxunmutelabel.setBounds(820,70,300,300);

        sfxunmute.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    if (sfxm == 1){
                        sfxm = 0;
                        isMuted = false;
                        sfxmute.setVisible(true);
                        sfxunmute.setVisible(false);
                        //sfxmute and unmute are the same as the regular mute and unmute
                    }
                }
            }
        );

        exit = new JLabel("");
        exit.setIcon(new ImageIcon("exit.png"));
        exit.setBounds(1287,-189,500,450);

        exit.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    mainmenu(); 
                    background.remove(top);
                    background.remove(exit);
                    background.remove(unmute);
                    background.remove(mute);
                    background.remove(mutelabel);
                    background.remove(unmutelabel);
                    background.remove(sfxmute);
                    background.remove(sfxunmute);
                    background.remove(sfxunmutelabel);
                    background.remove(sfxmutelabel);
                    background.remove(background1);
                    background.remove(background2);
                    background.remove(background3);
                    background.remove(background4);
                    background.remove(changebg);
                    buttonSound();
                    
                    //exit button removing a bunch of JLAbels
                }
            }
        );

        //Unmute button is set invisble when mute is clicked and vice versa to help pervent more than 2 audio streams playing at once
        background.add(mute);
        background.add(mutelabel);
        background.add(unmute);
        background.add(unmutelabel);
        background.add(exit);
        background.add(top);
        background.add(sfxmute);
        background.add(sfxunmute);
        background.add(sfxmutelabel);
        background.add(sfxunmutelabel);
        background.add(background1);
        background.add(background2);
        background.add(background3);
        background.add(background4);
        background.add(changebg);
       

    }

    public void instructionmenu(){
        window.setSize(1440,950); 
        background.setIcon(new ImageIcon("instructions.png"));
        background.remove(play);
        background.remove(instructions);
        background.remove(settings);
        background.remove(scoreboard);
        background.remove(credits);
        background.remove(title);

        exit = new JLabel("");
        exit.setIcon(new ImageIcon("exit.png"));
        exit.setBounds(1287,-189,500,450);

        exit.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    mainmenu(); 

                    background.remove(exit);  
                    buttonSound();
                }
            }
        );

        background.add(exit);
        // straightforward, exit button and a png image added ontop of the background
    }

    public void exit(){
        exit = new JLabel("");
        exit.setIcon(new ImageIcon("exit.png"));
        exit.setBounds(1287,-189,500,450);

        exit.addMouseListener(new MouseAdapter() 
            { 
                public void mouseClicked(MouseEvent e) {
                    mainmenu(); 
                    background.remove(top);
                    background.remove(exit);  
                    background.remove(g);
                    background.remove(g2);
                    background.remove(triesLabel);
                    background.remove(restart);
                    tries =0;
                    buttonSound();
                }
            }
        );
        //exit method, removes common JLabels, very useful
    }

    public void actualgame() {
        bah1=0;
        tries =0;
        triesLabel.setText("Tries Taken:" + tries);
        points =0;

        score =0;
        top.setText("Cards Matched:" + score);
        {
            JOptionPane.showMessageDialog(null, "Thank you for playing Mario Card Game!"  );
            int asd =1;
            //while loop checking if it the textbox is empty or not
            while(name == null || name.trim().isEmpty() || asd ==1  ){

                name = JOptionPane.showInputDialog(null, "Please choose a name: ");

                if(name != null && (!name.trim().isEmpty())){
                    // An array of type Object holds the two options "Yes I am sure", or "No I want to change it " this will be used in the OptionDialog

                    Object[] options = { "Yes, I am sure", "No, I want to change it" };

                    asd = JOptionPane.showOptionDialog(null, ("Are you sure you want "+name+" as your name."), "Choosing a name",

                        JOptionPane.DEFAULT_OPTION,JOptionPane.DEFAULT_OPTION , null, options, options[0]);
                    //checks for escape or exit button     
                    if(asd ==-1)
                    {
                        JOptionPane.showMessageDialog(null, "Do not close this window. ");
                        asd = 1;
                    }
                    //handles if they want to change it
                    else if(asd !=0)
                    {

                        JOptionPane.showMessageDialog(null, "Please choose a new name.");
                    }
                }  

                else
                {
                    JOptionPane.showMessageDialog(null, "Error! Invalid Input!");
                }

            }
            JOptionPane.showMessageDialog(null, "Welcome "+name+"!");
            //creating JButton arrays
            text = new JLabel [10];
            JButton a[] = new JButton [12];
            Panel g = new Panel (new GridLayout (4, 3));
            int num[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0, 0};

            for (int i = 0 ; i < a.length ; i++){
                a [i] = new JButton ("");
                a [i].addActionListener (this);
                a [i].setActionCommand ("" + num [i]);
                g.add (a[i]);
            }
            background.add(g);
        }

        // assigning random numbers from 0 to amount of jbuttons to the mirrored array b
        for (int i = 0 ; i < rows ; i++) {
            for (int j=0; j < columns; j++) { 
                b[i][j] = (i*rows +j);
                //assigns 2d array numbers from, 0-amount of jbuttons

            }
        }

        // do 100 random swaps in order to randomize the pictures each time
        for (int i=0; i <100 ; i++)
        {
            int x1 =(int)(Math.random() * ((3) + 1));
            int x2 =(int)(Math.random() * ((3) + 1));
            int y1 =(int)(Math.random() * ((3) + 1));
            int y2 =(int)(Math.random() * ((3) + 1));

            int temporary = b[x1][y1];

            b[x1][y1] = b[x2][y2];
            b[x2][y2] = temporary;
        }
        
        
        //Using JButton array and settting the card background as the image
        g = new JPanel (new GridLayout (rows, columns));
        g2 = new JPanel();
        for (int i = 0 ; i < rows ; i++) {
            for (int j=0; j < columns; j++) { 
                a [i][j] = new JButton ("");
                a [i][j].addActionListener (this);
                a [i][j].setActionCommand ("" + (i*10+j));
                //a[i][j].setIcon(new ImageIcon(imageArray[i*rows + j]));
                g.add (a [i][j]);
                a[i][j].setIcon(new ImageIcon("resizedv2.png"));
            }
        }
        //restart JButton setting up
        restart = new JButton ("Restart");
        restart.setOpaque(true);
        restart.setBackground(Color.black);
        restart.setForeground(Color.white);
        restart.setFont (new Font ("Arial", Font.BOLD, 30));
        restart.setFocusPainted(false);
        restart.setBounds(1000,600,300,100);
        background.add(restart);
        restart.addActionListener(new ActionListener() 
            { 
                public void actionPerformed(ActionEvent e ) {

                    background.remove(g);
                    background.remove(g2);

                    background.remove(restart);
                    window.setSize(1440,810);

                    tries =0;
                    points =0;
                    score =0;
                    buttonSound();
                       if (points > temp1)
                    {
                        temp1 = points;
                        scoreboard1.setText("#1                "+name+"                                       "+temp1);
                    }
                    else if(points > temp2)
                    {
                        temp2 = points;
                        scoreboard2.setText("#2                 "+name+"                                       "+temp2);               
                    }
                    else if (points > temp3)
                    {
                        temp3 = points;
                        scoreboard3.setText("#3                 "+name+"                                       "+temp3);     
                    }
                   
                    JOptionPane.showMessageDialog(null,"Continue?");
                    actualgame();
                    // simply resets scores, checks if your game should be on the scoreboard or not and makes a new array
                    bah2 = 1000 - 10 * bah1;
                    
                    

                }
            }
        );

        g2.add(status);      
        status.setText(" ");
        background.add (g);

        g.setBounds(400,50,533,800);
        g2.setBounds(400,50,533,800);
        background.add (g2);
        //end
        Timer test = new Timer(10, new ActionListener()
                {

                    public void actionPerformed(ActionEvent e)
                    {
                        window.setSize(1440,910); 

                    }

                }
            );
        test.start();
        test.setRepeats(false);
        // This timer is needed because of a glitch with BlueJ that does not show the array unless the window size is shifted a bit
        //checkduplicate();

    }

    public void checkduplicate(){
    }

    public void actionPerformed (ActionEvent e){
        //checking for win conditions in action performed
        int n = Integer.parseInt (e.getActionCommand ());
        int x = n / 10;
        int y = n % 10;
        status.setText("You pressed: " + "(" + x + ", " + y + ")");
        // Taken from google classroom, used to find the box number clicked
        if (lastx == 1000 && lasty == 1000){
            //used 1000 for lastx and y because the x,y values will never go over these naturally
            a[x][y].setIcon(new ImageIcon("images4x4/image"+b[x][y]+".png"));  
            lastx = x;
            lasty = y;
            // using randomized cards (from swap) and setting images to each
        }
        else {
            tries++;
            bah1++;
            triesLabel.setText("Tries taken:" + tries);
            // check if matching 
            // if not matching set both pictures to back and set lastx and y to 1000
            if ((b[x][y] == (b[lastx][lasty] + 8 )) ||( b[x][y] == (b[lastx][lasty] - 8) )) 
            {
                a[x][y].setIcon(new ImageIcon("images4x4/image"+b[x][y]+".png"));  

                a[x][y].setEnabled(false);
                a[lastx][lasty].setEnabled(false);

                lastx = 1000;
                lasty = 1000;
                
                score += 1;
                top.setText("Cards Matched:" + score);

            }
            else 

            {

                a[x][y].setIcon(new ImageIcon("images4x4/image"+b[x][y]+".png"));  
                // if it is not a match sets the images back
                Timer test = new Timer(200, new ActionListener()
                        {

                            public void actionPerformed(ActionEvent e)
                            {
                                a[lastx][lasty].setIcon(new ImageIcon("resizedv2.png"));
                                a[x][y].setIcon(new ImageIcon("resizedv2.png"));

                                lastx = 1000;
                                lasty = 1000;
                            }

                        }
                    );
                    // 200 millisecond wait before switching pictures back to normal
                test.start();
                test.setRepeats(false);

            }
        }

        if (score ==8){
            JOptionPane.showMessageDialog(null,"You have won the game in "+tries+ " tries!" );
            points = 1000 - 10 * tries;
            JOptionPane.showMessageDialog(null,"You had a score of " + points );
            // checking if game has been won or not
        
            
           
            
            
            
        }
    }
    // bunch of music methods, called when needed (i.e button sound effects and background music)
    public void music (){
        try{
            URL url = this.getClass().getResource("mariomusic.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            bgMusic = AudioSystem.getClip();
            bgMusic.open(audioIn);
            bgMusic.loop(Clip.LOOP_CONTINUOUSLY);

        } 
        catch(Exception g){
            JOptionPane.showMessageDialog(null,"There was an error loading the sound!");
        }

        //Background music code
    }

    public void buttonSound(){
        if (isMuted == false) {
            try{
                URL url = this.getClass().getResource("ButtonSound.wav");
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                Clip test123 = AudioSystem.getClip();
                test123.open(audioIn);
                test123.start();

            } 
            catch(Exception g){
                JOptionPane.showMessageDialog(null,"There was an error loading the sound!");
            }
            //Button clicking sound noise for each click
        }
    }

    public void easterSound(){
        try{
            URL url = this.getClass().getResource("audioclip12ee.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            test1234 = AudioSystem.getClip();
            test1234.open(audioIn);
            test1234.start();
            test1234.loop(Clip.LOOP_CONTINUOUSLY);
        } 
        catch(Exception g){
            JOptionPane.showMessageDialog(null,"There was an error loading the sound!");
        }
    }
    
    public void VictorySound(){
        try{
            URL url = this.getClass().getResource("win.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            test12345 = AudioSystem.getClip();
            test12345.open(audioIn);
            test12345.start();
        } 
        catch(Exception g){
            JOptionPane.showMessageDialog(null,"There was an error loading the sound!");
        }
    }

    protected static ImageIcon createImageIcon (String path){
        java.net.URL imgURL = MarioCardGame.class.getResource( path);
        if (imgURL != null){
            return new ImageIcon (imgURL);
        } else {
            System.err.println( "Couldn't find file: " + path);
            return null;
        }
        //Error catching for images
    }//end ImageIcon
}
