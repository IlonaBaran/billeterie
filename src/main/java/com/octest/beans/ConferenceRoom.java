package com.octest.beans;

public class ConferenceRoom {
	private String id;
	private String name_room;
	private String seats_room;
	
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name_room;
    }
    public void setName(String name_room) {
        this.name_room = name_room;
    }
    
    public String getSeats() {
        return seats_room;
    }
    public void setSeats(String seats_room) {
        this.seats_room = seats_room;
    }
}
