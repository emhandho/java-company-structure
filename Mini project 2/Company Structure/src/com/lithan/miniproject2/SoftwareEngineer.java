package com.lithan.miniproject2;

public class SoftwareEngineer extends TechnicalEmployee {
    private boolean codeAccess;
    public SoftwareEngineer(String name) {
        /*Should start without access to code and with 0 code check ins*/
        super(name);
        this.codeAccess = false;
        this.setCheckIns(0);
    }

    public boolean getCodeAccess() {
        /*Should return whether or not this SoftwareEngineer has access
        * to make changes to the code base*/
        return this.codeAccess;
    }

    public void setCodeAccess(boolean  access) {
        /*Should allow an external piece of code to update the
        * SoftwareEngineer's code privileges to either true or false*/
        this.codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        /*Should return the current count of how many times
        * this SoftwareEngineer has successful checked in code*/
        return this.getCheckIns();
    }

    public boolean checkInCode() {
        /*Should check if this SoftwareEngineer's manager approves of their
        * check in. If the check in is approved their successful checkin count
        * should be increased and the method should return "true". If the
        * manager does not approve the check in the SoftwareEngineer's code
        * access should be changed to false and the method should return "false*/

        boolean managerApproval = false;
        //How does the manager approve, not clear at this moment.
        //So we introduce one variable for the manager approval

        TechnicalLead manager = (TechnicalLead) this.getManager();
        if (manager == null) return false;
        managerApproval = manager.approveCheckIn(this);
        if (managerApproval) {
            this.setCheckIns(this.getSuccessfulCheckIns()+1);
            return true;
        } else {
            this.codeAccess = false;
            return false;
        }

    }
}
