package com.company;

public class Word {

    private String wordValue;
    private Integer wordOccurence;


    public Word(String wordValue, Integer WordOccurence){
        this.wordOccurence = wordOccurence ;
        this.wordValue = wordValue ;
    }

    // Getter et setter pour l'attribut WordValue

    public String getWordValue() {
        return wordValue ;
    }
    public void setWordValue(){
        this.wordValue = wordValue;
    }

    // Getter et Setter pour l'attribut WordOccurence

    public Integer getWordOccurence(){
        return wordOccurence;
    }

    public void setWordOccurence(){
        this.wordOccurence = wordOccurence;
    }



}
