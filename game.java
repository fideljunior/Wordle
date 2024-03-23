import javax.swing.*;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Stack;

public class Game extends JPanel implements Runnable{
    private BufferedImage back;
    
    private Word[][] gameBoard;
    private String ans, displayText;
    private Stack<Integer> keylogged;
    private int playerPosRow, playerPosCol;
    private char keyPressed, keyReleased, playerkey, defaultchar;
    private List master;
    private static ArrayList<Character> wordBreakdown = new ArrayList<Character>();

    
    public Game() {
        back=null;
        this.addKeyListener(this);
        new Thread(this).start();

        master = new chosenword();
        defeaultchar = 33;
        gameBoard = setBoard();
        ans = chosenword.getRandomWord();
        System.out.println(ans);
        displayText = "";
        wordBreakdown = setWordBreakdown();
        playerPosCol = 0;
        playerPosRow = 0;
        keyPressed = 7;
        playerkey = 0;


    }

    public void run() {
        try {
            while(true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        }
    catch(Exception e) {}
    }

    public void paint (Graphics g)
    {Graphics2D twoDgraph = (Graphics2D)g;
    if (back==null) {
        back =(BufferedImage) (createImage(getWidth(), getHeight()));
            }
    Graphics g2d = back.createGraphics();
        
        for(int j=0; j<6; j++){
            for(int i=0; i<5; i++){
                g2d.setColor(gameBoard[i][j].getColor());
                g2d.fillRect(gameBoard[i][j].getx(), gameBoard[i][j].gety(), gameBoard[i][j].getLength(), gameBoard[i][j].getWidth());
                g2d.setColor(Color.BLACK);
                g2d.drawString(String.valueOf(gameBoard[i][j].getChar()), 25+(55*i), 55+(55*j));
                g2d.drawRect(gameBoard[i][j].getx(), gameBoard[i][j].gety(, gameBoard[i][j].getLength(), gameBoard[i][j].getWidth));

             }
        }




        twoDgraph.drawImage(back, 0, 0, null);
}

public Word[][] setBoard(){
    Word[][] prac = new Word[5][6];
    for(int j=0; j<6; j++){
        for(int i=0; i<5; i++){
            prac[i][j] = new Word(15+(55*i), 15+(55*j), 50, 50, defaultchar, Color.BLACK);
            System.out.println(String.valueOf(prac[i][j].getChar()));
            prac[i][j].setColor(Color.LIGHT_GRAY);
        }
    
    }
    return prac;
}

public boolean isOccupied(int c, int r){
    boolean empty = false

    if(gameBoard[c][r].getChar() != defaultchar)
        empty=true;

    return empty;
}

public void getGuess(){
    String guess = "Try Again :)";

    if(playerPosCol == 4&&isOccupied(4, playerPosRow)){
        guess="";
        System.out.println("Entering guess");
        for(int i=0; i<5; i++){
            guess+=gameBoard[i][playerPosRow].getChar();
        }
    }

    if(master.getWordBank().contains(guess)){
        System.out.println("Good Job");
        checkguess(guess);
        playerPosRow++;
        playerPosCol=0;
    } else{
        System.out.println("Try Again");
        displayText= "TryAgain";
    }
}

public ArrayList<Character> setWordBreakdown(){
    ArrayList<Character> example = new ArrayList<Character>();

    for(int i=0; i< ans.length(); i++){
        example.add(ans.charAt(i));
    }

    return example;
}

public void checkGuess(String g){
    for(int i=0; i< ans.length(); i++){
        if(wordBreakdown.get(i)==g.charAt(i)){
            gameBoard[i][playerPosRow].setColor(Color.GREEN);

        }else{
            gameBoard[i][playerPosRow].setColor(Color.DARK_GRAY);

        }
    }
}

public static int countMatches(ArrayList<Character> testlist, Character input){
    int count =0;
    for (Character item: testlist){
        if(item.equals(input)){
            count++
        }
    }
    return count;
}

public coloredAmount(ArrayList<Character> testlist, Character c){
    int amount =0;
    for(Character item: testlist){
        if(gameBoard[testlist.indexOf(item)][playerPosCol].getColor()==Color.Green||gameBoard[testlist.indexOf(item)][playerPosCol].getColor()==Color.YELLOW){
            amount++;
        }
    }
    return amount;
}

@Override
public void keyPressed(java.awt.event.KeyEvent e){
    keyPressed = e.getKeyChar();

}

public void keyReleased(java.awt.event.KeyEvent e){

    char realChar;
    keyReleased = e.getKeyChar();

    if(keyPressed==keyReleased){
        playerkey=keyReleased;
        System.out.println(playerkey);
        System.out.println(e.getKeyCode());
    }

    if((e.getKeyCode()>=65)&&(e.getKeyCode()<=90)&&!isOccupied(playerPosCol, playerPosRow)){
        realChar=Character.toUpperCase(e.getKeyChar());
        gameBoard[playerPosCol][playerPosRow].setChar(realChar);
        System.out.println("assigned to board""+playerPosCol"+playerPosRow );
        realChar= defaultchar;
        
        if(playerPosCol<4)
        playerPosCol++;
    }

    if(playerkey==(char)8){
        if(playerPosCol>0&&(playerPosCol<4||!isOccupied(4, playerPosRow)))
        playerPosCol--;

        gameBoard[playerPosCol][playerPosRow].setChar(defaultchar);
        System.out.println("deleted chracter in column"+playerPosCol+""+playerPosRow);
    }

    if(playerkey==(char)10){
        System.out.println("Checking guess");

        getGuess();
    }
}

playerkey=0;

}