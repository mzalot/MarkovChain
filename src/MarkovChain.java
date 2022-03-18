/**
 MarkovChain
 The program will create a MarkovChain
 Author: Mareks Zeile
 Collaborator(s):
 Collaboration:
 Date: 3/15/22
 On My Honor, I confirm that I followed all collaboration policy guidelines, and that the work I am submitting is my own: MZ
 **/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class MarkovChain {
    //instance data
    private Scanner s;
    private Dictionary dict;
    private File file;
    private String storeFileName;
    private Random r;
    private String words;
    private Dictionary d;

    //default constructor
    //ask for file
    public MarkovChain(){
        s = new Scanner(System.in);
        System.out.println("Enter file name: ");
        storeFileName = s.nextLine();
        dict = new Dictionary();
        file = new File(storeFileName);
        r = new Random();
        words = "";
        d = new Dictionary();

    }

    //read the text
    public boolean readText(){
        //did it work
        boolean didWork = true;
        try {
            //scan file
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                //space to separate the words
                words += " ";
                words += fileReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            didWork = false;
        }
        System.out.println(words);
        return didWork;
    }

    //add the words to the dictionary
    public void addToDictionary(){
        //create array to store the words in
        String[] wordsArray;
        //use split method to split the strings
        wordsArray = words.split(" ");
        //testing
        //for(int i = 0; i<wordsArray.length; i++){
        //    System.out.println(wordsArray[i]);
        //}
    }

}
