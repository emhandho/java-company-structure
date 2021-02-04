package com.lithan.miniproject2;

public class TechnicalEmployee extends Employee {
    private int checkIns = 0;
    // Technical Employee is the sub class of the super class Employee

    public TechnicalEmployee(String name) {
        //Has default base salary of 75000
        super (name, 75000);
    }

    public int getCheckIns() {return checkIns;}
    public void setCheckIns(int checkIns) {this.checkIns = checkIns;}

    public String employeeStatus() {
        /*Should return a String representation of this TechnicalEmployee
        * Example: "1 Kasey has 10 successful check ins"*/
        return this + " has " + this.checkIns + " successful check ins.";
    }
}
