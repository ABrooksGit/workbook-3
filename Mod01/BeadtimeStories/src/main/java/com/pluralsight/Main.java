package com.pluralsight;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private  static  Console console = new Console();
    public static void main(String[] args) {

        BedtimeStoryScreen();


    }
    private static void BedtimeStoryScreen() {

       String bedTimePrompt ="Select which bedtime story you want to read: \n" +
                "1: Goldilocks and the Three Bears \n" +
                "2: Hansel and Gretel\n" +
                "3: Mary had a little Lamb\n" +
                "Please enter 1-3: ";

        int option = 0;



        do {
            option = console.promptForInt(bedTimePrompt);

            if (option == 1) {
                System.out.println("You chose Goldilocks and the Three Bears: ");
                ReadGoldiLocks();


            } else if (option == 2) {
                System.out.println("You chose Hansel and Gretel");
                ReadHanselAndGretel();


            } else if (option == 3) {
                System.out.println("You chose Mary had a little Lamb");
                ReadMaryHadALittleLamb();


            } else if (option == 0) {
                System.out.println("GoodNight");

            } else {
                System.out.println("Not a Valid Number, please try again");

            }


        }while (option != 0);





    }
    private static void ReadGoldiLocks(){
        try {
            FileInputStream storyTime = new FileInputStream("goldilocks.txt");
            Scanner scanner = new Scanner(storyTime);

            String input;

            while (scanner.hasNextLine()) {
                input = scanner.nextLine();
                System.out.println(input);
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        }
    private static void ReadHanselAndGretel(){
        try {
            FileInputStream storyTime = new FileInputStream("hansel_and_gretel.txt");
            Scanner scanner = new Scanner(storyTime);

            String input;

            while (scanner.hasNextLine()) {
                input = scanner.nextLine();
                System.out.println(input);
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static void ReadMaryHadALittleLamb(){
        try {
            FileInputStream storyTime = new FileInputStream("mary_had_a_little_lamb.txt");
            Scanner scanner = new Scanner(storyTime);

            String input;

            while (scanner.hasNextLine()) {
                input = scanner.nextLine();
                System.out.println(input);
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }





