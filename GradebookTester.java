import def.GradeBook;

import static org.junit.jupiter.api.Assertions.*; // For assertions
import org.junit.jupiter.api.BeforeEach; // For setup method
import org.junit.jupiter.api.AfterEach; // For teardown method
import org.junit.jupiter.api.Test; // For test annotation


public class GradebookTester {
    private GradeBook gb1;
    private GradeBook gb2;

    @BeforeEach
    public void setUp() {
        gb1 = new GradeBook(5);
        gb2 = new GradeBook(5);

        // Add scores to gb1
        gb1.addScore(85);
        gb1.addScore(90);

        // Add scores to gb2
        gb2.addScore(70);
        gb2.addScore(80);
        gb2.addScore(90);
    }

    @AfterEach
    public void tearDown() {
        gb1 = null;
        gb2 = null;
    }

    @Test
    public void testAddScore() {
        assertTrue(gb1.addScore(95));
        assertFalse(gb1.addScore(100)); // Should fail since it would exceed capacity
    }

    @Test
    public void testGetScoreSize() {
        assertEquals(2, gb1.getScoreSize());
        assertEquals(3, gb2.getScoreSize());
    }

    @Test
    public void testToString() {
        assertEquals("85 90", gb1.toString());
        assertEquals("70 80 90", gb2.toString());
    }

    @Test
    public void testSum() {
        assertEquals(175, gb1.sum());
        assertEquals(240, gb2.sum());
    }

    @Test
    public void testMinimum() {
        assertEquals(85, gb1.minimum());
        assertEquals(70, gb2.minimum());
    }

    @Test
    public void testFinalScore() {
        assertEquals(90, gb1.finalScore()); // 175 - 85 = 90
        assertEquals(170, gb2.finalScore()); // 240 - 70 = 170
    }
}