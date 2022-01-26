package duke.managers;

import duke.commands.*;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    public void handleCommandFeedback_valid_success() {
        Parser parser = new Parser();

        try {
            //test case 1
            assertTrue(parser.parse("todo 1") instanceof StoreTodoCommand);

            //test case 2
            assertTrue(parser.parse("deadline 1") instanceof StoreDeadlineCommand);

            //test case 3
            assertTrue(parser.parse("event 1") instanceof StoreEventCommand);

            //test case 4
            assertTrue(parser.parse("list") instanceof ListCommand);

            //test case 5
            assertTrue(parser.parse("delete 1") instanceof DeleteCommand);

            //test case 6
            assertTrue(parser.parse("bye 1") instanceof ExitCommand);

            //test case 7
            assertTrue(parser.parse("mark 1") instanceof MarkCommand);

            //test case 8
            assertTrue(parser.parse("unmark 1") instanceof MarkCommand);

        } catch (Exception e) {
            System.out.println("Exception hit! Test failed");
        }
    }

    @Test
    public void handleCommandFeedback_unrecognizedCommand_error() {
        Parser parser = new Parser();
        try {
            parser.parse("abcd");
            System.out.println("Exception missed! Test failed");
        } catch (Exception e) {
            assertEquals("☹!!! I'm sorry, but I don't know what that means :-(", e.getMessage());
        }
    }


}
