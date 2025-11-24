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
        System.out.println("Event Management System Initialized ");

        WorkshopEvent ws1 = new WorkshopEvent("WS001", "CyberSecurity Event", 10, "Cloud & Data Security ", "Dr. Mohammed");
        ws1.registerAttendee("Ibrahim");
        ws1.registerAttendee("Abdullah");
        ws1.registerAttendee("Bader");
        eventRegistry.put(ws1.getId(), ws1);

        WorkshopEvent ws2 = new WorkshopEvent("WS002", "Developers Event", 10, "Web Development", "Mr. Ahmed");
        ws2.registerAttendee("Faisal");
        ws2.registerAttendee("Rakan");
        eventRegistry.put(ws2.getId(), ws2);
    
        int choice = 0;
         do {
            displayMenu();
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
                executeChoice(choice);
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 6); 
        System.out.println("System Shutdown. Goodbye! ");
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. View All Events & Details");
        System.out.println("2. Register Attendee to Event");
        System.out.println("3. Find and Display Event by ID");
        System.out.println("4. List Events with Available Capacity");
        System.out.println("5. Remove Attendee from Event ");
        System.out.println("6. Exit"); 
        System.out.print("Enter choice: ");
    }

    private static void executeChoice(int choice) {
        switch (choice) {
            case 1:
                viewAllEvents();
                break;
            case 2:
                registerAttendee();
                break;
            case 3:
                findEventById();
                break;
            case 4:
                listEventsWithCapacity();
                break;
            case 5:
                removeAttendee();
                break;
            case 6: 
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void removeAttendee() {
        System.out.print("Enter Event ID to remove attendee from: ");
        String id = scanner.nextLine().trim();

        Event event = eventRegistry.get(id);

        if (event == null) {
            System.out.println("Error: Event with ID '" + id + "' not found.");
            return;
        }

        System.out.print("Enter Attendee Name to remove: ");
        String attendeeName = scanner.nextLine().trim();

        event.removeAttendee(attendeeName);
    }
    
    private static void viewAllEvents() {
          if (eventRegistry.isEmpty()) {
            System.out.println("No events currently registered.");
            return;
        }
        System.out.println("\n--- All Registered Events ---");
        for (Event event : eventRegistry.values()) {
            event.displayDetails();
        }
    }

    private static void registerAttendee() {
          System.out.print("Enter Event ID for registration: ");
        String id = scanner.nextLine().trim();

        Event event = eventRegistry.get(id);

        if (event == null) {
            System.out.println("Error: Event with ID '" + id + "' not found.");
            return;
        }

        if (event.getAvailableCapacity() <= 0) {
            System.out.println("Registration failed: Event " + event.getName() + " is already full.");
            return;
        }

        System.out.print("Enter Attendee Name: ");
        String attendeeName = scanner.nextLine().trim();

        event.registerAttendee(attendeeName);
    }

    private static void findEventById() {
          System.out.print("Enter Event ID to search: ");
        String id = scanner.nextLine().trim();

        Event event = eventRegistry.get(id);

        if (event == null) {
            System.out.println("Event with ID '" + id + "' not found.");
        } else {
            System.out.println("\n--- Event Found ---");
            event.displayDetails();
        }
    }

    private static void listEventsWithCapacity() {
        System.out.println("\n--- Events with Available Capacity ---");

        List<Event> availableEvents = eventRegistry.values().stream()
            .filter(e -> e.getAvailableCapacity() > 0)
            .collect(Collectors.toList());

        if (availableEvents.isEmpty()) {
            System.out.println("No events currently have available capacity.");
        } else {
            availableEvents.forEach(event -> {
                System.out.printf("ID: %s | Title: %s | Available Spots: %d%n",
                    event.getId(), event.getName(), event.getAvailableCapacity());
            });
        }
    }
}

}
