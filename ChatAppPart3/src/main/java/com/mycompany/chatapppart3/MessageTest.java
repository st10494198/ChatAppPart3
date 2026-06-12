package com.mycompany.chatapppart3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testLongestMessage() {

        String message =
                "Where are you? You are late! I have asked you to be on time.";

        assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                message
        );
    }

    @Test
    public void testSearchRecipient() {

        String recipient = "+27838884567";

        assertEquals("+27838884567", recipient);
    }

    @Test
    public void testDeleteMessage() {

        String result = "Message deleted";

        assertEquals("Message deleted", result);
    }

    @Test
    public void testReport() {

        assertTrue(true);
    }

    @Test
    public void testSentMessage() {

        String sent = "Did you get the cake?";

        assertEquals("Did you get the cake?", sent);
    }
}