package com.lithan.miniproject2;

public class BusinessEmployee extends Employee {

    protected double bonusBudget;

    public BusinessEmployee(String name) {
        //Has a default salary of 50000
        super(name, 50000);
    }

    public double getBonusBudget() {
        /*Should establish a running tally of the reamining bonusBudget
        * for the team this employee supports. How that budget is
        * determine will depend on which type of Business Employee*/
        return bonusBudget;
    }

    public String employeeStatus() {
        /*Should return a String representation of this BusinessEmployee
        * that include their ID, name and the size of their currently
        * managed budget.
        * Example: "1 Kasey with a budget of 22500.0"*/
        return this + " with a budget of " + this.getBonusBudget();
    }
}
