import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NewmathTest {

    @Test
    void div_ok() {
        assertEquals(2, Newmath.div(4, 2));
    }

    @Test
    void div_by_zero() {
      assertThrows(
        ArithmeticException.class,
        () -> Newmath.div(4, 0)
      );
    }


}