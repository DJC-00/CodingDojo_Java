package com.caresoftinterfaces.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPPACompliantUser  {

    private ArrayList<String> patientNotes;

    public Physician(Integer id) {
        super(id);
        
    }

    @Override
    public boolean assignPin(int pin) {
        if (String.valueOf(pin).length() == 4){
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (this.id == confirmedAuthID){
            return true;
        }
        return false;
    }
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
}
