/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cs102_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cs102project {
     private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Event> eventRegistry = new HashMap<>();

    public static void main(String[] args) {
        // Your main method code here
        // (Keep all the main application logic but remove the class/interface definitions)
          System.out.println("Event Management System Initialized ");

        WorkshopEvent ws1 = new WorkshopEvent("WS001", "CyberSecurity Event", 15, "Cloud & Data Security ", "Dr. Mohammed");
        ws1.registerAttendee("Ibrahim");
        ws1.registerAttendee("Abdullah");
        ws1.registerAttendee("Bader");
        eventRegistry.put(ws1.getId(), ws1);

        WorkshopEvent ws2 = new WorkshopEvent("WS002", "Developers Event", 10, "Web Development", "Mr. Ahmed");
        ws2.registerAttendee("Faisal");
        ws2.registerAttendee("Rakan");
        eventRegistry.put(ws2.getId(), ws2);
    }
}
