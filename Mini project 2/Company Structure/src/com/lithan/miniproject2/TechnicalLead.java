package com.lithan.miniproject2;

import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {

    private int headCount;
    private Accountant accountantSupport;
    protected ArrayList<SoftwareEngineer> directReport = new ArrayList<>();

    public TechnicalLead(String name) {
        /*Should create a new TechnicalLead that is a Manager.
        * The TechnicalLead's base salary should be 1.3 times
        * that of a TechnicalEmployee.
        * TechnicalLeads should have a default head count of 4*/
        super(name);
        this.setBaseSalary(this.getBaseSalary() * 1.3);
        this.headCount = 4;
    }

    public boolean hasHeadCount() {
        /*Should return true if the number of direct reports this
        * manager has is less than their headcount.*/
//        directReport = new ArrayList<>();
        if (directReport.size() < this.headCount)
            return true;
        else
            return false;
    }

    public int getHeadCount() {
        return headCount;
    }

    public void setAccountanSupport(Accountant accountantSupport) {
        this.accountantSupport = accountantSupport;
    }

    public Accountant getAccountantSupport() {
        return accountantSupport;
    }

    public boolean addReport(SoftwareEngineer e) {
        /*Should accept the reference to a SoftwareEngineer object,
        * and if the TechnicalLead has head count left should add
        * this employee to their list of direct reports.
        * If the employee is successfully added to the TechnicalLead's
        * direct reports true should be returned, false should be returned otherwise*/
        if (hasHeadCount()) {
            directReport.add(e);
            e.setManager(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        /*Should see if the employee passed in does report to this manager
        * and if their code access is currently set to "true".
        * if both those things are true, true is returned, otherwise
        * false is returned.*/
        if ((e.getManager().equals(this)) && e.getCodeAccess()) {
            this.setCheckIns(this.getCheckIns()+1);
            return true;
        } else {
            return false;
        }
    }

    public String getTeamStatus() {
        /*Should return a String that gives insight into this Manager
        * and all their direct reports. It should return a string that is
        * a combination of the TechnicalLead's employee status followed by
        * each of their direct employee's status on subsequent lines.
        * if the TechnicalLead has no reports it should print their
        * employee status followed by the text " and no direct reports yet".
        * Example: "10 Kasey has 5 successful check ins and no direct reports yet."
        * if the TechnicalLead does have reports, it might look something like
        * "10 Kasey has 5 successful check ins and is amanging: /n
        * 5 Niky has 2 successfull check ins."*/
        String result = "";
        if (directReport.size() == 0){
            result = this.employeeStatus() + " and no direct report yet.";
        } else {
            result = this.employeeStatus() + " and is managing: \n";
            for (SoftwareEngineer e : directReport) {
                result += "\t" + e.employeeStatus() + "\n";
            }
        } return result;
    }

    public boolean requestBonus(Employee e, double bonus) {
        boolean result = false;
        if (((BusinessLead) this.getAccountantSupport()
                .getManager()).approveBonus(e, bonus)) {
            e.setBaseSalary(getBaseSalary() + bonus);
            result = true;
        }
        return result;
    }
}
