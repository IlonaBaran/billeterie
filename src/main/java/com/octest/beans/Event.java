package com.octest.beans;

public class Event {
	
	private String id;
    private String name;
    private String conferenceRoom;
    private String date;
    private String time;
    private String covidMode;
    
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
        return conferenceRoom;
    }
    public void setConferenceRoom(String conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
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
        return covidMode;
    }
    public void setCovidMode(String covidMode) {
        this.covidMode = covidMode;
    }
}
