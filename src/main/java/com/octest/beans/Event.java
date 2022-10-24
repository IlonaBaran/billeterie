package com.octest.beans;

public class Event {
	
	private String id;
    private String name;
    private String conference_room;
    private String date;
    private String time;
    private String covid_mode;
    private String description;
    private String free_seats;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getConferenceRoom() {
        return conference_room;
    }
    public void setConferenceRoom(String conference_room) {
        this.conference_room = conference_room;
    }
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getCovidMode() {
        return covid_mode;
    }
    public void setCovidMode(String covid_mode) {
        this.covid_mode = covid_mode;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getFreeSeats() {
        return free_seats;
    }
    public void setFreeSeats(String free_seats) {
        this.free_seats = free_seats;
    }
    

}
