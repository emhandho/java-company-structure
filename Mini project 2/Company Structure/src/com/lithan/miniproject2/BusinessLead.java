package com.lithan.miniproject2;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
    private int headCount;
    protected ArrayList<Accountant> directReport = new ArrayList<>();

    public BusinessLead(String name) {
        /*Should create a new BusinessLead that is a Manager. The BusinessLead's
        * base salary should be twice that of an Accountant. They sould start with
        * a head count of 10.*/
        super(name);
        this.setBaseSalary(getBaseSalary() * 2);
//        directReport = new ArrayList<>();
        this.headCount = 10;
    }

    public boolean hasHeadCount() {
        /*Should return true if the number of direct reports this
         * manager has is less than their headcount.*/
//        directReport = new ArrayList<>();
        if (this.directReport.size() < this.headCount)
            return true;
        else
            return false;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        /*Should accept the reference to an Accountant object, and if
        * the BusinessLead has head count left should add this employee
        * to their list of direct reports. If the employee is seccessfully
        * added to the BusinessLead's direct reports true should be returned,
        * false should be returned otherwise. Each time a report is added
        * the BusinessLead's bonus budget should be icrease by 1.1 times
        * that new employee's team they are supporting should be updated to
        * reflect the reference to the TechnicalLead given. If the employee
        * is successfully added true should be returned, false otherwise*/
        if (hasHeadCount()) {
            directReport.add(e);
            e.setManager(this);
            this.bonusBudget  +=  e.getBaseSalary()*1.1;
            e.supportTeam(supportTeam);
            supportTeam.setAccountanSupport(e);
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (this.bonusBudget >= bonus) {
            e.setBaseSalary(getBaseSalary() + bonus);
            this.bonusBudget -= bonus;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus) {
        boolean result = false;
        for (Accountant a : directReport) {
            if (a.getTeamSupport() == e.getManager()){
                if (a.approveBonus(bonus)) {
                    e.setBaseSalary(getBaseSalary() + bonus);
                    a.bonusBudget -= bonus;
                    result = true;
                }
            }
        }
        return result;
    }

    public String getTeamStatus() {
        String result;
        if (directReport.size() == 0){
            result = this.employeeStatus() + " and no direct report yet.";
        } else {
            result = this.employeeStatus() + " and is managing: \n";
            for (Accountant a : directReport) {
                result += "\t" + a.employeeStatus() + "\n";
            }
        } return result;
    }
}
