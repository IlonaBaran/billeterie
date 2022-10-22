package com.octest.beans;

public class Utilisateur {
	private String id;
    private String surname;
    private String firstname;
    private String statut;
    
    public boolean equals(Utilisateur user) { 
        if (user.surname.equals(this.surname) && user.firstname.equals(this.firstname) && user.statut.equals(this.statut)) { 
        	return true; 
        }
        else {
        	return false;
        }
    }  
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    
	public String toString(){
		return this.surname + this.firstname + this.statut;
	}
}