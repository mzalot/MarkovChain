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
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class MarkovChain {
    //instance data
    private Scanner s;
    private File file;
    private String storeFileName;
    private Random r;
    private String words;
    private Dictionary d;
    private int wordsToGenerate;
    private String saveFile;
    //create array to store the words in
    String[] wordsArray;

    //default constructor
    //ask for file
    public MarkovChain(){
        s = new Scanner(System.in);
        System.out.println("Enter file name: ");
        storeFileName = s.nextLine();
        file = new File(storeFileName);
        r = new Random();
        words = "";
        d = new Dictionary();
        System.out.println("Enter a file name to store results in: ");
        saveFile = s.nextLine();
        System.out.println("How many words would you like to generate: ");
        wordsToGenerate = s.nextInt();
        Random r = new Random();

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
                words += fileReader.nextLine();
                words += " ";
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            didWork = false;
        }
        //System.out.println(words);
        return didWork;
    }

    //add the words to the dictionary
    public void addToDictionary(){
        //use split method to split the strings
        wordsArray = words.split(" ");
        //add the words and prefixes to the dictionary
        for(int i = 0;i<wordsArray.length;i++){
            //array list to put values in
            ArrayList<String> values = new ArrayList<String>();
            if(i == wordsArray.length-1){
                d.put(wordsArray[i], values);
            } else if(d.contains(wordsArray[i])){
                ((ArrayList)d.get(wordsArray[i])).add(wordsArray[i+1]);
                //System.out.println(wordsArray[i]);
            } else {
                values.add(wordsArray[i+1]);
                d.put(wordsArray[i], values);
            }
        }
        //testing
        //for(int i = 0; i<wordsArray.length; i++){
        //    System.out.println(wordsArray[i]);
        //}
        //testing dictionary
        //System.out.println(d.keys());
        //System.out.println(d.values());
    }

    //create text
    public String createText(){
        //generate a random value for starting word
        int randomWord = r.nextInt(wordsArray.length);
        String start = wordsArray[randomWord];
        //string to store text in
        String storeText = start + " ";
        //string to store current key word
        String keyWord = start;
        //loop to add words to create text
        for(int i = 0; i<wordsToGenerate-1; i++){
            //random to get a random value from each key
            //System.out.println(keyWord + " " + i);
            int val;
            int bound = ((ArrayList)d.get(keyWord)).size();
            val = r.nextInt(bound);
            storeText += ((ArrayList)d.get(keyWord)).get(val);
            storeText += " ";
            keyWord = (String)((ArrayList)d.get(keyWord)).get(val);
        }
        //save to file
        try {
            FileWriter myWriter = new FileWriter(saveFile);
            myWriter.write(storeText);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return storeText;

    }

}
