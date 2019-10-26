package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Book {
    private String filePath ;
    private List wordL ;


    Book(String f) {

        this.filePath = f;
        this.wordL = wordL ;

    }


    public String getfilePath(){
            return filePath;
        }

        public List getwordL(){
        return wordL;
        }

        public void setfilePath(String filePath) {
        this.filePath = filePath; }

        public void setwordL(List worldL) {
        this.wordL = wordL; }



    public int getLineCount() {


        int lineCount = 0;
        Scanner scFile;
        try {
            // Acces au fichier motAndy.txt
            scFile = new Scanner(new File(filePath));
            // Lecture du Book jusqu'à la fin et incrémentation du nombre de lignes
            while (scFile.hasNextLine())
            {
                scFile.nextLine();
                lineCount = lineCount + 1;
            }
            scFile.close();

        } catch (Exception e)
        {
            System.out.println("Acces fichier impossible");
            System.exit(0);
        }
        return lineCount;
    }

    public HashMap getWordOccurence() {


        String lineRead = " ";
        HashMap<String, Integer> wordOccurence = new HashMap<>();
        int wordCount = 0;
        Scanner scFile;
        try {
            // Acces au fichier motAndy.txt
            scFile = new Scanner(new File(filePath));
            // Lecture du Book jusqu'à la fin et incrémentation du nombre de lignes
            while (scFile.hasNextLine())
            {
                lineRead = scFile.nextLine();
                if (wordOccurence.containsKey(lineRead)) {
                    wordCount = wordOccurence.get(lineRead);
                    wordCount = wordCount + 1 ;
                    wordOccurence.put(lineRead,wordCount);
                } else {
                    wordOccurence.put(lineRead, 1);
                }
            }
//            for (int i = 0; wordOccurence.size();i++)
//            {
//                List wordCount50Most = ArrayList(wordOccurence.get(i));
//
//                wordCount50Most.sort();
//                System.out.println("50 first " + wordCount50Most);
//            }

            scFile.close();

        } catch (Exception e)
        {
            System.out.println("Acces fichier impossible");
            System.exit(0);
        }
        return wordOccurence ;
    }

}
