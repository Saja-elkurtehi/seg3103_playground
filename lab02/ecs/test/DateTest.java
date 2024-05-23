import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    void testValidDate() {
        Date date = new Date(2023, 5, 23);
        assertNotNull(date);
    }

    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(2023, 2, 30);
        });
    }

    @Test
    void testNextDate() {
        Date date = new Date(2023, 5, 23);
        Date nextDate = date.nextDate();
        assertEquals(new Date(2023, 5, 24), nextDate);
    }
}
