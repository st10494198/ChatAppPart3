package com.mycompany.chatapppart3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

static Scanner input = new Scanner(System.in);

static ArrayList<Message> sentMessages = new ArrayList<>();
static ArrayList<Message> storedMessages = new ArrayList<>();
static ArrayList<Message> disregardedMessages = new ArrayList<>();

static ArrayList<String> messageIDs = new ArrayList<>();
static ArrayList<String> messageHashes = new ArrayList<>();

public static void main(String[] args) {

    boolean running = true;

    while (running) {

        System.out.println("\n=== QUICKCHAT MENU ===");
        System.out.println("1. Send Message");
        System.out.println("2. Show Sent Messages");
        System.out.println("3. Quit");
        System.out.println("4. Stored Messages Menu");

        int option = input.nextInt();
        input.nextLine();

        switch (option) {

            case 1:
                sendMessage();
                break;

            case 2:
                showSentMessages();
                break;

            case 3:
                System.out.println("Goodbye!");
                running = false;
                break;

            case 4:
                storedMenu();
                break;

            default:
                System.out.println("Invalid option");
        }
    }
}

public static void sendMessage() {

    System.out.print("Enter recipient: ");
    String recipient = input.nextLine();

    System.out.print("Enter message: ");
    String text = input.nextLine();

    String id = String.valueOf(System.currentTimeMillis());

    Message msg = new Message(id, recipient, text, "Sent");

    sentMessages.add(msg);

    messageIDs.add(msg.getMessageID());
    messageHashes.add(msg.getMessageHash());

    System.out.println("Message successfully sent.");
}

public static void showSentMessages() {

    for (Message m : sentMessages) {
        System.out.println(m);
        System.out.println("--------------------");
    }
}

public static void storedMenu() {

    System.out.println("\n--- STORED MESSAGES MENU ---");
    System.out.println("1. Display sender & recipient");
    System.out.println("2. Longest stored message");
    System.out.println("3. Search Message ID");
    System.out.println("4. Search Recipient");
    System.out.println("5. Delete by Hash");
    System.out.println("6. Display Report");

    int choice = input.nextInt();
    input.nextLine();

    switch (choice) {

        case 1:
            for (Message m : storedMessages) {
                System.out.println("Recipient: " + m.getRecipient());
            }
            break;

        case 2:
            longestMessage();
            break;

        case 3:
            searchByID();
            break;

        case 4:
            searchByRecipient();
            break;

        case 5:
            deleteByHash();
            break;

        case 6:
            displayReport();
            break;
    }
}

public static void longestMessage() {

    if (storedMessages.isEmpty()) {
        System.out.println("No stored messages.");
        return;
    }

    Message longest = storedMessages.get(0);

    for (Message m : storedMessages) {
        if (m.getMessage().length() > longest.getMessage().length()) {
            longest = m;
        }
    }

    System.out.println("Longest Message:");
    System.out.println(longest.getMessage());
}

public static void searchByID() {

    System.out.print("Enter Message ID: ");
    String id = input.nextLine();

    for (Message m : storedMessages) {

        if (m.getMessageID().equals(id)) {
            System.out.println("Recipient: " + m.getRecipient());
            System.out.println("Message: " + m.getMessage());
            return;
        }
    }

    System.out.println("Message not found.");
}

public static void searchByRecipient() {

    System.out.print("Enter recipient: ");
    String rec = input.nextLine();

    for (Message m : storedMessages) {

        if (m.getRecipient().equals(rec)) {
            System.out.println("Message: " + m.getMessage());
        }
    }
}

public static void deleteByHash() {

    System.out.print("Enter message hash: ");
    String hash = input.nextLine();

    for (int i = 0; i < storedMessages.size(); i++) {

        if (storedMessages.get(i).getMessageHash().equals(hash)) {

            System.out.println("Message deleted: " +
                    storedMessages.get(i).getMessage());

            storedMessages.remove(i);
            return;
        }
    }

    System.out.println("Hash not found.");
}

public static void displayReport() {

    System.out.println("\n--- FULL MESSAGE REPORT ---");

    for (Message m : storedMessages) {

        System.out.println("ID: " + m.getMessageID());
        System.out.println("Recipient: " + m.getRecipient());
        System.out.println("Message: " + m.getMessage());
        System.out.println("Hash: " + m.getMessageHash());
        System.out.println("-------------------");
    }
}

}