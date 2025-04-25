package com.pluralsight;

public class Employee {

    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;
    private float overtimeHours;


    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public float getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(float overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
    public double getGrossPay(){
        double result = 0.0;
       if(hoursWorked <= 40){
           result =  this.hoursWorked * this.payRate;
       } else {
           double overtimeHours = hoursWorked - 40;
           double standard_pay = 40 * payRate;
           double overtimeRate = payRate * 1.5;
           double overtimePay = overtimeHours * overtimeRate;
           result = standard_pay + overtimePay;


       }
        return result;
    }

    public String formatEmployeeInformation(){
        return String.format("%2d %2s %.1f %.1f", this.employeeId, this.name, this.hoursWorked, this.payRate);
    }



}




