/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import course.Introduce;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        Introduce classUnderTest = new Introduce();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}