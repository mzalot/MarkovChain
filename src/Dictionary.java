/**
 Dictionary
 The program will create a Dictionary
 Author: Mareks Zeile
 Collaborator(s):
 Collaboration:
 Date: 2/14/22
 On My Honor, I confirm that I followed all collaboration policy guidelines, and that the work I am submitting is my own: MZ
 **/

import java.util.ArrayList;
import java.util.Collection;

public class Dictionary <T, E>{
    //instance data
    //arraylists for the key and data
    private ArrayList<T> values;
    private ArrayList<E> keys;

    //default constructor
    public Dictionary(){
        values = new ArrayList<>();
        keys = new ArrayList<>();
    }

    //put method
    public void put(E key, T value){
        keys.add(key);
        values.add(value);
    }

    //get method
    public T get(E key){
        int indexOfKey = keys.indexOf(key);
        return values.get(indexOfKey);
    }

    //remove method
    public T remove(E key){
        int indexOfKey = keys.indexOf(key);
        keys.remove(indexOfKey);
        return values.remove(indexOfKey);
    }

    //contains method
    public boolean contains(E key){
        int indexOfKey = keys.indexOf(key);
        return indexOfKey >= 0;
    }

    //isEmpty method
    public boolean isEmpty(){
        return !(values.size() > 0);
    }

    //size method
    public int size(){
        return keys.size();
    }
    //return a collection of keys
    public Collection<E> keys(){
        Collection collection = keys;
        return collection;
    }

    //return a collection of values
    public Collection<E> values(){
        Collection collection = values;
        return collection;
    }
}

