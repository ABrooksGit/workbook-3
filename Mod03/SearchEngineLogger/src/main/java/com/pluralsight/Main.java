package com.pluralsight;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final Console console = new Console();

    public static void main(String[] args) {

        //Begins Application

        String launchApplication = "Say 'launch' to begin application: ";
        String launch = console.promptForString(launchApplication);

        //Launch to BeginSearch Method
        if (launch.equalsIgnoreCase("launch")) {
            beginSearch();


        } else {
            System.out.println("Incorrect word, please use launch to start");

        }
    }

    //Process and Format of writing to a file
    private static void formatAndWriterManager(String write){
        try {
            FileWriter log = new FileWriter("logs.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(log);
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter iso =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String correctFormat = today.format(iso);
            bufferWriter.write(correctFormat + " " + write);
            bufferWriter.newLine();
            bufferWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

/* Using beginSearch to track the users commands and inputting them into a text file
using formatAndWriterManager calling a String because we need to input that String into
the bufferWriter.
 */
    private static void beginSearch(){

        String searchTerm;

        do {
            searchTerm = console.promptForString("Enter a search term(X to exit): ");
         if(searchTerm.equalsIgnoreCase("X")){
             formatAndWriterManager("exit");
             return;
         } else {

             formatAndWriterManager("search: " + searchTerm);

         }

        } while(!searchTerm.equalsIgnoreCase("X"));

    }



}