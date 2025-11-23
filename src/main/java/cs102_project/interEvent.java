/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs102_project;

/**
 *
 * @author cyanr
 */

import java.util.List;

interface interEvent {
    boolean registerAttendee(String attendeeName);
    int getAvailableCapacity();
    void displayDetails();
    String getId();
    List<String> getAttendees();
}  

