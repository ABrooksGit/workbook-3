package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;


public class Main {

    private static Employee[] employees = getReadingFile();
    private static Console console = new Console();

    public static void main(String[] args) {
        // Must Display as id|name|hours-worked|pay-rate

//        getReadingFile();
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i] != null) {
//                //System.out.println(employees[i].formatEmployeeInformation());
//                System.out.printf("%2d|%2s|%.1f|%.1f\n", employees[i].getEmployeeId(), employees[i].getName(), employees[i].getHoursWorked(), employees[i].getPayRate());
//
//                System.out.println(employees[i].getGrossPay() + "|" + employees[i].getName() + "'s Total Pay" + "\n");
//            }
//
//
//        }






    }



    private static Employee[] getReadingFile() {
        try {
            FileReader fr = new FileReader("file.csv");
            BufferedReader reader = new BufferedReader(fr);

            Employee[] employeesFiles = new Employee[1000];

            int size = 0;
            String dataString;

            while ((dataString = reader.readLine()) != null) {
                employeesFiles[size] = payEncodedString(dataString);

                size++;
            }
            return employeesFiles;

        } catch (Exception e) {
            System.out.println("Error");
            return new Employee[0];
        }



    }

    private static Employee payEncodedString(String encodedFile) {

        String[] file = encodedFile.split(Pattern.quote("|"));


        int id = Integer.parseInt(file[0]);
        String name = file[1];
        double hoursWorked = Double.parseDouble(file[2]);
        double payRate = Double.parseDouble(file[3]);

        Employee result = new Employee(id, name, hoursWorked, payRate);
        return result;
    }


    private static void writeToCsvFile(){
        console.promptForString("Enter the name of the file employee file to process: ");
        console.promptForString("Enter the name of the payroll file to create: ");

    }



}