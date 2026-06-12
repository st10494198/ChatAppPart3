package com.mycompany.chatapppart3;

public class Message {

private String messageID;
private String recipient;
private String message;
private String flag;
private String messageHash;

public Message(String messageID,
               String recipient,
               String message,
               String flag) {

    this.messageID = messageID;
    this.recipient = recipient;
    this.message = message;
    this.flag = flag;

    generateHash();
}

private void generateHash() {

    String[] words = message.split(" ");

    String first = words[0].toUpperCase();
    String last = words[words.length - 1].toUpperCase();

    messageHash =
            messageID.substring(0, 2)
                    + ":"
                    + first
                    + last;
}

public String getMessageID() {
    return messageID;
}

public String getRecipient() {
    return recipient;
}

public String getMessage() {
    return message;
}

public String getFlag() {
    return flag;
}

public String getMessageHash() {
    return messageHash;
}

@Override
public String toString() {
    return "Message ID: " + messageID
            + "\nHash: " + messageHash
            + "\nRecipient: " + recipient
            + "\nMessage: " + message;
}

}
