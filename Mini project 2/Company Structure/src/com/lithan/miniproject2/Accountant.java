package com.lithan.miniproject2;

import java.util.ArrayList;

public class Accountant extends BusinessEmployee {

    private TechnicalLead supportTeam;
//    protected ArrayList<TechnicalLead> TSupportTeam = new ArrayList<>();

    public Accountant(String name){
        /*Should start with bonus budget of 0 and no team they are officially supporting*/
        super(name);
        this.bonusBudget = 0;

    }

    public TechnicalLead getTeamSupport() {
        /*Should return a reference to the TechnicalLead that this Accountant
        * is currently supporting. If they have not been assign a TechnicalLead
        * null should be returned.*/
        if (supportTeam != null)
            return this.supportTeam;
        else
            return null;
    }

    public void supportTeam(TechnicalLead Tlead) {
            this.supportTeam = Tlead;
            double amount = Tlead.directReport.size();
            this.bonusBudget += (amount*75000) + (75000*0.1);
    }

    public boolean approveBonus(double bonus) {
        if ((this.bonusBudget < bonus) || this.getTeamSupport() == null)
            return false;
        else
            return true;
    }

    public String employeeStatus() {
        return this + " with a budget of "
                + this.getBonusBudget() + " is supporting " + this.getTeamSupport();
    }
}
