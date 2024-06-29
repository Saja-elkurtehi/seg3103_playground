import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class CalcFrameTest {

  @Test
  void do_nothing() {
  	assertEquals(1, 1);
  }

	private void setClearscreen(CalCFrame cframe, boolean val) {
		try {
			Field f = cframe.getClass().getDeclaredField("clearscreen");
			f.setAccessible(true);
			f.setBoolean(cframe, val);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
