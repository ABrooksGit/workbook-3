package com.pluralsight;
import java.io.*;
import java.util.regex.Pattern;


public class Main {
    private static Console console = new Console();
    private static Employee[] employees;


    public static void main(String[] args) {
        // Must Display as id|name|hours-worked|pay-rate

        employees = getReadingFile();



        writeToCsvFile();





    }



    private static Employee[] getReadingFile() {
        //Prompt for the user to select which file
        String readFilePrompt = "Enter the name of the file employee file to process: ";

        try {
            //Read from a file that is already present
            String employeeFile = console.promptForString(readFilePrompt);
            FileReader fr = new FileReader(employeeFile);
            BufferedReader reader = new BufferedReader(fr);


            //Make sure the array has enough Employees
            Employee[] employeesFiles = new Employee[1000];

            int size = 0;
            String dataString;

            while ((dataString = reader.readLine()) != null) {
                employeesFiles[size] = payEncodedString(dataString);

                size++;
            }


            return employeesFiles;

        } catch (Exception e) {
            throw new RuntimeException(e);

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
        try {
            //Ask the user to input the file they wish to create
            String payRollFile = console.promptForString("Enter the name of the payroll file to create: ");
            FileWriter fileWriter = new FileWriter(payRollFile,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            //Apply Array to new file
            for (Employee employee : employees) {
                if (employee != null) {
                    payRollFile = (String.format("ID %2d|Employee %s|GrossPay %.1f\n",
                            employee.getEmployeeId(),
                            employee.getName(),
                            employee.getGrossPay()));
                    bufferedWriter.write(payRollFile);
                }
            }
            //Makes sure the text gets added
            bufferedWriter.close();

            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}