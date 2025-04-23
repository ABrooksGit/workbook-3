package com.pluralsight;
import java.io.BufferedReader;
import  java.io.FileReader;


public class BufferReaderDemo {

    public static void main(String[] args){

        try {
            FileReader fr = null;
            fr = new FileReader("jokes.txt");

            BufferedReader br = new BufferedReader(fr);

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Oh no! THERE SEEMS TO BE AN ISSUE");
        }



    }
}
