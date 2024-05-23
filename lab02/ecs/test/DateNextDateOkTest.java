import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class DateNextDateOkTest {

    @ParameterizedTest
    @CsvSource({
        "2023, 5, 23, 2023-05-24",
        "2023, 2, 28, 2023-03-01",
        "2023, 12, 31, 2024-01-01"
    })
    void testNextDate(int year, int month, int day, String expected) {
        Date date = new Date(year, month, day);
        Date nextDate = date.nextDate();
        assertEquals(Date.parse(expected), nextDate);
    }
}
