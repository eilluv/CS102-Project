/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs102_project;

/**
 *
 * @author cyanr
 */

import java.util.ArrayList;
import java.util.List;

abstract class Event implements interEvent {
    private final String id;
    private String name;
    private int maxCapacity;
    private final List<String> attendees;

    public Event(String id, String name, int maxCapacity) {
        this.id = id;
        setName(name);
        setMaxCapacity(maxCapacity);
        this.attendees = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Event name cannot be empty.");
        }
        this.name = name;
    }

    public int getMaxCapacity() { return maxCapacity; }
    
    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Max capacity must be greater than zero.");
        }
        this.maxCapacity = maxCapacity;
    }

    @Override
    public List<String> getAttendees() { return attendees; }

    @Override
    public boolean registerAttendee(String attendeeName) {
        if (attendees.size() < maxCapacity) {
            attendees.add(attendeeName);
            System.out.println(" Successfully registered " + attendeeName + " for event " + name);
            return true;
        }
        System.out.println(" Registration failed: Event " + name + " is full.");
        return false;
    }

    @Override
    public int getAvailableCapacity() {
        return maxCapacity - attendees.size();
    }

    @Override
    public final void displayDetails() {
        System.out.println("------------------------------------");
        System.out.println("Event ID: " + id);
        System.out.println("Title: " + name);
        System.out.println("Capacity: " + attendees.size() + " / " + maxCapacity + " (Available: " + getAvailableCapacity() + ")");
        displaySpecificDetails();

        System.out.println("Registered Attendees:");
        if (attendees.isEmpty()) {
            System.out.println("  - None yet.");
        } else {
            for (String attendee : attendees) {
                System.out.println("  - " + attendee);
            }
        }
    }

    protected abstract void displaySpecificDetails();
    public abstract boolean removeAttendee(String attendeeName);
}

