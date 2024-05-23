import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class DateNextDateExceptionTest {

    @ParameterizedTest
    @CsvSource({
        "2023, 2, 30",
        "2023, 4, 31",
        "2023, 13, 1"
    })
    void testInvalidDate(int year, int month, int day) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(year, month, day);
        });
    }
}
