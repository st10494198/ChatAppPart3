package com.mycompany.chatapppart3;

import java.io.*;
import java.util.ArrayList;

public class MessageManager {

public static void saveMessage(Message message) {

    try {

        FileWriter writer =
                new FileWriter("storedMessages.json", true);

        writer.write(
                message.getMessageID() + ";" +
                message.getRecipient() + ";" +
                message.getMessage() + ";" +
                message.getFlag() +
                "\n"
        );

        writer.close();

    } catch (IOException e) {

        System.out.println("Error saving message.");
    }
}

public static ArrayList<Message> loadMessages() {

    ArrayList<Message> messages =
            new ArrayList<>();

    try {

        File file =
                new File("storedMessages.json");

        if (!file.exists()) {
            return messages;
        }

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(file));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data =
                    line.split(";");

            if (data.length == 4) {

                Message message =
                        new Message(
                                data[0],
                                data[1],
                                data[2],
                                data[3]
                        );

                messages.add(message);
            }
        }

        reader.close();

    } catch (Exception e) {

        System.out.println(
                "Error loading messages.");
    }

    return messages;
}

}
