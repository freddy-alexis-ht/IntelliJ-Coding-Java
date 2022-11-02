package refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringManipulatorTest {

    @Test
    void testGreetings() {
        StringManipulator ref = new StringManipulator();
        assertEquals("Hello developers", ref.greet("developers"));
    }

    @Test
    void testReplacements() {
        StringManipulator replacer = new StringManipulator();
        String replaced = replacer.applyReplacements("21 apples and 1 orange");
        assertEquals("21 apples and one orange", replaced);
    }
}
