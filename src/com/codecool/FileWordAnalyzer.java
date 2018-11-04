package com.codecool;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    public FileWordAnalyzer(FilePartReader file) {

    }


    public ArrayList wordsByABC() throws FileNotFoundException {
        String text = readFile();
        List<String> wordsArrayList = new ArrayList<>();

        wordsArrayList = Arrays.asList(text.split(" "));
        Collections.sort(wordsArrayList, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(wordsArrayList.toArray()));
        return new ArrayList(wordsArrayList);
    }


    public ArrayList wordsContainingSubString(String subString) throws FileNotFoundException {
        String text = readFile();
        List<String> wordsArrayList = new ArrayList<>();
        List<String> sortedArrayList = new ArrayList<>();

        wordsArrayList = Arrays.asList(text.split(" "));
        for (String temp : wordsArrayList) {
            if(temp.toLowerCase().contains(subString.toLowerCase())){
                sortedArrayList.add(temp);
            }
        }
        System.out.println(Arrays.toString(sortedArrayList.toArray()));
        return new ArrayList(sortedArrayList);
    }


   public ArrayList wordsArePalindrome() throws FileNotFoundException {
       String text = readFile();
       List<String> wordsArrayList = new ArrayList<>();
       List<String> palindromeArrayList = new ArrayList<>();

       wordsArrayList = Arrays.asList(text.split(" "));
       for (String temp : wordsArrayList) {
           String reversedTemp = new StringBuilder(temp).reverse().toString();
           if(temp.equals(reversedTemp) && temp.length() > 1){
               palindromeArrayList.add(temp);
           }
       }
       System.out.println(Arrays.toString(palindromeArrayList.toArray()));
       return new ArrayList(palindromeArrayList);
   }

   private String readFile() throws FileNotFoundException {
       FilePartReader fileReader = new FilePartReader();
       fileReader.setup("sample.txt", 1, 5);
       String text = fileReader.readLines();

       return text;
   }
}
