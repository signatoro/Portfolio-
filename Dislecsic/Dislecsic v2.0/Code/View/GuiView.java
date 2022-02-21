package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Controller.GameController;
import Model.Player;
import Util.GameState;
import Util.Global;
import Util.Sec;

public class GuiView extends JFrame implements KeyListener{

    //Main Panel Objects
    private JPanel mainPanel;
    

    //Game Screen Objects
    private JSplitPane gamePanel;

    private JPanel textPanel;
    private JPanel inputPanel;

    private JLabel questionLabel;
    private JLabel currentInputLabel;


    // Menu Screen Objects
    private JPanel menuPanel;

    private JLabel titleLabel;
    private JLabel playLabel;
    private JLabel loadLabel;
    private JLabel instructionLabel;
    private JLabel creditsLabel;
    private JLabel quitLabel;

    private int menuChoice;

    // Load Screen
    private JPanel loadPanel;
    private JEditorPane loadText;

    // Instruction Screen Objects
    private JPanel instructionPanel;
    private JEditorPane instructionText;

    //Credit Screen Objects
    private JPanel creditPanel;
    private JEditorPane creditText;



    //Variables 
    private StringBuffer text;
    private StringBuffer lastInput;
    private int pointerIndex;
    private Boolean gettingInput;
    private Dimension windowSize;

    
    
    //Lists
    private List<JLabel> listOfLabels;


    public GuiView(String appName) {
        super(appName);
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        setSize(550, 750);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listOfLabels = new ArrayList<JLabel>();
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);

        ImageIcon icon = new ImageIcon("lib/Mushroom.png");
        setIconImage(icon.getImage());

        add(mainPanel);
        windowSize = this.getSize();

        this.menuScreen();
        this.gameScreen();
        this.loadScreen();
        this.instructionScreen();
        this.creditScreen();





