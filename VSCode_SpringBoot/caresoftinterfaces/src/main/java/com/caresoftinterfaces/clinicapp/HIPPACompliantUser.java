package com.caresoftinterfaces.clinicapp;


public interface HIPPACompliantUser {
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}
    

