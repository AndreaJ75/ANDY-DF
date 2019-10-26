package com.company;


import sun.jvm.hotspot.compiler.OopMapSet;

import java.util.*;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //String filePath = "/home/bnp-renault-005/Bureau/Andrea/GITHUB2/java-project-books/books/motsAndy.txt";
        int menuChoisiN = 0;
        String menuChoisi = "";
        String question = "N° de choix du Menu : ";
        ArrayList menu = new ArrayList(Arrays.asList());

        ArrayList<Book> files = new ArrayList<Book>();

        // Display des Menus :


        menu = initMenu("Principal");

        do {

            //Afficher menu en fonction option : menu;
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(menu.get(i));
            }

            // Enreg. du choix de Menu 1 :
            System.out.println(question);
            // Sauvegarde de entrée clavier :
            Scanner scMenu = new Scanner(System.in);
            menuChoisi = scMenu.nextLine();

            boolean flagCheckSaisi = false;
            do {


                try {
                    menuChoisiN = Integer.parseInt(menuChoisi);
                } catch (Exception e) {
                    flagCheckSaisi = false;
                    System.out.println("Veuillez rentrer une valeur de menu numérique");
                    menuChoisi = scMenu.nextLine();

                }


                if (menuChoisiN >= 1 && menuChoisiN <= menu.size()) {
                    flagCheckSaisi = true;
                } else {
                    System.out.println("Veuillez rentrer une valeur de menu compris dans ceux fourni");
                    menuChoisi = scMenu.nextLine();
                }
            } while (flagCheckSaisi == false);

            // Check du Menu choisi :
            //checkMenuChoisi(menuChoisiN,menu);
            evalActionCase(menuChoisiN, files, menu);

        } while (menuChoisiN != 5);

    }

    public static ArrayList initMenu(String menuType) {


        ArrayList menuAAfficher = new ArrayList(Arrays.asList());

        if (menuType.equals("Principal")) {

            menuAAfficher.addAll(Arrays.asList(
                    " 1. Lister les fichiers ",
                    " 2. Ajouter un fichier ",
                    " 3. Supprimer un fichier ",
                    " 4. Afficher les informations sur un livre ",
                    " 5. Quitter le programme "));

        } else if (menuType.equals("detailFic")) {

            menuAAfficher.addAll(
                    Arrays.asList(
                            " 1. Nombre de lignes du fichier ",
                            " 2. Nombre de mots du fichier "));


        }
        return menuAAfficher;
    }


    public static String evalActionCase(int menuChoisi, ArrayList<Book> files, ArrayList<String> menuAAfficher) {

        //Set<Book> books = new HashSet<>();

        //Book book1 = new Book(filePath);

        //files.add((book1));

        String res = " ";


        switch (menuChoisi) {
            case 1: {
                res = "LIST";

                // Lecture de la Collection de fichier chargé sur case 2
                for (int i = 0; i < files.size(); i++) {
                    System.out.println((i + 1) + " : " + files.get(i).getfilePath());
                }

                break;
            }
            case 2: {
                res = "ADD";
                // chargement des noms de fichiers saisis dans une ArrayList
                System.out.println("Saisissez le path du fichier : ");
                Scanner scListFile = new Scanner(System.in); // lecture fichier saisi sur clavier)
                String fichierACreer = scListFile.nextLine();
                Book book2 = new Book(fichierACreer);

                files.add((book2));

                //Affichage des fichiers créés :

                for (int i = 0; i < files.size(); i++) {
                    System.out.println((i + 1) + " : " + files.get(i).getfilePath());
                }
                break;
            }
            case 3: {
                res = "DEL";
                // Lecture de la Collection de fichier chargé sur case 2 (idem case 1)
                for (int i = 0; i < files.size(); i++) {
                    System.out.println("AVANT :" + (i + 1) + " : " + files.get(i).getfilePath());
                }
                // Demande de choix de ArrayList à Supprimer
                System.out.println("Saisissez le N° du fichier à supprimer : ");
                Scanner scDelFile = new Scanner(System.in); // lecture n° fichier a delete sur clavier)
                int ficNumToDelete = scDelFile.nextInt();

                // Delete de l'ArrayList correspondant à l'index de l'ArrayList choisi
                files.remove(ficNumToDelete - 1);

                // Display pour s'assurer qu'on a bien deleter l'attendu
                for (int i = 0; i < files.size(); i++) {
                    System.out.println("APRES : " + (i + 1) + " : " + files.get(i).getfilePath());
                }

                break;
            }
            case 4: {
                res = "SHOW";
                // Lecture de la Collection de fichier chargé sur case 2
                for (int i = 0; i < files.size(); i++) {
                    System.out.println((i + 1) + " : " + files.get(i).getfilePath());
                }
                // Proposer le choix de fichier à consulter
                System.out.println("Choix de fichier à consulter : ");
                Scanner scSelFile = new Scanner(System.in); // lecture n° fichier a sélectionner
                int ficNumToSelect = scSelFile.nextInt();
                // On Stocke le numéro du nom du fichier sélectionné à consulter :
                String filePath = files.get(ficNumToSelect - 1).getfilePath();
                // Affichage du Menu détail fichier :

                ArrayList menu = initMenu("detailFic");
                for (int i = 0; i != menu.size(); i++) {
                    System.out.println(menu.get(i));
                }
                System.out.println(" ");

                // Proposer le type de consultation (Nbr ligne/nbr mots) sur fichier à réaliser
                System.out.println("Choix de consultation fichier : ");
                Scanner scFileSelChoice = new Scanner(System.in); // lecture n° du type de consultation voulu
                int fileSelChoice = scFileSelChoice.nextInt();
                // Instanciation du livre fourni
                Book book2 = new Book(filePath);
                // En fonction du choix selectionné : Acces utilisation de fonction nbrLineWord avec param adequat
                if (fileSelChoice == 1) {
                    // ArrayList wordList = new ArrayList();
                    // lecture du book pour obtenir le nomnbre de mots total

                    int lineCount = book2.getLineCount();
                    System.out.println("NBR de mots total " + lineCount);
                    System.out.println(" ");
                } else {
                    HashMap wordOccurences = new HashMap();
                    System.out.println("NBR de MOTS DIFFERENTS " + book2.getWordOccurence());
                }
                break;
            }
            default: {
                System.err.println("QUIT");
            }
        }
        return res;

    }
}