        setVisible(true);        
    }


    public void update() {
        validate();
        Sec.delayMil(30);

        this.update();
    }







    public void printText() {
        for (int i = 0; i < listOfLabels.size() - 1; i++) {
            listOfLabels.get(i).setText(listOfLabels.get(i + 1).getText());
        }
        listOfLabels.get(listOfLabels.size() - 1).setText(" ");
    }

    public void printText(String s) {
        for (int i = 0; i < listOfLabels.size() - 1; i++) {
            listOfLabels.get(i).setText(listOfLabels.get(i + 1).getText());
            
        }
        listOfLabels.get(listOfLabels.size() - 1).setText("<html>"+ s + "</html>");
    }

    public void printText(int v) {
        for (int i = 0; i < listOfLabels.size() - 1; i++) {
            listOfLabels.get(i).setText(listOfLabels.get(i + 1).getText() );
        }
        listOfLabels.get(listOfLabels.size() - 1).setText("<html>"+v+ "</html>");
    }

    public void printText(double v) {
        for (int i = 0; i < listOfLabels.size() - 1; i++) {
            listOfLabels.get(i).setText(listOfLabels.get(i + 1).getText() );
        }
        listOfLabels.get(listOfLabels.size() - 1).setText("<html>"+v+ "</html>");
    }

    public void printText(boolean b) {
        for (int i = 0; i < listOfLabels.size() - 1; i++) {
            listOfLabels.get(i).setText(listOfLabels.get(i + 1).getText() );
        }
        listOfLabels.get(listOfLabels.size() - 1).setText("<html>"+b+ "</html>");
    }









    public String getInput() {
        currentInputLabel.setText("|");
        
        questionLabel.setText("\t" + "What would you like to do?");

        gettingInput = true;

        while(gettingInput) {
            Sec.delayMil(5);
        }
        
        StringBuffer input = new StringBuffer(currentInputLabel.getText());
        input.deleteCharAt(pointerIndex);
        if (input.charAt(0) == ' ') {
            input.deleteCharAt(0);
        }
        

        questionLabel.setText("");
        currentInputLabel.setText("");

        return input.toString();
    }

    public String getInput(String stringQuestion) {
        currentInputLabel.setText("|");
        
        questionLabel.setText("\t" + stringQuestion);

        gettingInput = true;


        while(gettingInput) {
            Sec.delayMil(5);
        }
        

        StringBuffer input = new StringBuffer(currentInputLabel.getText());
        input.deleteCharAt(pointerIndex);
        if (input.charAt(0) == ' ') {
            input.deleteCharAt(0);
        }
        

        questionLabel.setText("");
        currentInputLabel.setText("");

        return input.toString();
    }


    
    public void printMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "message", JOptionPane.PLAIN_MESSAGE);
    }

    
    public void printError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void printError(Exception message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }




    //Initialized and Constructs the game Screen
    public void menuScreen() {
        menuChoice = 1;

        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.PAGE_AXIS));
        menuPanel.setBackground(Color.BLACK);
        menuPanel.setSize(this.getSize());


        JLabel spaceLabel1 = new JLabel();
        spaceLabel1.setText(" ");
        spaceLabel1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 130));
        JLabel spaceLabel2 = new JLabel();
        spaceLabel2.setText(" ");
        spaceLabel2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 50));


        titleLabel = new JLabel();
        titleLabel.setText("Dislecsic");
        titleLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);

        playLabel = new JLabel();
        playLabel.setText("> pla <");
        playLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
        playLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        playLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playLabel.setForeground(Color.WHITE);

        loadLabel = new JLabel();
        loadLabel.setText("load");
        loadLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
        loadLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        loadLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loadLabel.setForeground(Color.WHITE);

        instructionLabel = new JLabel();
        instructionLabel.setText("instrucshions");
        instructionLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionLabel.setForeground(Color.WHITE);

        creditsLabel = new JLabel();
        creditsLabel.setText("credits");
        creditsLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
        creditsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        creditsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        creditsLabel.setForeground(Color.WHITE);

        quitLabel = new JLabel();
        quitLabel.setText("kwit");
        quitLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
        quitLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        quitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quitLabel.setForeground(Color.WHITE);

        menuPanel.add(spaceLabel1);
        menuPanel.add(spaceLabel2);
        menuPanel.add(titleLabel);
        menuPanel.add(playLabel);
        menuPanel.add(loadLabel);
        menuPanel.add(instructionLabel);
        menuPanel.add(creditsLabel);
        menuPanel.add(quitLabel);

    }

    //Initialized and Constructs the Game Screen
    public void gameScreen() {

        gamePanel = new JSplitPane();
        gamePanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
        gamePanel.setDividerLocation(650);
        gamePanel.setSize(this.getSize());

        

        textPanel = new JPanel();
        textPanel.setBackground(Color.BLACK);
        textPanel.setLayout(new GridLayout(0, 1, 2, 2));
        textPanel.setSize(this.getSize());
        

        inputPanel = new JPanel();
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setLayout(new GridLayout(2, 1));
        inputPanel.setSize(this.getSize());



        questionLabel = new JLabel();
        questionLabel.setText("");
        questionLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
        questionLabel.setForeground(Color.WHITE);

        currentInputLabel = new JLabel();
        currentInputLabel.setText(" |");
        currentInputLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
        currentInputLabel.setForeground(Color.WHITE);


        gettingInput = false;
        
        
        for (int i = 0; i < 10; i++) {

            JLabel tempL = new JLabel();
            tempL.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 19));
            tempL.setForeground(Color.WHITE);
            tempL.setHorizontalAlignment(SwingConstants.LEFT);
        
            listOfLabels.add(tempL);
            textPanel.add(tempL);
        }
        
        inputPanel.add(questionLabel);
        inputPanel.add(currentInputLabel);

        gamePanel.setTopComponent(textPanel);
        gamePanel.setBottomComponent(inputPanel);

    }

    // Initialized and constructs the Load Screen
    public void loadScreen() {
        loadPanel = new JPanel();
        loadPanel.setBackground(Color.BLACK);
        loadPanel.setSize(windowSize);

        loadText = new JEditorPane();
        loadText.setBackground(Color.BLACK);
        loadText.setForeground(Color.WHITE);
        loadText.setSize(windowSize);
        loadText.setEditable(false);

        loadText.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 13));
        
        loadText.setText("Load Game:\n\n\n");

        loadText.setText(loadText.getText() + "This is currently not implimented.\n");
        loadText.setText(loadText.getText() + "Sorry for the inconvience\n\n\n");

        loadText.setText(loadText.getText() + "PRESS ANY KEY TO EXIT\n");

        loadPanel.add(loadText);

    }

    

    //Initialized and constructs the Instruction Screen
    public void instructionScreen() {

        instructionPanel = new JPanel();
        instructionPanel.setBackground(Color.BLACK);
        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.PAGE_AXIS));
        instructionPanel.setSize(windowSize);

        instructionText = new JEditorPane();
        instructionText.setBackground(Color.BLACK);
        instructionText.setForeground(Color.WHITE);
        instructionText.setSize(windowSize);
        instructionText.setEditable(false);


        
        instructionText.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 13));

        // Commands during Exploration
        instructionText.setText("Commands While Exploring\n\n");

        // Move
        instructionText.setText(instructionText.getText() + "To Move you would type \"Go\" then North, East, South or West\n");
        instructionText.setText(instructionText.getText() + "    To go North you would type \"Go North\"\n");

        // Pick up
        instructionText.setText(instructionText.getText() + "To Pick stuff up you would type \"Grab\" then the name of the item\n");
        instructionText.setText(instructionText.getText() + "    To pick up a stick you would time \"Grab Stick\"\n");

        // Say
        instructionText.setText(instructionText.getText() + "To Say something you would type \"Say\" then what you want to say\n");
        instructionText.setText(instructionText.getText() + "    To say hello you would type \"Say Hello\"\n");

        // Check
        instructionText.setText(instructionText.getText() + "To Check your Inventory or Health you would type \"Check\" \n");
        instructionText.setText(instructionText.getText() + "    To check your health you would type \"Check health\"\n");

        // Open
        instructionText.setText(instructionText.getText() + "To Open something you would type \"Open\" then what you want to open\n");
        instructionText.setText(instructionText.getText() + "    To open a chest you would type \"Open Chest\"\n");

        // Inspect
        instructionText.setText(instructionText.getText() + "To Inspect an item you would type \"Inspect\" then type the item name\n");
        instructionText.setText(instructionText.getText() + "    To inspect a stick you would type \"Inspect Stick\"\n\n\n");

        // Commands During Combat
        instructionText.setText(instructionText.getText() + "Commands During Combat\n\n");

        // Sword
        instructionText.setText(instructionText.getText() + "To Attack with an weapon you would type \"Attack with\" then the weapon\n");
        instructionText.setText(instructionText.getText() + "    To attack with a sword you would type \"Attack with sword\"\n");

        // Magic
        instructionText.setText(instructionText.getText() + "To cast a spell you would type \"Cast spell with\" then the item\n");
        instructionText.setText(instructionText.getText() + "    To cast a spell you would type  \"Cast spell with wand\"\n");

        // Use
        instructionText.setText(instructionText.getText() + "To drink a potion you would type \"Use\" then the name of the potion\n");
        instructionText.setText(instructionText.getText() + "    To drink a health potion you would type  \"Use health potion\"\n");
        // Run
        instructionText.setText(instructionText.getText() + "To run away you would type \"Run\" then North, East, South or West\n");
        instructionText.setText(instructionText.getText() + "    To run North you would type  \"Run North\"\n\n\n");

        // General Command & Infor
        instructionText.setText(instructionText.getText() + "General Commands & Information\n\n");
        
        
        // Rest
        instructionText.setText(instructionText.getText() + "In order to restore Hp you can Rest, but you can only rest 3 times.\n");
        instructionText.setText(instructionText.getText() + "    To rest type \"Rest\"\n\n");

        // Help
        instructionText.setText(instructionText.getText() + "If you for get the Commands you can type \"Help\" and it will bring up this list\n\n");

        instructionText.setText(instructionText.getText() + "You can PRESS THE ARROW KEYS to retype your last command\n\n");
        // Case
        instructionText.setText(instructionText.getText() + "The commands are not case sensitve\n\n");

        instructionText.setText(instructionText.getText() + "Helpful Information:\n");
        instructionText.setText(instructionText.getText() + "It is recommended to play this game with a piece of graph paper and map the \n");
        instructionText.setText(instructionText.getText() + "world as you go. It will help you from getting lost and confused.\n\n");;

        instructionText.setText(instructionText.getText() + "PRESS ANY KEY TO EXIT\n");

        
        instructionPanel.add(instructionText);
    }

    //Initialized the Credit Screen
    public void creditScreen() {

        creditPanel = new JPanel();
        creditPanel.setBackground(Color.BLACK);
        creditPanel.setSize(this.getSize());

        creditText = new JEditorPane();
        creditText.setBackground(Color.BLACK);
        creditText.setForeground(Color.WHITE);
        creditText.setEditable(false);
        creditText.setSize(this.getSize());

        creditText.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 13));
        creditText.setText("Credits:\n\n");

        creditText.setText(creditText.getText() + "Programmed by Scott Pignataro\n");
        creditText.setText(creditText.getText() + "Story written by Scott Pignataro\n");
        creditText.setText(creditText.getText() + "Everything else by Scott Pignataro\n\n\n");
        creditText.setText(creditText.getText() + "PRESS ANY KEY TO EXIT\n");

        creditPanel.add(creditText);

    }

    
    public void panelSwitcher(GameState state) {
        mainPanel.removeAll();
        switch(state) {
            case MENU:
                mainPanel.add(menuPanel);
                break;
            case PLAY:
                mainPanel.setLayout(new GridLayout());
                mainPanel.add(gamePanel);
                break;
            case LOAD:
                mainPanel.add(loadPanel);
                break;
            case INSTRUCTIONS:
                mainPanel.add(instructionPanel);
                break;
            case CREDITS:
                mainPanel.add(creditPanel);
                break;
        }
        mainPanel.repaint();
        mainPanel.validate();
        add(mainPanel);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(Global.gamestate) {
            case MENU:
                menuInputHelper(e);
                break;
            case PLAY:
                userInputHelper(e);
                break;
            case LOAD:
                Global.gamestate = GameState.MENU;
                this.panelSwitcher(Global.lastGameState);
                break;
            case INSTRUCTIONS:
                this.panelSwitcher(Global.lastGameState);
                Global.gamestate = Global.lastGameState;
                break;
            case CREDITS:
                Global.gamestate = GameState.MENU;
                this.panelSwitcher(Global.gamestate);
                break;
            default:
                printError("Key Released: out off Switch Case");
        }
    }

    public void menuInputHelper(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_DOWN && menuChoice != 5) {
            switch(menuChoice) {
                case 1: 
                    playLabel.setText("pla");
                    loadLabel.setText("> load <");
                    menuChoice++;
                    break;
                case 2:
                    loadLabel.setText("load");
                    instructionLabel.setText("> instrucshions <");
                    menuChoice++;
                    break;
                case 3:
                    instructionLabel.setText("instrucshions");
                    creditsLabel.setText("> credits <");
                    menuChoice++;
                    break;
                case 4:
                    creditsLabel.setText("credits");
                    quitLabel.setText("> kwit <");
                    menuChoice++;
                    break;
                default: 
                    this.printError("GUIVIEW: menuInputHelper. whoops");

            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP && menuChoice != 1) {
            switch(menuChoice) {
                case 2: 
                    playLabel.setText("> pla <");
                    loadLabel.setText("load");
                    menuChoice--;
                    break;
                case 3:
                    loadLabel.setText("> load <");
                    instructionLabel.setText("instrucshions");
                    menuChoice--;
                    break;
                case 4:
                    instructionLabel.setText("> instrucshions <");
                    creditsLabel.setText("credits");
                    menuChoice--;
                    break;
                case 5:
                    creditsLabel.setText("> credits <");
                    quitLabel.setText("kwit");
                    menuChoice--;
                    break;
                default: 
                    this.printError("GUIVIEW: menuInputHelper. whoops");

            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            switch(menuChoice) 
            {
                case 1:
                    Global.lastGameState = Global.gamestate;
                    Global.gamestate = GameState.PLAY;
                    gamePanel.removeAll();
                    this.gameScreen();
                    this.panelSwitcher(Global.gamestate);

                    Player player = new Player("Scott", 0, 0, 0, 20, 0);
                    Model.Map forestMap = new Model.Map("Forst Map");
                    GameController controller = new GameController(player, forestMap);

                    Global.gameThread = new Thread("New Thread") {
                        public void run(){
                            
                            controller.gameloop();
                        }
                    };
                    Global.gameThread.start();
                    break;
                case 2: 
                    Global.lastGameState = Global.gamestate;
                    Global.gamestate = GameState.LOAD;
                    this.panelSwitcher(Global.gamestate);
                    break;
                case 3:
                    Global.lastGameState = Global.gamestate;
                    Global.gamestate = GameState.INSTRUCTIONS;
                    this.panelSwitcher(Global.gamestate);
                    break;
                case 4:
                    Global.lastGameState = Global.gamestate;
                    Global.gamestate = GameState.CREDITS;
                    this.panelSwitcher(Global.gamestate);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default: 
                    this.printError("GUIVIEW: menuInputHelper. whoops");

            }
        }
    }


    public void userInputHelper(KeyEvent e) {
        pointerIndex = currentInputLabel.getText().indexOf('|');
        text = new StringBuffer(currentInputLabel.getText());

        text.deleteCharAt(pointerIndex);
        
        if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK || e.getKeyCode() == KeyEvent.VK_SHIFT) {

        }
        else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && text.length() > 0) {
            text.deleteCharAt(pointerIndex-1);
            pointerIndex--;
            currentInputLabel.setText((text.insert(pointerIndex, "|")).toString());
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER && text.length() > 1) {
            lastInput = text;
            gettingInput = false;
            currentInputLabel.setText((text.insert(pointerIndex, "|")).toString());
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            text = lastInput;
            pointerIndex = text.length();
            currentInputLabel.setText(text.toString());
        } 
        else if (gettingInput) {
            text.insert(pointerIndex, e.getKeyChar());
            pointerIndex++;
            currentInputLabel.setText((text.insert(pointerIndex, "|")).toString());
        }
    }
}
