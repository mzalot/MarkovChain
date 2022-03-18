/**
 MarkovChainDriver
 The program will create a driver for the MarkovChain class
 Author: Mareks Zeile
 Collaborator(s):
 Collaboration:
 Date: 3/16/22
 On My Honor, I confirm that I followed all collaboration policy guidelines, and that the work I am submitting is my own: MZ
 **/

public class MarkovChainDriver {
    public static void main(String[] args) {
        MarkovChain m = new MarkovChain();
        m.readText();
        m.addToDictionary();
        System.out.println(m.createText());
    }
}
