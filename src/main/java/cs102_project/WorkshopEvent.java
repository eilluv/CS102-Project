/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs102_project;

/**
 *
 * @author cyanr
 */

class WorkshopEvent extends Event {
    private String topic;
    private String instructor;

    public WorkshopEvent(String id, String name, int maxCapacity, String topic, String instructor) {
        super(id, name, maxCapacity);
        this.topic = topic;
        this.instructor = instructor;
    }

    @Override
    protected void displaySpecificDetails() {
        System.out.println("Topic: " + topic);
        System.out.println("Instructor: " + instructor);
    }
    
    @Override
    public boolean removeAttendee(String attendeeName) {
        boolean wasRemoved = getAttendees().remove(attendeeName); 
        
        if (wasRemoved) {
            System.out.println(" Successfully removed " + attendeeName + " from event " + getName() + " (" + getId() + ").");
        } else {
            System.out.println("Removal failed: " + attendeeName + " was not found in the attendee list for " + getName() + " (" + getId() + ").");
        }
        return wasRemoved;
    }
}

