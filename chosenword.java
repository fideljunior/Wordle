import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class list {

    private static ArrayList<String> wordBank = new ArrayList<String>();
    private File myFile = new File ("");

    public list(){
        String randomword = new String();
        try {
            setWords();
            randomword = getRandomWord();
        } catch (FileNotFoundException e) {
            //TODO Auto-generated catch block

            e.printStackTrace();

        }
    }

    public void setWords() throws FileNotFoundException {
        Scanner s = new Scanner(myFile);

        while(s.hasNextLine()){
            String thisword = s.nextLine();
            String realword = thisword.toUpperCase();

            wordBank.add(realword);

        }
        s.close();
    }

    public String getRandomWord(){
        return (String) wordBank.get((int) (Math.random()*wordBank.size()));

    }

    public ArrayList<String> getWordBank(){
        return wordBank;
        
    }
}