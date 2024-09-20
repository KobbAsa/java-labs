import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testFindPerfectNumbersInRange() {
        List<Integer> result = Main.findPerfectNumbersInRange(1000);

        assertEquals(3, result.size());

        assertTrue(result.contains(6));
        assertTrue(result.contains(28));
        assertTrue(result.contains(496));
    }

    @Test
    public void testEmptyRange() {
        List<Integer> result = Main.findPerfectNumbersInRange(0);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSmallRange() {
        List<Integer> result = Main.findPerfectNumbersInRange(6);
        assertEquals(1, result.size());
        assertTrue(result.contains(6));
    }
}
