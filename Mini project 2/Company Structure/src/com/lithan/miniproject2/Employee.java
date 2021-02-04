package com.lithan.miniproject2;

public abstract class Employee {
    static int id = 1;
    private int employeeID;
    private String name;
    private double baseSalary;
    private Employee manager;
//    protected double bonusBudget;

    public Employee(String name, double baseSalary) {
        //Construct employee with two parameters name and base salary
        this.employeeID = id;
        this.name = name;
        this.baseSalary = baseSalary;
        ++id;
    }

    public double getBaseSalary() {
        //Should return the employee's base salary
        return this.baseSalary;
    }

    public void setBaseSalary(double baseSalary) {this.baseSalary = baseSalary;}

    public String getName() {
        //Should return the employee's name
        return this.name;
    }

    public int getEmployeeID() {
        //Should return the employee's ID
        return this.employeeID;
    }

    public Employee getManager() {
        /*Should return a reference to the Employee object that
        represents this employee's manager*/
        return this.manager;
    }

    public void setManager(Employee manager) {this.manager = manager;}

    public boolean equals(Employee other) {
        /*Should return true if the two employee's ID are the same,
        * false otherwise*/
        if (this.getEmployeeID() == other.getEmployeeID())
            return true;
        else
            return false;
    }

    public String toString() {
        /*Should return a String representatiom of the employee that
        * is a combination of their id followed by their name.*/
        //Example: "1 Kasey"
        return "(" + this.getEmployeeID() + ")" + this.getName();
    }

    public abstract String employeeStatus();
    /*Should return a String representation of that Employee's
    * current status. This will be different for every subclass of
    * Employee*/

}
