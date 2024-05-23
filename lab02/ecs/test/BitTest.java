import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BitTest {

  @Test
  void constructor_default_0() {
      assertBit(0, new Bit());
  }

  @Test
  void constructor_int_ok() {
  	assertBit(0, new Bit(0));
  	assertBit(1, new Bit(1));
  }

  @Test
  void constructor_Bit() {
  	Bit b0 = new Bit(0);
  	Bit b1 = new Bit(1);
  	assertBit(0, new Bit(b0));
  	assertBit(1, new Bit(b1));
  	assertFalse(b0 == new Bit(b0));
  }

  @Test
  void constructor_int_tooSmall() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Bit(-1)
    );
  }

  @Test
  void constructor_int_tooLarge() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Bit(2)
    );
  }

  @Test
  void getIntValue() {
  	assertEquals(0, (new Bit(0)).getIntValue());
  	assertEquals(1, (new Bit(1)).getIntValue());
  }

  @Test
  void setValue() {
  	Bit b = new Bit();
  	b.setValue(0);
  	assertBit(0, b);

  	b.setValue(1);
  	assertBit(1, b);

  	b.setValue(0);
  	assertBit(0, b);
  }

  @Test
  void not() {
  	Bit b;

  	b = new Bit(0);
  	assertBit(0, b);
  	assertBit(1, b.not());
  	assertBit(0, b);

  	b = new Bit(1);
  	assertBit(1, b);
  	assertBit(0, b.not());
  	assertBit(1, b);
  }

  @Test
  void and() {
  	Bit b0 = new Bit(0);
  	Bit b1 = new Bit(1);

  	assertBit(0, b0.and(b0));
  	assertBit(0, b1.and(b0));
  	assertBit(0, b0.and(b1));
  	assertBit(1, b1.and(b1));
  }

  @Test
  void or() {
  	Bit b0 = new Bit(0);
  	Bit b1 = new Bit(1);

  	assertBit(0, b0.or(b0));
  	assertBit(1, b1.or(b0));
  	assertBit(1, b0.or(b1));
  	assertBit(1, b1.or(b1));
  }

  @Test
  void xor() {
  	Bit b0 = new Bit(0);
  	Bit b1 = new Bit(1);

  	assertBit(0, b0.xor(b0));
  	assertBit(1, b1.xor(b0));
  	assertBit(1, b0.xor(b1));
  	assertBit(0, b1.xor(b1));
  }

  @Test
  void hashCode_values() {
  	Bit b0 = new Bit(0);
  	Bit b1 = new Bit(1);

  	assertEquals(1268, b0.hashCode());
  	assertEquals(1262, b1.hashCode());
  }

  @Test
  void equals() {
  	Bit b0 = new Bit(0);
  	Bit b1 = new Bit(1);
  	Bit alsoB0 = new Bit(0);
  	Bit alsoB1 = new Bit(1);

  	assertTrue(b0.equals(alsoB0));
  	assertTrue(b1.equals(alsoB1));
  	assertFalse(b1.equals(alsoB0));
  	assertFalse(b1.equals(null));
  	assertFalse(b1.equals("garbage"));
  }

  @Test
  void toString_values() {
  	assertEquals("0", (new Bit(0)).toString());
  	assertEquals("1", (new Bit(1)).toString());
  }

  private void assertBit(int expected, Bit bit)
  {
  	assertEquals(expected + "", bit.toString());
  }
}