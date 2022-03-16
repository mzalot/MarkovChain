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
        //store key and value
        String key = "";
        //check if key is filled
        boolean keyFilled = false;
        String value = "";
        for(int i = 0;i<words.length();i++){
            if(words.charAt(i) == ' ' && value != ""){
                d.put(key,value);
                System.out.println(key);
                System.out.println(value);
                key = value;
            } else if (words.charAt(i) == ' ' && key != ""){
                keyFilled = true;
            } else if(value == "" && words.charAt(i) != ' ' && !keyFilled){
                key += words.charAt(i);
                System.out.println("key " + key);
            } else if (key != "" && words.charAt(i) != ' '){
                value += words.charAt(i);
                System.out.println("value" + value);
            }
        }
    }
}
